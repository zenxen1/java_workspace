package com.sds.chatting;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatA extends JFrame implements ActionListener,KeyListener{
	JTextArea area;
	JPanel p;
	JTextField txt;
	JButton bt;
	JScrollPane scroll;
	ChatB chatB;
	
	
	public ChatA(){ //��Ʈ�� + �����̽�
		area = new JTextArea();
		p = new JPanel();
		txt = new JTextField(15);
		bt = new JButton("��â");
		//��ũ���� �����ϰ����ϴ� ������Ʈ�� �μ��� �ѱ��!!
		scroll = new JScrollPane(area);
		
		add(scroll);
				
		p.add(txt);
		p.add(bt);
		add(p,BorderLayout.SOUTH);
		
		bt.addActionListener(this);
		txt.addKeyListener(this);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 200, 300, 400);
		setVisible(true);
	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//��ư�� ������, ��â�� ���鼭 �� �ּҰ��� ��������!!
		
		chatB = new ChatB(this);
		
		bt.setEnabled(false);
		//txt.requestFocus();//��Ŀ�� �ø���
		
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_ENTER){
			//area�� ������ ���
			String msg = txt.getText();
			area.append(msg+"\n");
			//�Է¸޼��� �ʱ�ȭ
			txt.setText("");
			
			//ChaB�� area�� ���� ��������!!
			chatB.area.append(msg+"\n");
			chatB.chatC.area.append(msg+"\n");
	
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ChatA();
	}

	

}
