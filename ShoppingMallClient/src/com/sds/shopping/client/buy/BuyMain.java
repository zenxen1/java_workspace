/*
 * �󼼺��� --> ���� �������Է�ȭ�� + ����ȭ��  
 * */
package com.sds.shopping.client.buy;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BuyMain extends JFrame{
	JPanel p_container;
	DetailInfo info;
	
	public BuyMain(String filename, String product_name,int price, int stock) {
		p_container = new JPanel();
		info = new DetailInfo(filename, product_name, price, stock);
		p_container.add(info);
		add(p_container);
		setSize(600,700);
		setVisible(true);
	}
}








