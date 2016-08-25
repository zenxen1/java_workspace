package com.sds.client;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AppMain extends JFrame{
	JPanel p_north;
	JButton[] btn = new JButton[4];
	JPanel[] p_content=new JPanel[4];
	String[] iconPath = {"1.png","2.png","3.png","4.png"};
	URL url;
	Color[] bg={Color.RED,Color.YELLOW,Color.BLUE,Color.GREEN};
	
	JPanel p_center;
	
	public AppMain() {
		p_north = new JPanel();
		p_north.setPreferredSize(new Dimension(500, 50));
		p_north.setLayout(new GridLayout(1, 4));
		
		p_center = new JPanel();
		p_center.setLayout(new CardLayout());
		p_center.setPreferredSize(new Dimension(400, 450));
		
		for(int i=0;i<btn.length;i++){
			URL url = this.getClass().getClassLoader().getResource(iconPath[i]);
			ImageIcon icon = new ImageIcon(url);
			Image img=icon.getImage();
			img.getScaledInstance(10, 10, Image.SCALE_SMOOTH);
			icon.setImage(img);
			
			btn[i] = new JButton(icon);
			p_north.add(btn[i]);
			p_content[i] = new JPanel();
			p_content[i].setBackground(bg[i]);
			p_content[i].setPreferredSize(new Dimension(400, 450));
			//p_content[i].setVisible(false);
			//add(p_content[i]); //프레임 센터에 부착
						
		}
		p_center.add(p_content[3]);
		
		
		p_content[0].setVisible(true);
		add(p_center);
		
		add(p_north,BorderLayout.NORTH);
		setSize(450, 500);
		setVisible(true);
		
	}
	public static void main(String[] args){
		new AppMain();
	}
	
}
