package com.sds.thead;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class ProgressTest extends JFrame{
	JProgressBar bar;
	JButton bt;
	Thread thread;
	int n;
	
	public ProgressTest() {
		setLayout(new FlowLayout());
		
		bt = new JButton("다운로드");
		bar = new JProgressBar();
		bar.setPreferredSize(new Dimension(380, 50));
		bar.setBackground(Color.yellow);
		
		add(bt);
		add(bar);
		
		thread = new Thread(){ //스레드하나 만들자
			public void run(){ //런을 재정의 하고
				while(true){
					try {
						thread.sleep(100); //너무빠르니깐 논런어블부분으로 옮겼다오자
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					fill();
				}
			}
			
		};
		

		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				thread.start(); //스레드를 런어블부분으로 던지자
			}
		});
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 150);
		setVisible(true);
	}
	
	public void fill(){
		n++;
		bar.setValue(n);
	}
	
	public static void main(String[] args) {
		new ProgressTest();
	}
}
