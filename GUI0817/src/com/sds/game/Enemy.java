/*������ �����Ѵ�!!
 * 
 * */
package com.sds.game;

import java.awt.Color;
import java.awt.Graphics;

public class Enemy extends GameObject{
	
	public Enemy(int x, int y, int width, int height, String name) {
		super(x, y, width, height, name); //�θ��� �����ڰ� ����Ʈ�������϶��� SUPER()�� �ڵ����� �� ������, �μ��� ���� ��쿡�� 
		                                                   //super�� �����ؾ��Ѵ�.
		
		/*
		this.name =name;
		this.x =x;
		this.y = y;
		this.width = width;
		this.height = height;
		*/
	}
	
	
	public void tick(){
		x+=velX;
		y+=velY;
	}
	
	//������ ��� �׷�����...
	public void render(Graphics g){
		g.setColor(Color.RED);
		g.drawOval(x, y, width, height);
	}
	
}
