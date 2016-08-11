package com.sds.json;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class MyList extends JFrame{
	JButton bt;
	JPanel p;
	JScrollPane scroll;
	JFileChooser chooser;
	Plist plist;
	
	public MyList() {
		bt = new JButton("파일가져오기");
		p = new JPanel();
		scroll = new JScrollPane(p);
		plist = new Plist();
		
		scroll.setPreferredSize(new Dimension(400, 800));
		p.add(plist);
		add(bt,BorderLayout.WEST);
		add(scroll,BorderLayout.CENTER);
		
		
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fileopen();
				
			}
		});
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600,800);
		setVisible(true);
	
	}
	
	public void fileopen(){
		chooser = new JFileChooser();
		int result = chooser.showOpenDialog(this);
		if(result == JFileChooser.APPROVE_OPTION){
			File file = chooser.getSelectedFile();
			String path = file.getPath();
			System.out.println(path);
		}
	}
	
	public static void main(String[] args) {
		new MyList();
	}

}
