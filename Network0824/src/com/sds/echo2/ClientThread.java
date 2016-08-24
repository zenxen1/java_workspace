/*키보드를 치지 않고도, 서버의 메세지는 언제나 무한루프로 청취해야 하므로, 별도의 쓰레드로 정의하여
 * 이작업응ㄹ 맡기자!!
 * */
package com.sds.echo2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ClientThread extends Thread {
	
	ChatClient chatClient;
	BufferedWriter buffw;
	BufferedReader buffr;
	
	public ClientThread(ChatClient chatClient) {
		this.chatClient =chatClient;
		try {
			buffr = new BufferedReader(new InputStreamReader(chatClient.client.getInputStream()));
			buffw = new BufferedWriter(new OutputStreamWriter(chatClient.client.getOutputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	//서버로부터 메세지 청취하기!!
	public void listen(){
		try {
			String data = buffr.readLine();
			chatClient.area.append(data+"\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void sendmsg(String msg){
		try {
			buffw.write(msg + "\n");
			buffw.flush(); //출력스트림은 비워야한다

			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void run() {
		while(true){
			listen();
		}
	}

}
