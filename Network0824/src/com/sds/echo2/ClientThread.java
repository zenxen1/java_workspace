/*Ű���带 ġ�� �ʰ�, ������ �޼����� ������ ���ѷ����� û���ؾ� �ϹǷ�, ������ ������� �����Ͽ�
 * ���۾����� �ñ���!!
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
	
	//�����κ��� �޼��� û���ϱ�!!
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
			buffw.flush(); //��½�Ʈ���� ������Ѵ�

			
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
