package com.sds.game;

import java.awt.Color;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class GameWindow extends JFrame implements ActionListener{
	//1 ���ӿɼ� - ���ӽ���, ����, ����, ����
	
	GamePanel gamePanel;
	JMenuBar bar;
	JMenu[] menu = new JMenu[2];
	JMenuItem[] menuItem = new JMenuItem[3];
	String[] menutitle = {"���ӽ���","��������","����"};
	
	KeyBoard keyBoard;
	
	public GameWindow() {
		
		bar = new JMenuBar();
		menu[0] = new JMenu("�޴�");
		menu[1] = new JMenu("����");
		
		for(int i=0;i<menutitle.length;i++){
			menuItem[i] = new JMenuItem(menutitle[i]);
			menu[0].add(menuItem[i]);
		}
		bar.add(menu[0]);
		bar.add(menu[1]);
		
		setJMenuBar(bar);
		
		gamePanel = new GamePanel();
		addKeyListener(keyBoard = new KeyBoard(gamePanel.objectManager)); 
				
		add(gamePanel);
		
		setBackground(Color.BLACK);
		pack();
		
		//3 �����ʿ� ����...
		for(int i=0;i<menutitle.length;i++){
			menuItem[i].addActionListener(this);
		}
		
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == menuItem[0]){
			gamePanel.startGame();
		}else if(obj == menuItem[1]){
			gamePanel.pauseGame();
		}else if(obj == menuItem[2]){
			gamePanel.exitGame();
		}
	}
	
	public static void main(String[] args) {
		new GameWindow();
	}

}
