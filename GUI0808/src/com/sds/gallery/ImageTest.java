/*자바의 모든 gui컴포넌트는 스스로 그림의 주체가 되어
 * 스스로를 그린다. 이떄 그림 그리는 행위는 paint메서드로 표현되며,
 * 이 paint 메서드의 매개변수로 팔레트역활의 객체인 Graphics 객체가 인수로 전달된다.
 * ex) 버튼 스스로 그림을 증폄
 * */
package com.sds.gallery;

import javax.swing.JFrame;

public class ImageTest extends JFrame{

	MyButton bt;
	MyCanvas can;
	
	public ImageTest(){
		bt=new MyButton("커스텀 버튼");
		can=new MyCanvas();
		add(can);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setSize(300, 400);
	}

	public static void main(String[] args) {
		new ImageTest();

	}

}
