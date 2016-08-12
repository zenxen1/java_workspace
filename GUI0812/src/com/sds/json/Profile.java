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

public class Profile extends JPanel{
	JPanel p_west;
	Canvas can;
	JPanel p_center;
	Toolkit kit;
	Image img;
	
	JLabel la_name,la_gender,la_age;
	
	public Profile(String url) {
		p_west = new JPanel();
		kit = Toolkit.getDefaultToolkit();
		img = kit.getImage(url);
		can = new Canvas(){
			
			public void paint(Graphics g) {
				g.drawImage(img, 0, 0, 100, 100, this);
				
			}
		};
		p_center = new JPanel();
		la_name = new JLabel("이름");
		la_gender = new JLabel("성별");
		la_age = new JLabel("나이");
		
		setLayout(new BorderLayout());
		
		//캔버스의 크기 설정
		can.setPreferredSize(new Dimension(100, 100));
		can.setBackground(Color.RED);
		
		//p_west에 캔버스 부착하고, p_west를 WEST 영역에 부착
		p_west.setPreferredSize(new Dimension(120, 120));
		p_west.add(can);
		add(p_west,BorderLayout.WEST);
		
		//센터패널에 그리드 레이아웃 적용
		p_center.setLayout(new GridLayout(3, 1));
		p_center.add(la_name);
		p_center.add(la_gender);
		p_center.add(la_age);
		add(p_center);
		p_center.setBackground(Color.CYAN);
		
		setPreferredSize(new Dimension(700, 120));
	
	
	}

}
