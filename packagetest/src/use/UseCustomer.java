/*
Ŭ�����κ��� �����Ǵ� �ν��Ͻ��� ������ ���� �����͸� ������ ��� ���Ȼ� ������ �߻��� �� �����Ƿ�,
�ڹ� ������ 4������ ���ȵ���� �����Ѵ�.
public < protected <default < private
public : �ƿ� ������ ó������ �ʴ� ���� ������!!!
protected : ���� ��Ű�� or ��Ӱ��迡 �ִ� �ν��Ͻ��� ������ ���
default : ���� ���� ��Ű������ �ִ� �ν��Ͻ��� �������
private : �ܺ��� ��� �ν��Ͻ��� ������ ������� �ʴ� ���� ���� ��������
*/
package use;
import bank.Customer;
class UseCustomer{
	public static void main(String[] args) 
	{
		//���� ���� �������� 100������ �ٲ���
		Customer c = new Customer();
		c.total = 100;
		System.out.println(c.total);
	}
}
