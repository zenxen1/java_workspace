package com.sds.work;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class FileSave extends JFrame{
	JLabel la_so;
	JLabel la_new;
	JTextField la_sopath;
	JTextField la_newpath;
	JButton bt_so;
	JButton bt_new;
	JButton bt_run;
	JFileChooser chooser;
	//FileCopy copy = new FileCopy();
	FileInputStream fis;
	FileOutputStream fos;
	
	public FileSave() {
		la_so = new JLabel("원본");
		la_new = new JLabel("저장경로");
		la_sopath = new JTextField(20);
		la_newpath = new JTextField(20);
		bt_so = new JButton("열기");
		bt_new = new JButton("SAVE");
		bt_run = new JButton("실행");
		
		
		
		setLayout(new FlowLayout());
		
						
		add(la_so);
		add(la_sopath);
		add(bt_so);
		add(la_new);
		add(la_newpath);
		add(bt_new);
		add(bt_run);
		
		chooser = new JFileChooser();
		
		bt_so.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				open();
			}
		});
		
		bt_new.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				save();
			}
		});
		
		bt_run.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				run2();
			}
		});
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(380, 200);
		setVisible(true);
	}
	
	String sopath;
	public void open(){
		int result = chooser.showOpenDialog(this);
		if(result == JFileChooser.APPROVE_OPTION){
			File file = chooser.getSelectedFile();
			sopath = file.getAbsolutePath();
			la_sopath.setText(sopath);
		}
	}
	
	String newpath;
	public void save(){
		int result = chooser.showSaveDialog(this);
		if(result == JFileChooser.APPROVE_OPTION){
			File file = chooser.getSelectedFile();
			newpath = file.getAbsolutePath();
			la_newpath.setText(newpath);
		}
	}
	public void run2(){
		
	}
	public void run(){
		/*
		copy.name = sopath;
		copy.dest = newpath;
		copy.Copy();
		*/
		try{
			fis = new FileInputStream(sopath);
			fos = new FileOutputStream(newpath);
			int data;
			while(true){
				data = fis.read();
				System.out.print(data);
				fos.write(data);
				if(data==-1)break;
			}
			
		}catch(FileNotFoundException e){
			e.printStackTrace();
			System.out.println("존재하지 않는 경로 입니다.");
		}catch(IOException e){
			System.out.println("파일을 일기 에러!!");
		}finally{
			if(fos!=null){
				try{
					fos.close();
				}catch(IOException e){
				}
			}
			if(fis!=null){
				try{
					fis.close();
				}catch(IOException e){
				}
			}
		}
		
	}

	public static void main(String[] args) {
		new FileSave();

	}

}
