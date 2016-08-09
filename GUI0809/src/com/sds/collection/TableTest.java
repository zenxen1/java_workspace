/*swing에서 데이터를 출력 및 관리하기 위한 용도로 지원되는 컴포넌트는 JTable 이다!!
 * 
 * Jtable은 유지보수성을 높이기 위해, 디자인과 모델(로직+데이터)을 분리시킨 모델을 추구한다.
 * 따라서 JTable은 단지 데이터를 보여주는 창(Window)역할만 하고 실제 보여질 데이터를 결정하는 객체는 TableModel이다!
 * */
package com.sds.collection;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

public class TableTest extends JFrame {
	/*
	String[] column = {"번호","이름","비밀번호","이메일"};
	String[][] data={
			{"1","홍길동","0000","zejd@naver.com"},
			{"2","이길동","0340","zesdfd@naver.com"},
			{"3","나길동","0230","zsdfd@naver.com"}
	};
	*/
	JTable table;
	JScrollPane scroll;
	//MemberModel model;
	//PetModel model2;
	TableModel model; //다양성 구현
	
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
