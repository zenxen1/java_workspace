/*�ڵ����� ����� ����� ������*/
package com.iot.main;
/*Car has a wheel : has a ����*/
public class Car{
	//����;
	private Wheel w; // ����
	private Engine e;
	private Handle h;
	private int price;
	

	public Car(){
		w = new Wheel();
		e = new Engine();
		h = new Handle();
		price = 200;
	}
	public void go(){
		w.roll();
	}
}
