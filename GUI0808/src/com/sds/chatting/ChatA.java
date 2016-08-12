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
	
	
	public ChatA(){ //컨트롤 + 스페이스
		area = new JTextArea();
		p = new JPanel();
		txt = new JTextField(15);
		bt = new JButton("새창");
		//스크롤을 적용하고자하는 컴포넌트를 인수로 넘긴다!!
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
		//버튼을 누르면, 새창을 띄우면서 그 주소값도 보관하자!!
		
		chatB = new ChatB(this);
		
		bt.setEnabled(false);
		//txt.requestFocus();//포커스 올리기
		
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
			//area에 데이터 출력
			String msg = txt.getText();
			area.append(msg+"\n");
			//입력메세지 초기화
			txt.setText("");
			
			//ChaB의 area에 값을 누적하자!!
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
