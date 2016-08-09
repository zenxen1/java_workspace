/*swing���� �����͸� ��� �� �����ϱ� ���� �뵵�� �����Ǵ� ������Ʈ�� JTable �̴�!!
 * 
 * Jtable�� ������������ ���̱� ����, �����ΰ� ��(����+������)�� �и���Ų ���� �߱��Ѵ�.
 * ���� JTable�� ���� �����͸� �����ִ� â(Window)���Ҹ� �ϰ� ���� ������ �����͸� �����ϴ� ��ü�� TableModel�̴�!
 * */
package com.sds.collection;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

public class TableTest extends JFrame {
	/*
	String[] column = {"��ȣ","�̸�","��й�ȣ","�̸���"};
	String[][] data={
			{"1","ȫ�浿","0000","zejd@naver.com"},
			{"2","�̱浿","0340","zesdfd@naver.com"},
			{"3","���浿","0230","zsdfd@naver.com"}
	};
	*/
	JTable table;
	JScrollPane scroll;
	//MemberModel model;
	//PetModel model2;
	TableModel model; //�پ缺 ����
	
	public TableTest() {
		//model = new MemberModel();
		//model2 = new PetModel();
		//table = new JTable(data,column);
		table = new JTable(model = new PetModel());
		//table = new JTable(model2);
		scroll = new JScrollPane(table);
		
		add(scroll);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 300);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new TableTest();

	}

}
