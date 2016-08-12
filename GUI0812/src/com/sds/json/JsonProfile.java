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

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonProfile extends JFrame{
	
	JPanel p_west;
	JButton bt;
	JPanel p_center;
	JScrollPane scroll;
	JFileChooser chooser;
	FileReader reader;
	BufferedReader buffr;
	StringBuffer sb;
	
	public JsonProfile() {
		p_west = new JPanel();
		bt = new JButton("����");
		p_center = new JPanel();
		scroll = new JScrollPane(p_center);
		chooser = new JFileChooser("C:/java_workspace/GUI0812/res");
		
		//���� �гο� ��ư ���� �� �г��� ���ʿ� ����
		p_west.add(bt);
		add(p_west,BorderLayout.WEST);
		p_west.setBackground(Color.yellow);
		
		add(scroll);
		p_center.setBackground(Color.blue);
		
		p_center.setPreferredSize(new Dimension(700, 600));
		
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openFile();
			}
		});
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800,600);
		setVisible(true);
		
		
	}
	public void openFile(){
		if(chooser.showOpenDialog(this)==JFileChooser.APPROVE_OPTION){
			//���̽� ����
			//json���� �о �Ľ�����!!
			File file = chooser.getSelectedFile(); //������ ������ ����!!
			try {
				reader = new FileReader(file);
				buffr = new BufferedReader(reader);
				
				sb= new StringBuffer();
				String data = null;
				
				while((data=buffr.readLine())!=null){
					sb.append(data);
				}
				
				System.out.println(sb);
				
				createProfile();
				
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
	
	//������ ���� ���� Profile �ν��Ͻ� ���� �ż��� ����
	public void createProfile(){
		//�Ľ̽���
		JSONParser jsonParser = new JSONParser();
		try {
			JSONObject jsonObject = (JSONObject)jsonParser.parse(sb.toString()); // { ���� ������
			JSONArray jsonArray = (JSONArray)jsonObject.get("members"); //members ���� �뷮�� �迭�� ��ȯ��
			for(int i=0;i<jsonArray.size();i++){
				JSONObject member = (JSONObject)jsonArray.get(i);
				
				String name = (String)member.get("name");
				String gender = (String)member.get("gender");
				Long age = (Long)member.get("age");
				String photo = (String)member.get("photo");
								
				Profile profile = new Profile(photo);
				profile.la_name.setText("�̸� :"+name);
				profile.la_gender.setText("���� :"+gender);
				profile.la_age.setText("���� :"+age);
				p_center.add(profile);
			}
			p_center.updateUI();
			
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		new JsonProfile();

	}

}
