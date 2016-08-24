/*1.Echo 시스템
 *   단점 - 오직 1인의 접속자만 처리할 수 있다!!
 * 2.Unicating
 *   메세지를 보낼 대상이 1명
 * 3.Multicasting
 * 
 *에코 서버를 GUI로 구축하자!!
 * */

package com.sds.echo2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUIServer extends JFrame implements ActionListener, Runnable{
	JPanel p_north;
	JTextField t_port;
	JButton bt;
	JTextArea area;
	JScrollPane scroll;
	ServerSocket server; //1.접속 감지용 소켓!!! 대화용x, 노드js의 http모듈
	Thread acceptTread; //3.접속자 감지용 쓰레드
	BufferedReader buffr;
	BufferedWriter buffw;
	Vector <ServerThread>list = new Vector<ServerThread>();// ArrayList와 기능은 동일하나 동시성 문제에 있어서는 동기화를 지원해주므로, 쓰레드에 안전하다

	
	public GUIServer() {
		p_north = new JPanel();
		t_port = new JTextField("8888",7);
		bt = new JButton("가동");
		area = new JTextArea();
		scroll = new JScrollPane(area);
		
		area.setBackground(Color.YELLOW);
		p_north.add(t_port);
		p_north.add(bt);
		add(p_north,BorderLayout.NORTH);
		add(scroll);
		
		bt.addActionListener(this);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(600, 100, 300, 400);
		setVisible(true);
		
	}
	//서버 가동 메서드
	public void startServer(){
		String port = t_port.getText();
		try {
			server = new ServerSocket(Integer.parseInt(port));
			area.append("서버 생성완료!!\n");
			
			
			
			while(true){
			Socket client = server.accept(); //무한대기에 빠진다!!
			String ip = client.getInetAddress().getHostAddress();
			
			area.append(ip+"님접속!!\n");
			
			//클라이언트의 접속이 감지되면, 소켓을 얻어서 보관해 놓는다
			ServerThread ct = new ServerThread(client,area,list);
			ct.start();
			
			//생성된 쓰레드를 접속자 명단에 추가하자!!
			list.add(ct);
			area.append("현재 "+list.size()+"명\n");
			
			}
			
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "포트번호는 숫자로 넣어으세요!!");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void run(){
		startServer();
	}
	
	public void actionPerformed(ActionEvent arg0) {
		//2.접속자 감지하기 위해 가동!!
		acceptTread = new Thread(this);
		acceptTread.start();
		
		//4.버튼 비활성화
		bt.setEnabled(false);
	}
	
	public static void main(String[] args) {
		new GUIServer();
	}

}
