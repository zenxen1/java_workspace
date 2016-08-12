package com.sds.thead;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MultiDownload extends JFrame{
	JButton bt;
	Progress bar1,bar2,bar3;
	Thread t1,t2,t3;
		
	 public MultiDownload() {
		 bt = new JButton("다운로드");
		 bar1 = new Progress(1000);
		 bar2 = new Progress(500);
		 bar3 = new Progress(1500);
		 
				 
		 setLayout(new FlowLayout());
		 add(bt);
		 add(bar1);
		 add(bar2);
		 add(bar3);
		 //Runnable 로 run메서드를 재정의 할 경우
		 //thread 생성시 runnable 객체를 인수로 넣어야 런너블의 런 메서드가 동작하게 된다.. 언제쓰나? 쓰레드 클래스르 ㄹ상속받아 코드작성하려고
		 //했으나 이미 다른 클래스의 자식을 클래스인경우 다중 상속이 불가능 하므로, 이떄 인터페이스인 러러블을 이용할 수 있다.
		 
		 t1 = new Thread(bar1);
		 t2 = new Thread(bar2);
		 t3 = new Thread(bar3);
		 
		
		 bt.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				down();
			}
		});
		 
		 setDefaultCloseOperation(EXIT_ON_CLOSE);
		 setSize(400, 600);
		 setVisible(true);
	 }
	 
	 public void down(){
		 t1.start();
		 t2.start();
		 t3.start();
	 }
	 
	 public static void main(String[] args){
		 new MultiDownload();
	 }

}
