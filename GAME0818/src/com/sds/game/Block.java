package com.sds.game;

import java.awt.Graphics;
import java.awt.Graphics2D;

public class Block extends GameObject{

	public Block(int x, int y, int width, int height, String name, ObjectManager objectManager) {
		super(x, y, width, height, name, objectManager);
	}

	public void tick() {}

	public void rander(Graphics g) {
		//20벽돌을 이미지로 표현할 예정....
		showRect(g);
		
	}
	

}
