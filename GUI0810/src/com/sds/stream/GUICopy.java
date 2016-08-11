package com.sds.stream;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUICopy extends JFrame{
	JLabel la_ori, la_dest;
	JTextField t_ori, t_dest;
	JButton bt_ori, bt_dest;
	JButton bt_copy;
	JPanel p_center;
	JPanel p_south;
	JFileChooser chooser;//���� Ž���� ��ü
	//GUICopy gc; ������ �ϴ�
	FileInputStream fis; //������ ������� �� �Է� ��Ʈ��
	FileOutputStream fos; //��� ��Ʈ��
	
	
	public GUICopy() {
		//gc = this;
		la_ori  =new JLabel("���� ����");
		la_dest  =new JLabel("���� ���");
		t_ori  = new JTextField(25);
		t_dest = new JTextField(25);
		bt_ori = new JButton("ã��");
		bt_dest = new JButton("����");
		bt_copy = new JButton("�������");
		p_center = new JPanel();
		p_south = new JPanel();
		chooser = new JFileChooser();
		
				
		//������ 
		t_ori.setBackground(Color.YELLOW);
		t_ori.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.RED));
		
		t_dest.setBackground(Color.YELLOW);
		t_dest.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.RED));
		
		p_center.add(la_ori);
		p_center.add(t_ori);
		p_center.add(bt_ori);
		p_center.add(la_dest);
		p_center.add(t_dest);
		p_center.add(bt_dest);		
		
		p_south.add(bt_copy);
		
		add(p_center);
		add(p_south, BorderLayout.SOUTH);
		
		bt_ori.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = chooser.showOpenDialog(getParent());
				//���⸦ ������ ..t_ori�� ��θ� ���
				if(result == JFileChooser.APPROVE_OPTION){
					File file = chooser.getSelectedFile();
					String path = file.getAbsolutePath();
					t_ori.setText(path);
				}
			}
		});
		
		bt_dest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = chooser.showSaveDialog(getParent());
				if(result == JFileChooser.APPROVE_OPTION){
					File file = chooser.getSelectedFile();
					String path = file.getAbsolutePath();
					t_dest.setText(path);
				}
			}
		});
		
		bt_copy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				copy();
			}
		});
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setSize(450, 150);
	}
	
	//������� : �Է½�Ʈ������ �о���� �����͸� ��� ��Ʈ���� �̿��Ͽ� ���Ͽ� ����ϴ� ����
	public void copy(){
		
		try {  //shift + alt + z 
			fis = new FileInputStream(t_ori.getText());
			fos = new FileOutputStream(t_dest.getText());
			//������ �о���̱� ����
			int data;
			while((data = fis.read()) != -1){//�˰��� �ϳ�
				 fos.write(data);
			}
			JOptionPane.showMessageDialog(this, "����Ϸ�");
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(this, "������ �������� �ʽ��ϴ�.");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			//��� ����Ǿ� �ִ� ��Ʈ�� �ڿ� �ݱ�!!
			if(fos!=null){
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(fis!=null){
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		new GUICopy();
	}

}
