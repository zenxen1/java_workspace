package com.sds.collection;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

public class MemberList extends JFrame{
	JPanel p;
	JLabel lb_id;
	JLabel lb_name;
	JLabel lb_pw;
	JTextField tf_id;
	JTextField tf_name;
	JTextField tf_pw;
	JButton bt_reg;
	JButton bt_list;
	JTable table;
	JScrollPane scroll;
	ArrayList list;
	AbstractTableModel model;
	
	
	public MemberList() {
		p = new JPanel();
		lb_id = new JLabel("ID");
		lb_name = new JLabel("이름");
		lb_pw = new JLabel("비번");
		tf_id = new JTextField(10);
		tf_name = new JTextField(10);
		tf_pw = new JTextField(10);
		bt_reg = new JButton("등록");
		bt_list = new JButton("목록");
		table = new JTable();
		scroll = new JScrollPane(table);
		list = new ArrayList();
		
		String[] column = {"ID","이름","비번"};
		model = new AbstractTableModel() {
			
			public String getColumnName(int col) {
				
				return Column(col);
			}
		
			public Object getValueAt(int arg0, int arg1) {
				
				return null;
			}
			
			
			public int getRowCount() {
			
				return 0;
			}
			
			
			public int getColumnCount() {
				
				return 0;
			}
		};
		table.setModel(model);
		
		p.add(lb_id);
		p.add(tf_id);
		p.add(lb_name);
		p.add(tf_name);
		p.add(lb_pw);
		p.add(tf_pw);
		p.add(bt_reg);
		p.add(bt_list);
				
		add(p,BorderLayout.WEST);
		add(scroll);
		
		
		
		bt_reg.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				list.add(tf_id.getText());
				list.add(tf_name.getText());
				list.add(tf_pw.getText());
			
			}
		});
		
		bt_list.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Showlist();
			}
		});
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1400, 700);
		setVisible(true);
			
		
	}
	
	public void Showlist(){
		
	}


	public static void main(String[] args) {
		new MemberList();

	}

}
