/*
ȸ�� 1���� �����ϴ� ������ Ŭ���� ����!!
*/
package com.sds.client.chatting;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sds.client.AppMain;

public class Item extends JPanel implements ActionListener{
	JLabel la_profile;
	JLabel la_status;
	ImageIcon icon;
	JButton bt;
	long you;

	//��ü ������ �̹��� ��ο� ���¸޼����� �Ѱܹ���!!
	public Item(String path, String status, long you){
		this.you=you;
		
		URL url=this.getClass().getClassLoader().getResource(path);
		icon = new ImageIcon(url);
		la_profile = new JLabel(icon);
		la_status = new JLabel(status);
		bt = new JButton("ģ���α�");
		
		setLayout(new BorderLayout());
		add(la_profile, BorderLayout.WEST); //���ʿ� ����
		add(la_status);//���Ϳ� ����
		add(bt, BorderLayout.EAST);
		setPreferredSize(new Dimension(400, 60));
		
		bt.addActionListener(this);
	}
	public void makeFriend(){
		System.out.println(AppMain.me+"�� "+you+"~�� ģ���α�!!");
		
		//���̽����� ��û~~
	}
	
	public void actionPerformed(ActionEvent e) {
		makeFriend();
	}	
}











