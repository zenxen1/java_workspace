package com.sds.auto;

public class StarThread extends Thread{
	public void run() {
		while(true){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} //1�� ���� non-runnable ���·� �־��!! 1�� ������ �ٽ� runnable�� ����
			System.out.println("��");
		}
	}

}
