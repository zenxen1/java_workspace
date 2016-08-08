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
		bt_prev = new JButton("����");
		bt_next = new JButton("����");
		txt = new JTextField(30);
		p.add(bt_prev);
		p.add(txt);
		p.add(bt_next);
		
		add(can,BorderLayout.CENTER);
		add(p,BorderLayout.SOUTH);
		
		//�����ʿ� ��ư ����
		bt_prev.addActionListener(this);
		bt_next.addActionListener(this);
		
		txt.setText(can.path[can.count]);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(700, 650);
		setVisible(true);
	}
	//�̹��� �����ֱ� 
	public void prev(){
		if(can.count <= 0){
			JOptionPane.showMessageDialog(this, "���̻��̹����� ����");
			return;
		}
		can.count--;
		can.repaint();
		txt.setText(can.path[can.count]);
	}
	//���� �̹��� �����ֱ�
	public void next(){
		if(can.count>=9){
			JOptionPane.showMessageDialog(this, "���̻��̹����� ����");
			return;
		}
		//XCanvas ������ count ������ 1 ����!!
		can.count++;
		//repaint()--> update() ȭ�� ���� -->paint() �ٽñ׸�
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
