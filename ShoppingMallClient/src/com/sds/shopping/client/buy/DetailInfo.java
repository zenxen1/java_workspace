package com.sds.shopping.client.buy;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DetailInfo extends JPanel{
	JPanel p_center; //�׸��尡 ����� �г� (�¿� ����)
	ImageIcon icon;
	JLabel la_img;
	JPanel p_right; //��ǰ�� ������ ��µ� ���� ���� 
	JLabel la_product_name;
	JLabel la_price;
	JLabel la_stock;
	JTextField t_ea; //��� ����..
	
	JLabel la_south; //�� ������ ���� ����
	JButton bt_buy, bt_cart;
	
	public DetailInfo(String filename,String product_name, int price, int stock) {
		p_center = new JPanel();
		p_center.setLayout(new GridLayout(1, 2));
		icon = new ImageIcon(filename);
		la_img = new JLabel(icon);
		p_right = new JPanel();
		la_product_name = new JLabel(product_name);
		la_price = new JLabel(Integer.toString(price));
		la_stock = new JLabel(Integer.toString(stock));
		t_ea = new JTextField("0", 8);
		
		la_south = new JLabel("�������� ���ð�...");
		bt_buy = new JButton("�����ϱ�");
		bt_cart = new JButton("��ٱ���");
		
		la_img.setPreferredSize(new Dimension(300, 300));
		
		p_center.add(la_img);//���̹��� ���� (0,0)
		p_right.add(la_product_name);
		p_right.add(la_price);
		p_right.add(la_stock);
		p_right.add(t_ea);
		p_right.add(bt_buy);
		p_right.add(bt_cart);
		
		setLayout(new BorderLayout());
		
		p_center.add(p_right);//�������г� ���� (0,1)
		
		add(p_center);
		add(la_south, BorderLayout.SOUTH);
	}
}








