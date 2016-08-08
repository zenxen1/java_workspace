/*�Ʒ��� ��Ģ�� �� �������(=�ȵ���̵� ���߽� ����)
 * 1. �˸´� ������ ����
 * 2. �������� �޼��� ������
 * 3. �̺�Ʈ  �ҽ�(=�̺�Ʈ�� ����Ų ������Ʈ)�� �����ʿ� ����*/
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
		bt = new JButton("����ư");
		
		setLayout(new FlowLayout());
		
		add(txt);
		add(bt);
		
		//��ư�� �������� ����!!
		bt.addActionListener(this);
		txt.addKeyListener(this);
		this.addWindowListener(this);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setSize(300, 400);
	}

	public void actionPerformed(ActionEvent e) {
		System.out.println("��������");
	}
	
	public void keyPressed(KeyEvent e) {
		
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		if(key== KeyEvent.VK_ENTER){//����ƽ�̴ѱ� ����Ҷ�� Ŭ������ ����´�
			System.out.println("�����ƾ�?");		
		}
	}
	public void keyTyped(KeyEvent e) {
	}
	
	public void windowActivated(WindowEvent e) {
		System.out.println("windowActivated ȣ��");
	}
	public void windowClosed(WindowEvent e) {
		System.out.println("windowClosed ȣ��");
	}
	public void windowClosing(WindowEvent e) {
		System.out.println("windowClosing ȣ��");
	}
	public void windowDeactivated(WindowEvent e) {
		System.out.println("windowDeactivated ȣ��");
	}
	public void windowDeiconified(WindowEvent e) {
		System.out.println("windowDeiconified ȣ��");
	}
	public void windowIconified(WindowEvent e) {
		System.out.println("windowIconified ȣ��");
	}
	public void windowOpened(WindowEvent e) {
		System.out.println("windowOpened ȣ��");
	}
	
	public static void main(String[] args) {
		new EventTest();
	}

	
	
}
