package com.sds.gui;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class EventTest2 extends JFrame{
	JButton bt;
	JTextField txt;
	MyListener ml;
	
	public EventTest2(){
		bt = new JButton("버튼");
		txt = new JTextField(20);
		ml = new MyListener();
		
		setLayout(new FlowLayout());
		
		add(bt);
		add(txt);
		
		bt.addActionListener(ml);
		//bt.addActionListener(new MyListener());
		System.out.println("setET 메서드 호출전 내 주소값"+this);
		ml.setEt(this); //call by reference
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setSize(300, 400);
		
	}

	public static void main(String[] args) {
		new EventTest2();

	}

}
