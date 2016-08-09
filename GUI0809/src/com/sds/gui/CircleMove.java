package com.sds.gui;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CircleMove extends JFrame {
	JPanel p_north;
	JButton bt_left, bt_right, bt_up,bt_down;
	Canvas can;
	JButton[] btn = new JButton[4];
	int x=100; //��������� �����͸� Ŭ������ ���� ����
	int y=100;
	
	public CircleMove() {
		p_north = new JPanel();
		
		bt_left = new JButton("Left");
		bt_right = new JButton("Right");
		bt_up = new JButton("Up");
		bt_down = new JButton("Down");
		
		
		btn[0]=bt_left;
		btn[1]=bt_right;
		btn[2]=bt_up;
		btn[3]=bt_down;
		
		
		can = new Canvas(){
			public void paint(Graphics g) {
				//������ �ֵ��Ͽ� �׷��� ó������!!
				g.drawOval(x, y, 40, 40);
			}
		};
		add(can);
		
		p_north.add(bt_left);
		p_north.add(bt_right);
		p_north.add(bt_up);
		p_north.add(bt_down);
		
		add(p_north,BorderLayout.NORTH);
		
		//��ư�� �����ʿ��� ����
		final int k=9;
		
		for(int i=0;i<btn.length;i++){
			btn[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Object obj=e.getSource();
					JButton b=(JButton)obj;
					System.out.println(b.getText()+"����");
					
					switch(b.getText()){
						case "Left" : moveHorizen(-5);break;
						case "Right" : moveHorizen(5);break;
						case "Up" : moveVertical(-5);break;
						case "Down" : moveVertical(5);break;
						
					}
					
					
					/*if(b.equals(bt_left)){
						System.out.println("������");
						x++;
						can.repaint();
					}*/
					
					//x=3;
					//System.out.println(k); //�����͸�Ŭ�������� �������������� �ȵȴ�. �ٸ� ���̳��� ����..
				}
			});
		}
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600, 600);
		setVisible(true);
	}
	
	//�¿� �̵� �޼���
	public void moveHorizen(int x){
		this.x += x;
		can.repaint();
	}
		
	//���Ʒ� �̵� �޼���
	public void moveVertical(int y){
		this.y+=y;
		can.repaint();
	}
	
	public static void main(String[] args){
		new CircleMove();
	}

}
