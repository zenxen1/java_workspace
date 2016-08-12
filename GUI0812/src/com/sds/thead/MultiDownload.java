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
		 bt = new JButton("�ٿ�ε�");
		 bar1 = new Progress(1000);
		 bar2 = new Progress(500);
		 bar3 = new Progress(1500);
		 
				 
		 setLayout(new FlowLayout());
		 add(bt);
		 add(bar1);
		 add(bar2);
		 add(bar3);
		 //Runnable �� run�޼��带 ������ �� ���
		 //thread ������ runnable ��ü�� �μ��� �־�� ���ʺ��� �� �޼��尡 �����ϰ� �ȴ�.. ��������? ������ Ŭ������ ����ӹ޾� �ڵ��ۼ��Ϸ���
		 //������ �̹� �ٸ� Ŭ������ �ڽ��� Ŭ�����ΰ�� ���� ����� �Ұ��� �ϹǷ�, �̋� �������̽��� �������� �̿��� �� �ִ�.
		 
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
