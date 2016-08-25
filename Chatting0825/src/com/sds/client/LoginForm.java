package com.sds.client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class LoginForm extends JFrame implements ActionListener{
	JTextField tf;
	JPasswordField tf2;
	JButton bt;
	JButton bt2;
	JPanel pl;
	JPanel pl_ct;
	JPanel pl_ct2;
	JPanel pl_ct3;
	JLabel lb;
	JLabel lb2;
	JLabel lb3;
	
	//로그인 이전에 이미 소켓 접속을 확보해놓자!!
	String ip="70.12.112.103";
	int port=7777;

	Socket client;
	BufferedReader buffr;
	BufferedWriter buffw;
	
	
	public LoginForm() {
		super("LOGIN");
		lb = new JLabel("로그인",0);
		lb2 = new JLabel("ID");
		lb3 = new JLabel("PW");
		bt = new JButton("Login");
		bt2 = new JButton("Sign");
		tf = new JTextField(15);
		tf2 = new JPasswordField(15);
		pl = new JPanel();
		pl_ct = new JPanel();
		pl_ct2 = new JPanel();
		pl_ct3 = new JPanel();
		
		tf.setBackground(Color.yellow);
		tf2.setBackground(Color.yellow);
		
		pl.add(bt);
		pl.add(bt2);		
		
		pl_ct.add(lb2);
		pl_ct.add(tf);
		pl_ct2.add(lb3);
		pl_ct2.add(tf2);
		pl_ct3.add(pl_ct);
		pl_ct3.add(pl_ct2);
		
		lb.setPreferredSize(new Dimension(130, 20));
		lb2.setPreferredSize(new Dimension(70, 20));
		lb3.setPreferredSize(new Dimension(70, 20));
		bt.setPreferredSize(new Dimension(80, 20));
		bt2.setPreferredSize(new Dimension(80, 20));
				
		add(lb,BorderLayout.NORTH);
		add(pl_ct3,BorderLayout.CENTER);
		//add(pl_ct2,BorderLayout.CENTER);
		//add(lb2,BorderLayout.CENTER);
		//add(lb3,BorderLayout.CENTER);
		//add(tf,BorderLayout.CENTER);
		//add(tf2,BorderLayout.CENTER);
		add(pl,BorderLayout.SOUTH);
				
				
		//버튼과 리스너연결 
		bt.addActionListener(this);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(350,180);
		setVisible(true);
		
		connect();
	}
	
	//프로그램이 가동되면, 서버에 소켓 연결을 시도하자!!
	public void connect(){
		try {
			client = new Socket(ip, port);
			setTitle("서버에 접속됨");
			
			buffr = new BufferedReader(new InputStreamReader(client.getInputStream()));
			buffw=new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void loginCheck(){
		//4.소켓 서버에 인증을 요청한다!!
		String id=tf.getText(); //id
		String password=new String(tf2.getPassword());
		
		StringBuffer sb = new StringBuffer();		
		sb.append("{");
		sb.append("\"request\":\"login\",");
		sb.append("\"id\" : \""+id+"\",");
		sb.append("\"password\" : \""+password+"\"");
		sb.append("}");
		
		//아이디와 패스워드 전송!
		try {
			buffw.write(sb.toString()+"\n");
			buffw.flush();
			
			//서버로 부터 전송되어온 요청 처리 결과 제이슨!!
			String msg = buffr.readLine();
			System.out.println(msg);
			//6. 파씽시작
			JSONParser parser = new JSONParser();
			JSONObject jsonObject = (JSONObject)parser.parse(msg);
			if(jsonObject.get("result").equals("ok")){
				JSONObject obj = (JSONObject)jsonObject.get("data");
				String name = (String)obj.get("name");
				
				JOptionPane.showMessageDialog(this,name+ "성공");
				//채팅 메인 띄우기
				AppMain app = new AppMain();
				
				
			}else if(jsonObject.get("result").equals("fail")){
				JOptionPane.showMessageDialog(this, "실패");
				
			}
			
			
		} catch (IOException e) {
		e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		loginCheck();
	}
	
	public static void main(String[] args) {
		new LoginForm();

	}

}






