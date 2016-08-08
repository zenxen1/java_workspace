package com.sds.chatting;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//ctrl shift + f ����
public class ChatB extends JFrame implements KeyListener{
	JTextArea area;
	JPanel p;
	JTextField txt;
	JScrollPane scroll;
	ChatA chatA;
	
	
	//�����ڵ� �޼��� �̹Ƿ� �Ʒ��� �ڵ�� ����� �����ϴ�
	//�� �����ڸ� ȣ���ϴ� �ڴ� chata�� �ν��Ͻ��� �Ѱܾ��Ѵ�
	public ChatB(ChatA chatA) {
		this.chatA = chatA;
		area = new JTextArea();
		p = new JPanel();
		txt = new JTextField(15);
		// ��ũ���� �����ϰ����ϴ� ������Ʈ�� �μ��� �ѱ��!!
		scroll = new JScrollPane(area);

		add(scroll);

		p.add(txt);
		add(p, BorderLayout.SOUTH);
		
		txt.addKeyListener(this);
		
		setBounds(400, 200, 300, 400);
		setVisible(true);

	}


	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_ENTER){
			//���� chatA�� area�� ���!!
			String msg = txt.getText();
			area.append(msg+"\n");//���� area
			chatA.area.append(msg+"\n");
			txt.setText("");
			
		}
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	

}
