package com.sds.gallery;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Gallery extends JFrame implements ActionListener {
	XCanvas can;
	JPanel p;
	JButton bt_prev;
	JButton bt_next;
	JTextField txt;
		
	public Gallery() {
		can = new XCanvas();
		p = new JPanel();
		bt_prev = new JButton("이전");
		bt_next = new JButton("다음");
		txt = new JTextField(30);
		p.add(bt_prev);
		p.add(txt);
		p.add(bt_next);
		
		add(can,BorderLayout.CENTER);
		add(p,BorderLayout.SOUTH);
		
		//리스너와 버튼 연결
		bt_prev.addActionListener(this);
		bt_next.addActionListener(this);
		
		txt.setText(can.path[can.count]);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(700, 650);
		setVisible(true);
	}
	//이미지 보여주기 
	public void prev(){
		if(can.count <= 0){
			JOptionPane.showMessageDialog(this, "더이상이미지가 없다");
			return;
		}
		can.count--;
		can.repaint();
		txt.setText(can.path[can.count]);
	}
	//다음 이미지 보여주기
	public void next(){
		if(can.count>=9){
			JOptionPane.showMessageDialog(this, "더이상이미지가 없다");
			return;
		}
		//XCanvas 접근한 count 변수를 1 증가!!
		can.count++;
		//repaint()--> update() 화면 지움 -->paint() 다시그림
		can.repaint();
		txt.setText(can.path[can.count]);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj.equals(bt_prev)){
			prev();
		}else if(obj.equals(bt_next)){
			next();
		}
	}
	
	public static void main(String[] args) {
		new Gallery();
	}

	
}
