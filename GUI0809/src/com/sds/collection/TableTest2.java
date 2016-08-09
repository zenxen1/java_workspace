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
		
		c.add("▼ 선택");
		c.add("애완동물");
		c.add("회원명부");
		
		c.addItemListener(new ItemListener() {
						
			public void itemStateChanged(ItemEvent e) {
				Object obj = e.getItem();
				if(obj.equals("▼ 선택")){
					JOptionPane.showMessageDialog(getParent(), "선택하시오");
				}else if(e.getItem()=="애완동물"){
					
					table.setModel(model = new PetModel());
				
				}else if(e.getItem()=="회원명부"){
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
