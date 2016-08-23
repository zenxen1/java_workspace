/*1.�ڹپ��� ��Ʈ��ũ ���α׷��� �ۼ��� �� ������,
 * java.net ��Ű������ ��κ� �����Ѵ�
 *  */
package com.sds.network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
	ServerSocket server;
	int port=7777; //1~1024������ �̹� �ý����� �����ϴ� ��Ʈ�̹Ƿ� ����ؼ��� �ȵȴ�....
	                        //�׸��� ����Ŭ mysql�� �� �˷��� ����Ʈ������ ��Ʈ ��ȣ�� ���ذ��� �Ѵ�..
	InputStreamReader reader;
	BufferedReader buffr;
	
	OutputStreamWriter writer;
	BufferedWriter buffw;
	
	public ChatServer() {
		
		try {
			server=new ServerSocket(port);//2.���� ����
			System.out.println("���� ���� ����");
			Socket client = server.accept(); //3. Ŭ���̾�Ʈ�� ������ �޾Ƶ��̴� �޼��� ����)�� �޼���� ������ ���������� �����¿� ������
			System.out.println("������ �߰�!!!");
			
			//socket���� ���� Ŭ���̾�Ʈ�� ���õ� ������ ���ԵǾ� ����..
			//Ŭ���̾�Ʈ�� ip ���� ����...
			String ip=client.getInetAddress().getHostAddress();
			System.out.println(ip+"�����ڹ߰�");
			
			//4.������ �ޱ�� ��Ʈ��
			InputStream is = client.getInputStream();
			reader = new InputStreamReader(is);
			buffr = new BufferedReader(reader);
			
			//5.������ ��¿� ��Ʈ��
			OutputStream os = client.getOutputStream();
			writer = new OutputStreamWriter(os);
			buffw = new BufferedWriter(writer);
						
			String data;
			while(true){
				data = buffr.readLine(); //3. �����Ͱ� �Էµɶ����� ����(���Ѵ��)�� ������..
				System.out.println(data);
				
				//6.����
				buffw.write(data+"\n");
				//��½�Ʈ�� �迭��, ���۽� ��½�Ʈ������ �����ϴ� ��� ������ ������ �Ѵ�...
				buffw.flush();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new ChatServer();
	}

}
