package com.sds.movie.list;

import javax.swing.table.AbstractTableModel;

public class MovieModel extends AbstractTableModel{
	
	String[] columnName={
			"������ȣ",
			"��ȭ����",
			"�帣",
			"������",
			"�󿵽ð�"
	};
	
	public MovieModel() {
		selectAll();
	}
	
	public int getColumnCount() {
		return columnName.length;
	}
	public String getColumnName(int col) {
		return columnName[col];
	}
	public int getRowCount(){
		return 0;
	}
	public Object getValueAt(int rowIndex, int columnIndex) {
		return null;
	}
	 
	//��ȭ��� �������� 
	public void selectAll(){
		String sql="select m.genre_id, title, move_id, open_day,show_time from movie m, genre g";
		sql=sql + "where m.genre_id=gener_id";
		System.out.println(sql);
	}
	
}












