package com.iot.main;
class UseCar{

	public static void main(String[] args){
		//�ڵ��� 1�븦 �޸𸮿� �ø��� ������ ��� ��ǰ�� �޼��带 ȣ��!!
		Car c = new Car();
		//c.price = 20;
		//System.out.println(c.price);
		//��ü�� �޸𸮿� �ø��� �ʰ� ����Ϸ��� �ϸ� NullPointerException ���� �߻�
		c.go();
	}
}
