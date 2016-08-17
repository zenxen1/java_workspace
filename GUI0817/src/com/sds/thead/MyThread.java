package com.sds.thead;

public class MyThread extends Thread{
	/*개발자는 독립적으로 수행하고 싶은 코드를 RUN 메서드에 작성해야 한다.*/
	
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
