package com.sds.thead;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

//�����带 ��ӹ޾� ����Ϸ��Ҷ�,  �̹� �������� �ڽ� Ŭ�������, Runnable �������̸� �̿��Ҽ� �ִ�
//runnable �� run�޼��带 �߻� �޼���� ������ �������̽��̴�!!!
public class CounterApp extends JFrame implements Runnable{
	JButton bt;
	JLabel la;
	//Thread thread;
	int n=0;
	MyThread thread;
	CounterApp app;
	Thread thread2;
	Thread thread3,t1,t2; //Runnable�� �����尡 �ƴϹǷ�,run�޼��带 �������Ͽ��� �ϴ��� �����尡 �����ؾ��Ѵ�.
	Progress bar1, bar2;
	
	public CounterApp() {
		app = this;
		bt = new JButton("��ư");
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
	//�� run�޼���� Runnable �������̽� ����!!
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
