package com.iot.main;
class UseTV{
	public void getInfo(TV tv, int k){
		//매개변수 tv의 인스턴스 1개를 넘겨서 해당 TV의 가격을 출력해 보기 = getInfo를 호출해보시오
		tv.price = k;
		tv.printPrice();
	}
	public void test(boolean b, int k){
		System.out.println(b+","+k);
	}

	public void showPrice(){
		TV t = new TV();
		t.printPrice();
	}

	public static void main(String[] args){
		UseTV ut = new UseTV();
		ut.showPrice();
		ut.test(true, 10);

		TV t = new TV();
		t.price=2000;
		ut.getInfo(t,50);
	}
}
