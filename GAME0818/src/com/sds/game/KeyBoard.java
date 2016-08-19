package com.sds.game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyBoard extends KeyAdapter{
	ObjectManager objectManager;
	
	public KeyBoard(ObjectManager objectManager) {
		this.objectManager = objectManager;
	}
	
	public void keyPressed(KeyEvent e) {
		//System.out.println("������?");
		int key = e.getKeyCode();
		for(int i=0;i<objectManager.objectList.size();i++){
			GameObject obj = objectManager.objectList.get(i);
			if(obj.name.equals("Ship")){
				switch(key){
				case KeyEvent.VK_LEFT:    obj.velX =-2;break;
				case KeyEvent.VK_RIGHT: obj.velX =2;break;
				case KeyEvent.VK_UP:        obj.velY =-2;break;
				case KeyEvent.VK_DOWN:  obj.velY =2;break;
				case KeyEvent.VK_SPACE:  ((Ship)obj).fire();break; //14 �ڽĿ��Ը� �����ϱ� ����ȯ �ؾ� �Ѵ�
				}				
			}
			
		}
	}
	
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		for(int i=0;i<objectManager.objectList.size();i++){
			GameObject obj = objectManager.objectList.get(i);
			if(obj.name.equals("Ship")){
				switch(key){
				case KeyEvent.VK_LEFT:    obj.velX =0;break;
				case KeyEvent.VK_RIGHT: obj.velX =0;break;
				case KeyEvent.VK_UP:        obj.velY =0;break;
				case KeyEvent.VK_DOWN:  obj.velY =0;break;
				}				
			}
			
		}
	}

}
