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


	/*�� Ŭ������ �����ϴ� ��*/
	public static void main(String[] args) {
		
		Frame f = new Frame("������");
		
		f.setVisible(true);
		f.setSize(300, 400);
		
		

	}

}
