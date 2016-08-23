package com.sds.echo;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClient extends JFrame implements ActionListener{
	
	JScrollPane scroll;
	JTextArea area;
	JTextField tf;
	JButton bt;
	JPanel p;
	Socket client; //��ȭ�� ����(������ = ��ȭ��)
	String ip="70.12.112.96";
	int port = 8888;
	
	BufferedReader buffr;//2�Է¿� ��Ʈ��
	BufferedWriter buffw;//����� ��Ʈ��
	
	public ChatClient() {
		area = new JTextArea();
		scroll = new JScrollPane(area);
		tf = new JTextField(15);
		bt = new JButton("����");
		p = new JPanel();
		
		add(scroll);
		p.add(tf);
		p.add(bt);
		add(p,BorderLayout.SOUTH);
		
		bt.addActionListener(this);
		
		//1 �ؽ�Ʈ �ʵ�� ������ ����
		tf.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				int key=e.getKeyCode();
				if(key == KeyEvent.VK_ENTER){
					//������ �޼��� ������
					sendMsg();
					tf.setText("");
				}
			}
		});
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300,400);
		setVisible(true);
	}
	//������ �����ϴ� �޼��� ����
	public void connect(){
		//ip�� ��Ʈ ��ȣ�� �̿��Ͽ� ������ ����!!
		try {
			client = new Socket(ip,port);
			//3. ������ �������ڸ��� ����½�Ʈ�� ����
			buffr = new BufferedReader(new InputStreamReader(client.getInputStream()));
			buffw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			
			
		} catch (UnknownHostException e) {
			System.out.println("ip�� Ȯ�����ּ���");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("��Ʈ��ũ�� Ȯ�����ּ���");
			e.printStackTrace();	
		}
		
	}
	
	public void sendMsg(){
		String msg = tf.getText();
		try {
			//4.������
			buffw.write(msg+"\n");
			buffw.flush();
			//�ް�
			String data = buffr.readLine();
			area.append(data+"\n");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
		
	}
	
	
	public void actionPerformed(ActionEvent e) {
		connect();
	}
	
	public static void main(String[] args) {
		new ChatClient();

	}

}
