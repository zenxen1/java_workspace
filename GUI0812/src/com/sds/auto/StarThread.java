package com.sds.auto;

public class StarThread extends Thread{
	public void run() {
		while(true){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} //1초 동안 non-runnable 상태로 있어라!! 1초 지나면 다시 runnable로 복귀
			System.out.println("★");
		}
	}

}
