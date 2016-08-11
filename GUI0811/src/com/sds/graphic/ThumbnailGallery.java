package com.sds.graphic;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ThumbnailGallery extends JFrame {
	JPanel p_right;
	JPanel p_left;
	Image currentImg;
	String[] path = { 
			"C:/java_workspace/GUI0811/res/볼1.png", 
			"C:/java_workspace/GUI0811/res/볼2.png",
			"C:/java_workspace/GUI0811/res/볼3.png", 
			"C:/java_workspace/GUI0811/res/볼4.png",
			"C:/java_workspace/GUI0811/res/볼5.png", 
			"C:/java_workspace/GUI0811/res/볼6.png",
			"C:/java_workspace/GUI0811/res/볼7.png", 
			"C:/java_workspace/GUI0811/res/볼8.png",
			"C:/java_workspace/GUI0811/res/볼9.png", 
			"C:/java_workspace/GUI0811/res/볼10.png" };
	Toolkit kit;
	MyCanvas[] can = new MyCanvas[path.length];

	public ThumbnailGallery() {
		
		p_left = new JPanel();

		for (int i = 0; i < path.length; i++) {
			can[i] = new MyCanvas(path[i],this);
			can[i].setPreferredSize(new Dimension(100, 100));
			p_left.add(can[i]);
		}
		
		//currentImg = can[0].img;
		p_right = new JPanel() {
			public void paint(Graphics g) {
				g.drawImage(currentImg, 0, 0, 400, 400, this);
			}
		};
		//p_right.setPreferredSize(new Dimension(40, 60));
		
		p_left.setBackground(Color.yellow);
		p_right.setBackground(Color.blue);

		setLayout(new GridLayout(1, 2));

		add(p_left);
		add(p_right);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800, 500);
		setVisible(true);

	}

	public static void main(String[] args) {
		new ThumbnailGallery();

	}

}
