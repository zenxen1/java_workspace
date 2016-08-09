/*JTable에 보여줄 데이터 중, 회원관련 데이터를 처리하는 TableModel
 주의 table 모델이 보유한 모든 메서드는 개발자가 호출하는것이 아니라, JTable 화면에 보여질때 스스로 호출한다
 즉 시스템이 호출한다.
 * */

package com.sds.collection;

import javax.swing.table.AbstractTableModel;

public class MemberModel extends AbstractTableModel{
	
	String[] column = {"번호","이름","비밀번호","이메일"};
	
	String[][] data={
			{"1","홍길동","0000","zejd@naver.com"},
			{"2","이길동","0340","zesdfd@naver.com"},
			{"3","나길동","0230","zsdfd@naver.com"}
	};
	
	public String getColumnName(int col) {
		System.out.println(col+"번째 제목은 "+column[col]);
		return column[col];
	}
	
	//총 컬럼의 갯수
	public int getColumnCount() {
		
		return column.length;
	}

	//총 레코드 수
	public int getRowCount() {
	
		return data.length;
	}

	//각항목에 보여질 데이터
	public Object getValueAt(int row, int col) {
		//System.out.println(row+col+"호출~~");
		return data[row][col];
	}

}
