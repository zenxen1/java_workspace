/*
 * ������ �����츦 �����Ѵ� 1024 * 768
 * 
 * ������ �������̽��� 3���̻��� ������ �޼��带 ������ ���
 * ��������� �ʴ� �޼��带 �ڵ������ ������Ѿ� �ϴ� ���ո��� ��찡 �߻��ϰ� �ȴ�...
 * �ذ�å) sun������ ����͸� Ŭ������ ���� �� ������ �ذ��Ѵ�.
 * */
package com.sds.game;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class GameWindow extends JFrame implements ActionListener, KeyListener{
	GamePanel gamePanel;
	JMenuBar bar;
	JMenu[] menu= new JMenu[2];
	JMenuItem[] item = new JMenuItem[3];
	String[] itemTitle={"���ӽ���","�Ͻ�����","��������"};
	
	//�츮��� keylistener�� ������ �߻�Ŭ����!
	//�츮�� ���� keyrelrased, keypresses, keytyped�� ���� �ǹ��� ���̻� ����!!
	//KeyAdapter keyAdapter;
	KeyBoard keyBoard;
	
	public GameWindow() {
		add(gamePanel=new GamePanel());
		pack();
		
		//�޴����� 
		bar = new JMenuBar();
		menu[0]=new JMenu("���ӿɼ�");
		menu[1]=new JMenu("����");
		
		for(int i=0;i<item.length;i++){
			item[i] = new JMenuItem(itemTitle[i]);
			menu[0].add(item[i]);
			item[i].addActionListener(this);//�����ʿ� ����!!
		}
		bar.add(menu[0]);
		bar.add(menu[1]);
		
		setJMenuBar(bar);
	
		//������� Ű������ ����
		this.addKeyListener(keyBoard = new KeyBoard(gamePanel.objectMananger));
		
		/*
		//������� Ű������ ����
		this.addKeyListener(keyAdapter=new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				System.out.println("Ű������??");
				int key = e.getKeyCode();
				if(key==KeyEvent.VK_LEFT){
					gamePanel.hero.velX = 10;
				}
			}
		});
		*/
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		setBackground(Color.BLACK);
	}

	public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource();
		
		if(obj==item[0]){ //���ӽ���!!
			gamePanel.startGame();
		}else if(obj==item[1]){//�Ͻ�����!!
			gamePanel.pauseGame();
		}else if(obj.equals(item[2])){//��������!!
			gamePanel.exitGame();
		}
	}
	
	public static void main(String[] args) {
		new GameWindow();	
	}
}



