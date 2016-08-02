/*자동차를 만들되 제대로 만들자*/
package com.iot.main;
/*Car has a wheel : has a 관계*/
public class Car{
	//바퀴;
	private Wheel w; // 휠형
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
