package animal;
public class Sparrow extends Bird{
	boolean isBury = true;
	String name="����";
	
	/*
	��ӽ� �ڽ� Ŭ������ �θ�Ŭ������ �޼��带 ������ �����ϰ� �������� �� �ִ�
	�޼��� ���Ǳ���� ������ override�� �Ѵ�.
	�����ε� - �� Ŭ���� ������ �޼������ �����ϰ� �����ϴ� ���
	�������̵� - ��Ӱ��迡�� �θ� �޼��带 ������
	*/
	public void wing(){
		System.out.println("������ �������ϴ�.");
	}
}
