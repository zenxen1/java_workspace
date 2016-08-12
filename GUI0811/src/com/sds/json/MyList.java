package com.sds.json;

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
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class MyList extends JFrame{
	JButton bt;
	JPanel p;
	JScrollPane scroll;
	JFileChooser chooser;
	Plist plist;
	String path;
	FileReader reader;
	BufferedReader buffr;
		
	public MyList() {
		bt = new JButton("파일가져오기");
		p = new JPanel();
		scroll = new JScrollPane(p);
		
		add(bt,BorderLayout.WEST);
		add(scroll);
		p.setPreferredSize(new Dimension(600, 700));
		
		
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fileopen();
				
				try {
					reader = new FileReader(path);
					buffr = new BufferedReader(reader);
				
					String data = null;
					StringBuffer sb = new StringBuffer();
					while((data =buffr.readLine())!= null){
						sb.append(data);
					}
					
					JSONParser jsonParser = new JSONParser();
					JSONObject jsonObject = (JSONObject)jsonParser.parse(sb.toString());
					JSONArray jsonArray = (JSONArray)jsonObject.get("members");
					for(int i=0;i<jsonArray.size();i++){
						JSONObject member = (JSONObject)jsonArray.get(i);
												
						plist = new Plist(member);
						//plist.setPreferredSize(new Dimension(400, 200));
						p.add(plist);
					}
					p.updateUI();
				} catch (FileNotFoundException e3) {
					e3.printStackTrace();
				} catch (IOException e2) {
					e2.printStackTrace();
				} catch (org.json.simple.parser.ParseException e1) {
					e1.printStackTrace();
				}
				
				
			}
		});
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600,500);
		setVisible(true);
	
	}

	
	public void fileopen(){
		chooser = new JFileChooser();
		int result = chooser.showOpenDialog(this);
		if(result == JFileChooser.APPROVE_OPTION){
			File file = chooser.getSelectedFile();
			path = file.getPath();
				
		}
	}
	
	public static void main(String[] args) {
		new MyList();
	}

}
