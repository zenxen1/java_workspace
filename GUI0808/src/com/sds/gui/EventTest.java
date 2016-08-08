/*아래의 원칙을 잘 기억하자(=안드로이드 개발시 동일)
 * 1. 알맞는 리스너 선택
 * 2. 리스너의 메서드 재정의
 * 3. 이벤트  소스(=이벤트를 일으킨 컴포넌트)와 리스너와 연걸*/
package com.sds.gui;

import java.awt.Event;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class EventTest extends JFrame implements ActionListener, KeyListener,WindowListener{
	JTextField txt;
	JButton bt;
	
	public EventTest(){
		txt = new JTextField(15);
		bt = new JButton("나버튼");
		
		setLayout(new FlowLayout());
		
		add(txt);
		add(bt);
		
		//버튼과 리스너의 연결!!
		bt.addActionListener(this);
		txt.addKeyListener(this);
		this.addWindowListener(this);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setSize(300, 400);
	}

	public void actionPerformed(ActionEvent e) {
		System.out.println("나눌렀어");
	}
	
	public void keyPressed(KeyEvent e) {
		
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		if(key== KeyEvent.VK_ENTER){//스택틱이닌까 사용할라면 클래스에 점찍는다
			System.out.println("엔터쳤어?");		
		}
	}
	public void keyTyped(KeyEvent e) {
	}
	
	public void windowActivated(WindowEvent e) {
		System.out.println("windowActivated 호출");
	}
	public void windowClosed(WindowEvent e) {
		System.out.println("windowClosed 호출");
	}
	public void windowClosing(WindowEvent e) {
		System.out.println("windowClosing 호출");
	}
	public void windowDeactivated(WindowEvent e) {
		System.out.println("windowDeactivated 호출");
	}
	public void windowDeiconified(WindowEvent e) {
		System.out.println("windowDeiconified 호출");
	}
	public void windowIconified(WindowEvent e) {
		System.out.println("windowIconified 호출");
	}
	public void windowOpened(WindowEvent e) {
		System.out.println("windowOpened 호출");
	}
	
	public static void main(String[] args) {
		new EventTest();
	}

	
	
}
