/*�ϳ��� ���μ��������� ���������� ����Ǵ� ���� ���� ���� ������� �ϸ� Thread Ŭ������ �����Ѵ�.
 * ����) ������� �ڹ��� ������ �ƴϴ�!! �����ϴ� ��κ��� �������α׷��� �����尡 �����ȴ�.
 * C, C#, javascript(=setTimeout())���� ����ϰ� ����
 * */
package com.sds.auto;

public class MyThread extends Thread{

	//�����ڴ� ���������� �����ϰ� ���� �ڵ尡 �ִٸ� Run() �޼��带 ������ �Ѹ� �ȴ�.!!
	int i = 0;
	public void run() {
		while(true){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} //1�� ���� non-runnable ���·� �־��!! 1�� ������ �ٽ� runnable�� ����
			System.out.println(i++);
		}
	}
}
