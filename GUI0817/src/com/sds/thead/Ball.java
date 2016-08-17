package com.sds.thead;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Ball extends JFrame{
	JButton bt;
	Canvas can;
	Toolkit kit;
	Image img;
	Thread thread;
	int x;
	boolean flag = true;
	
	public Ball() {
		bt = new JButton("임시");
				
		thread = new Thread(){
			public void run(){
				while(true){
					
					try {
						thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					x+=5;
					can.repaint();
				}
			}
		};
		
		can = new Canvas(){
			public void paint(Graphics g) {
				g.drawOval(x, 0, 100, 100);
			}
		};
		
		add(can);
		
		addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
				
			}
			
			public void keyReleased(KeyEvent e) {
				
			}
			
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				if(key == KeyEvent.VK_SPACE){
					x=0;
					if(flag){
						thread.start();
						flag=false;
					}
				}
				
			}
		});
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//윈도우를 모니터 크기와 상관없이 항상 가운데 띄우기!!
		setLocationRelativeTo(null);
		setSize(800, 400);
		setVisible(true);
	
	}
	
	public static void main(String[] args) {
		new Ball();
	}

}
