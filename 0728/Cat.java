/*
1.Cat�̶�� �̸��� ����� Ŭ������ �����ϵ�,
�̸� ���� ������ ����� �����Ͻÿ�...

2.Ư�� ������ ��쿣 static���� ���� �Ͻÿ�~~~
3.���� Ŭ������ main����θ� �ε�,
  ������� �̸�,����,������ ����Ͻÿ�.

*/
class  Cat
{
	String name = "������";
	int age = 2; //�ν��Ͻ�����
	static String type ="����̰�"; //Ŭ��������
		
	}
	public static void main(String[] args) 
	{
		Cat c1 = new Cat();
		Cat c2 = new Cat();
		Cat.type="�����";//Cat�̶�� 
		System.out.println("�̸���"+c.name+"���̴�"+c.age);
	
	}//���⼭ stact�� ������ ��������. heap�� ��ü�� �Ű澲������..�˾Ƽ� �����ش�...
}
//cmdâ ����..jvm�� ����ְ�..��ü�� �˾Ƽ�..���δ�..