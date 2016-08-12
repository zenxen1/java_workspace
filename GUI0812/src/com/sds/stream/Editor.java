package com.sds.stream;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Editor extends JFrame implements ActionListener{

	JPanel p_menu;
	JPanel p_center;
	JPanel p_num;
	JTextArea area;
	JScrollPane scroll;
	JMenuBar bar;
	JMenu[] menu;
	JMenuItem[] item;
	JFileChooser chooser;
	FileReader reader;
	BufferedReader buffr;
	
	
	public Editor() {
		
		p_center = new JPanel();
		p_num = new JPanel();
		area = new JTextArea();
		scroll = new JScrollPane(p_center);
		bar = new JMenuBar();
		
		String[] menutitle = {"����","����","����","�˻�","����","������Ʈ","����","������","ZC"}; 
		menu = new JMenu[menutitle.length];
		for(int i=0;i<menutitle.length;i++){
			menu[i] = new JMenu(menutitle[i]);
			bar.add(menu[i]);
		}
		//add(bar,BorderLayout.NORTH);
		setJMenuBar(bar);
		
		String[] text = {"������","����","�ݱ�","����","���̸����� ����","����"};
		item = new JMenuItem[text.length];
		for(int i=0;i<text.length;i++){
			item[i] = new JMenuItem(text[i]);
			if(i==3 || i==5) menu[0].addSeparator();
			menu[0].add(item[i]);
			item[i].addActionListener(this);
		}
	
		p_center.setLayout(new BorderLayout());
		
		p_num.setPreferredSize(new Dimension(20, 700));
		p_num.add(new JLabel("1"));
		p_num.add(new JLabel("2"));
		p_num.add(new JLabel("3"));
		p_num.add(new JLabel("4"));
		p_center.add(p_num,BorderLayout.WEST);
		
		area.setBackground(Color.white);
		p_center.add(area,BorderLayout.CENTER);
		
		add(scroll);
			
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800, 700);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		JMenuItem i = (JMenuItem)obj;
		switch(i.getText()){
		case "������" :newFile() ;break;
		case "����" : ;break;
		case "�ݱ�" : ;break;
		case "����" : ;break;
		case "���̸����� ����" : ; break;
		case "����" : ; break;
		}
	}
	public void newFile(){}
	public void openFile(){
		int result = chooser.showOpenDialog(this);
		if(result == JFileChooser.APPROVE_OPTION){
			File file = chooser.getSelectedFile();
			try {
				reader = new FileReader(file);
				buffr = new BufferedReader(reader);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
			
			
		}
	}
	public void closeFile(){}
	public void saveFile(){}
	public void newsaveFile(){}
	public void close(){}
			
	public static void main(String[] args) {
		new Editor();
	}
}
