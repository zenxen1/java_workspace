package com.sds.thead;

public class MyThread extends Thread{
	/*�����ڴ� ���������� �����ϰ� ���� �ڵ带 RUN �޼��忡 �ۼ��ؾ� �Ѵ�.*/
	
	int count =0;
	CounterApp app;
	public MyThread(CounterApp app) {
		this.app = app;
	}
	
	public void run(){
		while(true){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			count();
		}
	}
	
	public void count(){
		count++;
		app.la.setText(Integer.toString(count));
		
	}

}
