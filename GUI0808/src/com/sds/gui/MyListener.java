package com.sds.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class MyListener implements ActionListener{
	EventTest2 et;//null
	
	//��������� et��, �̹� ���ִ� �������� EventTest2�� ���۷��� ���Խ�Ű��!!
	public void setEt(EventTest2 et){
		this.et=et;
		System.out.println("�ѰŹ��� �ּҰ�"+et);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
			//System.out.println("������");
		
			//JTextField�� ���ڿ� ���!!
			JTextField txt = et.txt;//������~~(EventTest2�� txt)
			txt.setText("��������!!");
		}
	
	

}
