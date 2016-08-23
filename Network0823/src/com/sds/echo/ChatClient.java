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
	Socket client; //대화용 소켓(종이컵 = 전화기)
	String ip="70.12.112.96";
	int port = 8888;
	
	BufferedReader buffr;//2입력용 스트림
	BufferedWriter buffw;//출려용 스트림
	
	public ChatClient() {
		area = new JTextArea();
		scroll = new JScrollPane(area);
		tf = new JTextField(15);
		bt = new JButton("접속");
		p = new JPanel();
		
		add(scroll);
		p.add(tf);
		p.add(bt);
		add(p,BorderLayout.SOUTH);
		
		bt.addActionListener(this);
		
		//1 텍스트 필드와 리스너 연결
		tf.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				int key=e.getKeyCode();
				if(key == KeyEvent.VK_ENTER){
					//서버에 메세지 보내기
					sendMsg();
					tf.setText("");
				}
			}
		});
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300,400);
		setVisible(true);
	}
	//서버에 접속하는 메서드 정의
	public void connect(){
		//ip와 포트 번호를 이용하여 서버에 접속!!
		try {
			client = new Socket(ip,port);
			//3. 소켓이 생성되자마자 입출력스트림 생성
			buffr = new BufferedReader(new InputStreamReader(client.getInputStream()));
			buffw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			
			
		} catch (UnknownHostException e) {
			System.out.println("ip를 확인해주세요");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("네트워크를 확인해주세용");
			e.printStackTrace();	
		}
		
	}
	
	public void sendMsg(){
		String msg = tf.getText();
		try {
			//4.보내고
			buffw.write(msg+"\n");
			buffw.flush();
			//받고
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
