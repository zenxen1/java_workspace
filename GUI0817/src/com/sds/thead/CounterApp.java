package com.sds.thead;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

//쓰레드를 상속받아 사용하려할때,  이미 누군가의 자식 클래스라면, Runnable 인터페이를 이용할수 있다
//runnable 은 run메서드를 추상 메서드로 보유한 인터페이스이다!!!
public class CounterApp extends JFrame implements Runnable{
	JButton bt;
	JLabel la;
	//Thread thread;
	int n=0;
	MyThread thread;
	CounterApp app;
	Thread thread2;
	Thread thread3,t1,t2; //Runnable은 쓰레드가 아니므로,run메서드를 재정의하였다 하더라도 쓰레드가 존재해야한다.
	Progress bar1, bar2;
	
	public CounterApp() {
		app = this;
		bt = new JButton("버튼");
		la = new JLabel();
		bar1 = new Progress(1000);
		bar2 = new Progress(300);
		
		/*
		thread2 = new Thread(){
			public void run(){
				while(true){
					try {
						thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					n++;
					la.setText(Integer.toString(n));
				}
			}
			
		};*/
		setLayout(new FlowLayout());
		la.setPreferredSize(new Dimension(250, 300));
		la.setFont(new Font("arial black", Font.BOLD, 100));
	
		add(bt);
		add(la);
		add(bar1);
		add(bar2);
		
		thread3 = new Thread(this);
		t1 = new Thread(bar1);
		t2 = new Thread(bar2);
		
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//thread = new MyThread(app);
				//thread.start();
				//thread2.start();
				thread3.start();
				t1.start();
				t2.start();
			}
		});
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300, 550);
		setVisible(true);
	}
	//이 run메서드는 Runnable 인터페이스 꺼다!!
	public void run() {
		while(true){
			try {
				thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			n++;
			la.setText(Integer.toString(n));
		}
	}
	
	public static void main(String[] args){
		new CounterApp();
	}

}
