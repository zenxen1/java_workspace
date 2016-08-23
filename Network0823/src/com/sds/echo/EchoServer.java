package com.sds.echo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	ServerSocket server;//��ȭ�� x, ���� ������ O
	BufferedReader buffr;
	BufferedWriter buffw;
	
	
	public EchoServer() {
		try {
			server = new ServerSocket(8888); //��������
			System.out.println("��������");
			Socket client = server.accept();//������ ����!!(��ȭ�ޱ�), �����̶�? ��Ʈ��ũ�� ����������� �߻�ȭ�� ��ü ���� ������
			                                                //�� ��Ʈ��ũ�� ������ ����Ǹ�, ��� �÷��������� ������ �� �� �ִ�.
			String ip = client.getInetAddress().getHostAddress();
			System.out.println(ip + "�����ڹ߰�");
			
			//�Է°� ����� ���ѷ����� ó��
			buffr = new BufferedReader(new InputStreamReader(client.getInputStream()));
			buffw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			
			String data=null;
			while(true){
				data = buffr.readLine(); // Ŭ���̾�Ʈ�� �޼��� �ޱ�!!(�Է�)
				System.out.println(data);
				
				//Ŭ���̾�Ʈ���� �ٽ� ������
				buffw.write(data+"\n");//������ ������ ���˷�����Ѵ�..
				buffw.flush();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
	}
	
	public static void main(String[] args) {
		new EchoServer();
	}

}
