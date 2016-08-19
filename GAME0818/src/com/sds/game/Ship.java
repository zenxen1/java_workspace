package com.sds.game;

import java.awt.Graphics;
import java.awt.Image;

public class Ship extends GameObject{
	Image img;
	
	public Ship(int x, int y, int width, int height, String name, ObjectManager objectManager) {
		super(x, y, width, height, name, objectManager);
		//8. URL �̶� �ڿ��� ��ġ�� �ǹ��Ѵ�!! ����-> �ý��۳������� �ڿ��� ��ġ!! wep --> http://~
		img = getImage("hithero.png");
		/*
		Class myClass = this.getClass();
		URL url=myClass.getClassLoader().getResource("hithero.png"); //9. api Ŭ����Ŭ���� java.lang / class
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
		
		//17.�ǽð� �簢���� ��ġ�� �ٲ�� �Ѵ�~~~ �׷��� ���ΰ��� ����ٴϴϱ�...�׷��� �浹�˻簡 ����..
		rect.setBounds(x, y, width, height);
	}

	public void rander(Graphics g) {
		g.drawImage(img, x, y, width, height, null);
		
		showRect(g);
		//g.translate(x, y);
		
		
	}
	
	//13�Ѿ˹߻�
	public void fire(){
		Bullet bullet = new Bullet(x+width, y+(height/2), 30, 30, "Bullet", objectManager);
		objectManager.addObject(bullet);
	}

}
