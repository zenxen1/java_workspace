/*Hero�̰�, Enemy �̰� ������ ���ӿ� �����ϴ� ��� �繰�� �������� Ư���� ������ �����ϰ� �����Ƿ�
 * �� ��ü���� ������ Ư�� �� ������ �����Ͽ� �ڵ带 �ߺ����� ����, �ֻ����� ������ �θ�Ŭ������ �����ؼ�
 * �ڵ��� ������ �õ��� ����!!
 * */
package com.sds.game;

import java.awt.Graphics;

abstract public class GameObject {
	
	String name;
	
	int x;
	int y;
	int width;
	int height;
	int velX;
	int velY;
	
	public GameObject(int x, int y, int width, int height, String name) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.name = name;
	}
	
	
	abstract public void tick();
	abstract public void render(Graphics g);
	
	
}
