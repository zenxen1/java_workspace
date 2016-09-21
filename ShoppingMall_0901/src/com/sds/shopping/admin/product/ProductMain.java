package com.sds.shopping.admin.product;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.sds.shopping.admin.main.AppMain;

public class ProductMain extends JPanel{
	//서쪽 영역
	JPanel p_west;
	Choice ch_top, ch_sub;
	ImageIcon icon;
	JLabel la_img;
	JTextField t_productname;
	JTextField t_price;
	JTextField t_stock;
	JTextArea detail;
	JScrollPane scroll;
	JButton bt_regist;
	
	//센터영역 
	JTable table;
	JScrollPane scroll2;
	
	public ProductMain() {
		p_west = new JPanel();
		ch_top = new Choice();
		ch_sub = new Choice();
		icon = new ImageIcon(this.getClass().getClassLoader().getResource("product_default.png"));
		la_img=new JLabel(icon);
		t_productname = new JTextField(10);
		t_price = new JTextField(10);
		t_stock  =new JTextField(10);
		detail = new JTextArea(8,12);
		scroll = new JScrollPane(detail);
		bt_regist = new JButton("등록");
		
		ch_top.add("카테고리 선택▼");
		ch_sub.add("카테고리 선택▼");
		
		this.setLayout(new BorderLayout());
		
		p_west.add(ch_top);
		p_west.add(ch_sub);
		p_west.add(la_img);
		p_west.add(t_productname);
		p_west.add(t_price);
		p_west.add(t_stock);
		p_west.add(scroll);
		p_west.add(bt_regist);
		
		p_west.setPreferredSize(new Dimension(150, 550));
		add(p_west, BorderLayout.WEST);
		
		this.setPreferredSize(new Dimension(
				AppMain.CONTENT_WIDTH, 
				AppMain.CONTENT_HEIGHT));
	}
}





