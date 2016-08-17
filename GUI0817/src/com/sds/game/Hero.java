//���ΰ��� �����Ѵ�.
package com.sds.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.lang.reflect.GenericArrayType;

public class Hero extends GameObject{
	Toolkit kit = Toolkit.getDefaultToolkit() ;
	Image img = kit.getImage("C:/java_workspace/GUI0812/res/����.jpg");
	GamePanel gamePanel;
	
	public Hero(int x, int y, int width, int height, String name,GamePanel gamePanel) {
		super(x, y, width, height, name);
		this.gamePanel = gamePanel;
	}

	//������ �������� ��ȭ���� �����ϴ� �޼���
	public void tick(){
		x=x+velX;
		y=y+velY;
	}
	
	//�ڽ��� ��� �׷����� ������ �����ϴ� �޼���!!
	public void render(Graphics g){
		//���������� ������ �׷��� �׸��� ���������(�����)
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
		
		g.drawImage(img, x, y, gamePanel);
		//g.setColor(Color.YELLOW);
		//g.drawRect(x, y, 50,50);
	}
}
