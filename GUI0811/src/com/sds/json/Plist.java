package com.sds.json;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Plist extends JPanel{
	JPanel p;
	JLabel gen;
	JLabel name;
	JLabel age;
	Image img;
	Toolkit kit;
	String url ="C:/java_workspace/GUI0811/res/��1.png";
	
	public Plist() {
		kit = Toolkit.getDefaultToolkit();
		img = kit.getImage(url);
		
		p = new JPanel(){
			protected void paintComponent(Graphics g) {
				g.drawImage(img, 0, 0, 100, 100, this);
			}
		};
		
		//gen = new JLabel("��");
		//name = new JLabel("�̸�");
		//age = new JLabel("����");
		
		add(p);
		//add(gen);
		//add(name);
		//add(age);
	
	}

}
