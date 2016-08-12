package com.sds.json;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JPanel;

import org.json.simple.JSONObject;

public class Plist extends JPanel{
	
	Canvas can;
	JPanel p;
	JLabel gen;
	JLabel name;
	JLabel age;
	Image img;
	Toolkit kit;

	public Plist(JSONObject member) {
			
			kit= Toolkit.getDefaultToolkit();
			img = kit.getImage((String)member.get("photo"));
			
			can = new Canvas(){
				public void paint(Graphics g) {
					g.drawImage(img, 0, 0, 200, 200, this);
				}
			};
			can.setPreferredSize(new Dimension(200, 200));
			can.setBackground(Color.yellow);
			gen = new JLabel("성:"+member.get("gender"));
			name = new JLabel("이름:"+member.get("name"));
			age = new JLabel("나이:"+member.get("age"));
			p = new JPanel();
			
			add(can,BorderLayout.WEST);
			p.setPreferredSize(new Dimension(400, 400));
			
			p.setLayout(new GridLayout(3, 1));
			p.add(gen);
			p.add(name);
			p.add(age);
			add(p);
	}
	
}
