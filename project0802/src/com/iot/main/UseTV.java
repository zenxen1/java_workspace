package com.iot.main;
class UseTV{
	public void getInfo(TV tv, int k){
		//�Ű����� tv�� �ν��Ͻ� 1���� �Ѱܼ� �ش� TV�� ������ ����� ���� = getInfo�� ȣ���غ��ÿ�
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
