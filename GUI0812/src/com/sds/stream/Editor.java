package com.sds.stream;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilterOutputStream;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Editor extends JFrame{

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
	FileWriter writer;
	BufferedWriter buffw;
	JButton bt;
	File openpath;
	
	
	public Editor() {
		
		p_center = new JPanel();
		p_num = new JPanel();
		area = new JTextArea();
		scroll = new JScrollPane(p_center);
		bar = new JMenuBar();
		chooser = new JFileChooser();
		/*임시 버튼으로 하위 기능 구현
		bt = new JButton("열기구현");
		add(bt,BorderLayout.NORTH);
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("버튼눌렀어?"+this);
				openFile();
			}
		});
		*/
		String[] menutitle = {"파일","편집","보기","검색","문서","프로젝트","도구","브라우져","ZC"}; 
		menu = new JMenu[menutitle.length];
		for(int i=0;i<menutitle.length;i++){
			menu[i] = new JMenu(menutitle[i]);
			bar.add(menu[i]);
		}
		//add(bar,BorderLayout.NORTH);
		setJMenuBar(bar);
		
		String[] text = {"새파일","열기","닫기","저장","새이름으로 저장","종료"};
		item = new JMenuItem[text.length];
		for(int i=0;i<text.length;i++){
			item[i] = new JMenuItem(text[i]);
			if(i==3 || i==5) menu[0].addSeparator();
			menu[0].add(item[i]);
			
			item[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Object obj = e.getSource();
					JMenuItem i = (JMenuItem)obj;
					switch(i.getText()){
					case "새파일" :newFile() ;break;
					case "열기" :openFile() ;break;
					case "닫기" :closeFile() ;break;
					case "저장" :saveFile() ;break;
					case "새이름으로 저장" :newsaveFile() ; break;
					case "종료" :close(); break;
					}
					
				}
			});
			
	
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
	
	public void newFile(){
		area.setText("");
	}
	public void openFile(){
		int result = chooser.showOpenDialog(this);
		
		if(result == JFileChooser.APPROVE_OPTION){
			openpath = chooser.getSelectedFile();
			
			try {
				reader = new FileReader(openpath);
				buffr = new BufferedReader(reader);
				String data = null;
				area.setText("");
				while((data = buffr.readLine())!=null){
					area.append(data);	
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				if(buffr != null){
					try {
						buffr.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		
	}
	public void closeFile(){
		area.setText("");
	}
	
	public void saveFile(){
		try {
			writer = new FileWriter(openpath);
			writer.write(area.getText());
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(writer != null){
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		
	}
	public void newsaveFile(){
		int result = chooser.showSaveDialog(this);
		if(result == JFileChooser.APPROVE_OPTION){
			File file = chooser.getSelectedFile();
			try {
				writer = new FileWriter(file);
				buffw = new BufferedWriter(writer);
				buffw.write(area.getText());
				buffw.flush();
				
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				if(buffw != null){
					try {
						buffw.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			
		}
	}
	public void close(){
		dispose();
	}
			
	public static void main(String[] args) {
		new Editor();
	}
}
