package com.sds.game;

import java.awt.Graphics;
import java.awt.Image;

public class Bullet extends GameObject{
	Image img;
	
	public Bullet(int x, int y, int width, int height, String name, ObjectManager objectManager) {
		super(x, y, width, height, name, objectManager);
		img = getImage("Bullet.png");
		velX=5;
	}

	public void tick() {
		x+=velX;
		rect.setBounds(x, y, width, height);
		
		//19. �Ѿ˰� ������� �浹�˻�!!!!
		hitTest();
	}
	
	public boolean hitTest(){
		//System.out.println(objectManager.objectList.size());
		for(int i=0;i<objectManager.objectList.size();i++){
			GameObject obj =objectManager.objectList.get(i);
			if(obj.name.equals("Enemy")){
				//20������ ���� �浹 �˻�
				if(this.rect.intersects(obj.rect)){
					//System.out.println("�����?");
					objectManager.removeObject(obj);
					objectManager.removeObject(this);
					
					
				}
			}
		}
		
		return false;
	}

	public void rander(Graphics g) {
		g.drawImage(img, x, y, width, height, null);
		showRect(g);
		
	}
	

}
