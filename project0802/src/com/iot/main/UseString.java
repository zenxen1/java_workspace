/*������ ���� Ŭ�����̸� �繰�� ǥ������ ����...
String Ŭ������ ���� �˾ƺ���
����) String Ŭ������ �츮�� �������� ���� �ܺ� Ŭ�����̸�
Ư�� Sun���� �����ϴ� javaSE�� �⺻ ��ü�̴�.
������, ���� Ŭ������ ������ ��Ű�� 
��Ģ������ import�Ͽ� ����ġ�� ����ؾ� �Ѵ�..
but ���� �ȳ��� ������??
java.lang ��Ű���� �����ڰ� ������� �ʴ��� �̹� �ý��������� ��ΰ� �νĵǾ����ִ�
���� import ����� �ƴϴ�
java.lang ��Ű���� ���α׷� ��� �ۼ��� ����� ������ ���� ���� ����ϴ� �ֿ� ��ü���� 
��� ���� ��Ű���̱� ������....
*/
package com.iot.main;
class  UseString{
	public static void main(String[] args){
		//�Ͻ���, ������ ������ (implicit) ������
		String s= "korea";

		//����� (explicit)������
		String s1 = new String("korea");
		
		System.out.println(s);
		System.out.println(s.charAt(3));
		for(int i=0;i<s.length();i++){
			System.out.println(s.charAt(i));
		}
	}
}
