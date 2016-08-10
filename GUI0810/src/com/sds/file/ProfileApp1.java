package com.sds.file;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ProfileApp1 extends JFrame{
	
	Canvas can;
	JButton bt;
	JLabel la;
	JPanel p;
	
	public ProfileApp1() {
		p = new JPanel();
		bt = new JButton("파일찾기");
		la = new JLabel("파일경로");
		can = new Canvas(){
			Toolkit kit = Toolkit.getDefaultToolkit();
			
			String path = "C:/java_workspace/GUI0810/res1/profile.png";
			Image img = kit.getImage(path);
			
			public void paint(Graphics g) {
				g.drawImage(img, 0, 0, 500, 500, Color.yellow, this);
			}
			
		};
		
		can.setPreferredSize(new Dimension(500, 500));	
		this.setBackground(Color.yellow);
		p.setBackground(Color.yellow);
		p.add(bt);
		p.add(la);
		
		add(can,BorderLayout.WEST);
		add(p,BorderLayout.CENTER);
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(650, 550);
		setVisible(true);
		
	}
	

	public static void main(String[] args) {
		new ProfileApp1();

	}

}
