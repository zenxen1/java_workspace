package com.sds.thead;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JProgressBar;

public class Progress extends JProgressBar implements Runnable{
	int interval;
	int n;
	
	public Progress(int interval) {
	this.interval = interval;
	setPreferredSize(new Dimension(250, 60));
	setBackground(Color.yellow);
	
	}
	
	public void run() {
		while(true){
			try {
				Thread.sleep(interval);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			n++;
			this.setValue(n);
		}
	}

}
