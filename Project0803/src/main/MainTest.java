/*main()�޼����� �μ��� args�� ����غ���*/
/*main- �����ڰ� */
package main;
class MainTest{
	public static void main(String[] args){
		System.out.println("���α׷� ����� �Ѱܹ��� �μ��� ������ "+args.length);
		for(int i=0;i<args.length;i++){
			System.out.println("args["+i+"] = "+args[i]);
		}
	}
}
