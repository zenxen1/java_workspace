package com.sds.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class MyListener implements ActionListener{
	EventTest2 et;//null
	
	//멤버변수인 et에, 이미 떠있는 윈도우인 EventTest2의 레퍼런스 대입시키자!!
	public void setEt(EventTest2 et){
		this.et=et;
		System.out.println("넘거받은 주소값"+et);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
			//System.out.println("눌렀어");
		
			//JTextField에 문자열 출력!!
			JTextField txt = et.txt;//기존꺼~~(EventTest2의 txt)
			txt.setText("나눌렀어!!");
		}
	
	

}
