//java.exe����� ������ ������ �� �����͸� �Ѱ�
//�� 

//�Ϲ������� �ڹپ��� �⺻�ڷ���()��
//���� ����ȯ�� ��ü���� ����ȯ�� �����ϰ� �ִ�.
//������, �⺻�ڷ����� ��ü�ڷ������� ����ȯ�� �����ұ�?
//�����ϳ�..��, �⺻�ڷ������� ��ȯ�� �� �ִ� ��� ����.

//"true" --> true (String --> boolean)
//"2" --> 2   (String --> int)
//Dog  -->2 (Dog�� �⺻�ڷ������� ������ �� ���ɼ����� �Ұ�)

//"3"  --> '3' (String --> char)

//�ڹپ����� ��� �⺻�ڷ��� ���� 1:1 �� �����ϴ�
//Wrapper Ŭ������ ���� ��ü�ڷ����� �⺻�ڷ������� 
//����ȯ�� �����ϰ� �ִ�..

//����
//byte		: Byte
//short		: Short
//int			: Integer
//long		: Long
//--------------------------------
//�Ǽ�
//float		: Float
//double	: Double
//----------------------------------
//����
//boolean	: Boolean

package main;
class Cal{
	public static void main(String[] args){
		String n1 = args[0];
		String n2 = args[1];
		int result = Integer.parseInt(n1) + Integer.parseInt(n2);
		System.out.println(n1+" + "+n2+" = "+result);
	}
}
