/*4 화면에 등장할 모든 게임 오브젝트가 반드시 구현해야 할
 * 메서드와 필요한 속성을 정의하기 위한 최상위 클래스
 * */
package com.sds.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

abstract public class GameObject {
	int x;
	int y;
	int width;
	int height;
	int velX;
	int velY;
	String name;
	ObjectManager objectManager;
	Rectangle rect;
	
	
	public GameObject(int x, int y, int width, int height,String name, ObjectManager objectManager) {
		this.x=x;
		this.y =y;
		this.width = width;
		this.height = height;
		this.name = name;
		this.objectManager = objectManager;
		rect  = new Rectangle(x, y, width, height);
		
	}
	
	abstract public void tick();
	abstract public void rander(Graphics g);
	
	//10.클래스패스상에 존재하는 이미지명만으로 Image 객체를 반환해주는 메서드
	public Image getImage(String name){
		Image img = null; // 지역변수는 컴파일러가 초기화 해주지않으므로 반드시 개발자가 초기화 해야한다.
		Class myClass = this.getClass();
		URL url = myClass.getClassLoader().getResource(name);
		try {
			img = ImageIO.read(url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return img;
	}
	//16.Rectangle 객체가 생성은 되었지만, 눈에 보여지지는 않으므로, 개발시에는 시각화 시킬수 있는 메서드 정의...
	//개발후에는 호출 x
	public void showRect(Graphics g){
		//Graphic의 기능에 2차원 그래픽 관련된 기능이 보강
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.YELLOW);
		g2.draw(rect);
		
	}
}
