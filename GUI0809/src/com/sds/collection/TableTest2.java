package com.sds.collection;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;


public class TableTest2 extends JFrame{
	JPanel p;
	Choice c;
	JTable table;
	JScrollPane scroll;
	TableModel model;
	
	public TableTest2() {
		p = new JPanel();
		c = new Choice();
		table = new JTable();
		scroll = new JScrollPane(table);
		
		c.add("�� ����");
		c.add("�ֿϵ���");
		c.add("ȸ�����");
		
		c.addItemListener(new ItemListener() {
						
			public void itemStateChanged(ItemEvent e) {
				Object obj = e.getItem();
				if(obj.equals("�� ����")){
					JOptionPane.showMessageDialog(getParent(), "�����Ͻÿ�");
				}else if(e.getItem()=="�ֿϵ���"){
					
					table.setModel(model = new PetModel());
				
				}else if(e.getItem()=="ȸ�����"){
					table.setModel(model = new MemberModel());
				}
				table.updateUI();
			}
		});
		
		p.add(c);
		add(p,BorderLayout.WEST);
		add(scroll,BorderLayout.CENTER);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(700, 600);
		setVisible(true);		
		
	}
	
	
	
	public static void main(String[] args) {
		new TableTest2();
	}

}
