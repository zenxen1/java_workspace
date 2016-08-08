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

//ctrl shift + f 정렬
public class ChatB extends JFrame implements KeyListener{
	JTextArea area;
	JPanel p;
	JTextField txt;
	JScrollPane scroll;
	ChatA chatA;
	
	
	//생성자도 메서드 이므로 아래의 코드는 충분히 가능하다
	//이 생성자르 호출하는 자는 chata의 인스턴스를 넘겨야한다
	public ChatB(ChatA chatA) {
		this.chatA = chatA;
		area = new JTextArea();
		p = new JPanel();
		txt = new JTextField(15);
		// 스크롤을 적용하고자하는 컴포넌트를 인수로 넘긴다!!
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
			//나와 chatA의 area에 출력!!
			String msg = txt.getText();
			area.append(msg+"\n");//나의 area
			chatA.area.append(msg+"\n");
			txt.setText("");
			
		}
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	

}
