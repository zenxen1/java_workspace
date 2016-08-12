package com.sds.thead;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class AnimationApp extends JFrame{
	JButton bt;
	Canvas can;
	Toolkit kit = Toolkit.getDefaultToolkit();
	Image img = kit.getImage("C:/java_workspace/GUI0812/res/Bullet.png");
	int x=0;
	Thread thread;
	
	public AnimationApp() {
		bt = new JButton("발사");
		can = new Canvas(){
			public void paint(Graphics g) {
				g.drawImage(img, x, 0, 50, 50, this);
			}
		};
		
		//쓰레드 생성
		thread = new Thread(){
			public void run(){
				while(true){
					try {
						thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					fire();
				}
			}
		};
		
		add(bt,BorderLayout.NORTH);
		add(can,BorderLayout.CENTER);
		
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				thread.start();
			}
		});
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(900, 800);
		setVisible(true);
		
	}
	public void fire(){
		x +=10;
		can.repaint();
	}

	public static void main(String[] args) {
		new AnimationApp();
	}

}
