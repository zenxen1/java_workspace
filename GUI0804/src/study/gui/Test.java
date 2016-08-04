package study.gui;

import java.awt.Frame;

public class Test {
	public Test() {
	
	}
	private String name;
	private int price;
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	/*이 클래스를 공부하는 중*/
	public static void main(String[] args) {
		
		Frame f = new Frame("나제목");
		
		f.setVisible(true);
		f.setSize(300, 400);
		
		

	}

}
