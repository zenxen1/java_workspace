/*적군을 정의한다!!
 * 
 * */
package com.sds.game;

import java.awt.Color;
import java.awt.Graphics;

public class Enemy extends GameObject{
	
	public Enemy(int x, int y, int width, int height, String name) {
		super(x, y, width, height, name); //부모의 생성자가 디폴트생성자일때는 SUPER()가 자동으로 들어가 있지만, 인수가 있을 경우에는 
		                                                   //super가 등장해야한다.
		
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
	
	//적군이 어떻게 그러질지...
	public void render(Graphics g){
		g.setColor(Color.RED);
		g.drawOval(x, y, width, height);
	}
	
}
