package com.sds.shopping.client.main;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ClientMain extends JFrame implements ActionListener{
	JPanel p_north;
	JPanel p_container;//ȭ����ȯ�� ���� �߽� �г�..
	JButton[] menu;
	String[] menuTitle={"����","����","�׼�����","�Ź�","MyPage","��ٱ���"};
	
	ProductMain productMain;
	JScrollPane scroll;
	
	
	public ClientMain() {
		p_north = new JPanel();
		p_container = new JPanel();
		scroll = new JScrollPane(p_container);
		
		menu = new JButton[menuTitle.length];
		
		for(int i=0;i<menu.length;i++){
			menu[i] = new JButton(menuTitle[i]);
			menu[i].addActionListener(this);
			p_north.add(menu[i]);
		}
		
		productMain = new ProductMain();
		p_container.add(productMain);
		
		add(p_north, BorderLayout.NORTH);
		add(scroll);
		
		setSize(800,750);
		setVisible(true);
		
	}
	public static Connection getConnection(){
		String driver="oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String user="shop";
		String password="shop";
		Connection con=null;
		
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,user,password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}
	public static void main(String[] args) {
		new ClientMain();
	}
}
