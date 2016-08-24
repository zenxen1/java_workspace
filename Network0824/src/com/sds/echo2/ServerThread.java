package com.sds.echo2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Vector;

import javax.swing.JTextArea;

public class ServerThread extends Thread{
	Socket client;
	BufferedReader buffr;
	BufferedWriter buffw;
	JTextArea area;
	Vector< ServerThread> list;
	boolean flag=true; //������ ����� �����带 ������·� ���� ���� ����!! �� While�� ���߱�!!
	
	public ServerThread(Socket client,JTextArea area,Vector< ServerThread> list ) {
		this.client = client;
		this.area = area;
		this.list =list;
		try {
			buffr = new BufferedReader(new InputStreamReader(client.getInputStream()));
			buffw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//���
	public void listen(){
		try {
			while(flag){
				String msg = buffr.readLine();
				//����͸� area ���!!
				area.append(msg+"\n");
				
				//������ �������ִ� ��� serveTread �ν��Ͻ��� ����ż��� ȣ��
				for(int i=0;i<list.size();i++){
					ServerThread st = list.get(i);
					st.sendMsg(msg);
				}
			}
		} catch (IOException e) {
			//e.printStackTrace();
			area.append("������ �ųʾ��� �������!!\n");
			//������ �������� ó��...
			flag=false; //���ѷ��� ����������
			//��ܿ��� ����...
			list.remove(this);
			area.append("��ȭ���� �������ϴ�. ���� ��ȭ ������"+list.size()+"��\n");
		}
	}
	
	//���ϰ�
	public void sendMsg(String msg){
		try {
			buffw.write(msg+"\n");
			buffw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//���������� ������ �ڵ�� RUN���� �ۼ�
	public void run(){
		listen();
	}
	
}
