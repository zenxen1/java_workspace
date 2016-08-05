/*
 * java.awt는 os 플랫폼마다 (Linux, Mac, Window..)디자인이 틀리다. 따라서 이를 보완한 api인 Swing을 사용해본다
 * 
 * Swing 특징
 * -javax.swing 패키지에서 지원
 * -컴포넌트가 awt 거의 동일 Button --> JButton
 * 
 * 주의!! - awt를 욕해서는 안된다!!!
 *          왜? 눈에 보여지는것 이외에는 아직도 사용된다!!!
 *          결론)GUI 프로그램시 개발시 swing + awg 조합!!
 * 
 * 자바의 GUI 컴포넌트의 종류 크게 2가지 있다.
 * 1. Container (남을 포함하는 컴포넌트) 
 *     - JFrame(BorderLayout 디폴트)
 *     - JPanel(FlowLayout 디폴트)
 *        컨테이너이다..하지만 단독으로 존재할 수 없고, 반드시 프레임안에 소속되어 있다.
 *        특징 - 눈에 보이지 않는다(div 흡사)
 *        주용도 - Frame내에서 별도의 개별적 레이아웃을 적용 시키고 싶을때 사용
 *     - Applet(FlowLayout 디폴트)
 * 2. Visual Component(포함당하는 컴포넌트) 
 *     - JButton, JCheckbox, JTextArea 등등
 * */
package gui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatWin extends JFrame{
	JTextArea ta;
	JTextField tf;
	JButton bt;
	JPanel panel;
	
	public ChatWin(){
		super("채팅클라이언트");
		JTextArea ta = new JTextArea();
		JTextField tf = new JTextField(15);
		JButton bt = new JButton("전송");
		JPanel panel = new JPanel();
		
		//패널에 txt와 bt를 부착!1
		panel.add(tf);
		panel.add(bt);
		
		//area 를 센터에 부착!!
		add(ta,BorderLayout.CENTER);
		add(panel,BorderLayout.SOUTH);
		
		//윈도우 창을 닫으면, 프로세스도 죽이기!!
		setDefaultCloseOperation(EXIT_ON_CLOSE );
		
		setSize(300, 400);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new ChatWin();
	
	}

}
