/*�������� ��Ƽ�½�ŷ
 * - �ϳ��� ������ ���� ���ÿ� ���� ���μ����� �����Ű�� ���
 * 
 * ��Ƽ������
 * - �ϳ��� ���μ��������� ���������� ����� �� �ִ� ���� ���� ������ ������� �ϸ�,
 *  �̷��� �����带 ������ �����Ű�� ����� ��Ƽ �������̶� �Ѵ�.
 *  
 * */
package com.sds.auto;

public class CounterApp {
	//�츮�� ���ݱ��� �˰��־��� ������� ��Ȯ�� ��Ī ���� �����忴��!!! �� �ڹٴ� ������ �����̴�.
	public static void main(String[] args) {
		//int[] count=new int[3];
		//System.out.println(count[4]);
		MyThread mt = new MyThread();
		//StarThread st= new StarThread();
		//jvm�� �ñ��.
		mt.start();
		//st.start();
		
	}

}
