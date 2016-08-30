/*
 * ���������ڰ� ���� ����͸� �ϱ�����  GUI ��� ������
 * �����ϰڴ�!! ��� �����ڴ� ���...
 * */
package com.sds.server;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ServerMain extends JFrame implements Runnable, ActionListener{
	JPanel p_north;
	JTextField t_port;
	JButton bt;
	JTextArea area;
	JScrollPane scroll;
	
	//���ξ������ ���μ����� ��ϴ� �������� ���Ǿ��
	//�ϴ� ������̹Ƿ�, ���� ���ѷ����� �����·� ������
	//�ϸ� �ȵȴ�!!! ( �ȵ���̵峪 �������� �ƿ� ����)
	//�ټ��� �����ڸ� �ǽð����� �޾Ƶ��̱� ���ؼ��� ������
	//����θ� �����Ͽ� while ������ = ������ �̿�~
	Thread acceptTread;
	ServerSocket server;
	int port=9090;
	
	//����̹� ���
	String driver="oracle.jdbc.driver.OracleDriver";
	
	//��������
	String url="jdbc:oracle:thin:@localhost:1521:XE";
	String user="java0819";
	String password="java0819";
	
	Connection con;
	
	public ServerMain() {
		p_north = new JPanel();
		t_port = new JTextField(Integer.toString(port), 4);
		bt=new JButton("����");
		area = new JTextArea();
		scroll = new JScrollPane(area);
		
		area.setBackground(Color.YELLOW);
		p_north.add(t_port);
		p_north.add(bt);


		add(p_north, BorderLayout.NORTH);
		add(scroll);
		
		bt.addActionListener(this);
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				//�����ͺ��̽� ��������!!
				if(con!=null){
					try {
						con.close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				//���μ��� ����
				System.exit(0);
			}
		});
		
		setBounds(400,100, 400, 500);
		setVisible(true);
		
	}
	
	//������ ����!! (���ѷ�����.....)
	public void run(){
		startServer();
	}
	
	//���� ���� �޼��� 
	public void startServer(){
		try {
			server = new ServerSocket(port);
			area.append("���� ���� �Ϸ�..\n");
			
			
			//����Ŭ ����!!
			try {
				Class.forName(driver);
				con=DriverManager.getConnection(url, user, password);
				if(con !=null){
					setTitle("����Ŭ ���� ����");
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			while(true){
				Socket client=server.accept();
				ServerThread st = new ServerThread(this,client);
				st.start();
				area.append("������ ����!!\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void actionPerformed(ActionEvent arg0) {
		acceptTread = new Thread(this);
		acceptTread.start();
		bt.setEnabled(false);
	}
	
	public static void main(String[] args) {
		new ServerMain();
	}
}









