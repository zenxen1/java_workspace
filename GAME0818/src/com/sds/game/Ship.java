package com.sds.game;

import java.awt.Graphics;
import java.awt.Image;

public class Ship extends GameObject{
	Image img;
	
	public Ship(int x, int y, int width, int height, String name, ObjectManager objectManager) {
		super(x, y, width, height, name, objectManager);
		//8. URL 이란 자원의 위치를 의미한다!! 응용-> 시스템내에서의 자원의 위치!! wep --> http://~
		img = getImage("hithero.png");
		/*
		Class myClass = this.getClass();
		URL url=myClass.getClassLoader().getResource("hithero.png"); //9. api 클래스클래스 java.lang / class
		try {
			img = ImageIO.read(url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
	}

	public void tick() {
		x+=velX;
		y+=velY;
		
		//17.실시간 사각형의 위치를 바꿔야 한다~~~ 그래야 주인공을 따라다니니깐...그래야 충돌검사가 가능..
		rect.setBounds(x, y, width, height);
	}

	public void rander(Graphics g) {
		g.drawImage(img, x, y, width, height, null);
		
		showRect(g);
		//g.translate(x, y);
		
		
	}
	
	//13총알발사
	public void fire(){
		Bullet bullet = new Bullet(x+width, y+(height/2), 30, 30, "Bullet", objectManager);
		objectManager.addObject(bullet);
	}

}
