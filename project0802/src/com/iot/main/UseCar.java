package com.iot.main;
class UseCar{

	public static void main(String[] args){
		//자동차 1대를 메모리에 올리고 그차의 모든 부품의 메서드를 호출!!
		Car c = new Car();
		//c.price = 20;
		//System.out.println(c.price);
		//객체를 메모리에 올리지 않고 사용하려고 하면 NullPointerException 에러 발생
		c.go();
	}
}
