package com.sds.gui;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ButtonE extends JFrame{
	JPanel p;
	JPanel c;
	JButton bt1;
	JButton bt2;
	
	
	public ButtonE() {
		p= new JPanel();
		c= new JPanel();
		bt1= new JButton("추가");
		bt2 = new JButton("색상변경");
		
		
		p.add(bt1);
		p.add(bt2);
		
		add(p,BorderLayout.NORTH);
		add(c);
		
		bt1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//Object obj = e.getSource();
			//	System.out.println(obj);
				addbutton();
			}
		});
		bt2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//Object obj = e.getSource();
			//	System.out.println(obj);
				Colorc();
			}
		});
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600, 600);
		setVisible(true);
		
	}
	
	public void addbutton(){
		JButton bt = new JButton("나버튼");
		c.add(bt);
		c.updateUI();
			
	}
		
	public void Colorc(){
		
	}
	
	

	public static void main(String[] args) {
		
		new ButtonE();
	}

}
