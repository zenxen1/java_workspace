package com.sds.movie.list;

import javax.swing.table.AbstractTableModel;

public class MovieModel extends AbstractTableModel{
	String[] columName={
			"movie_id",
			"영화제목",
			"genre_id",
			"개봉일",
			"상영시간"
			};
	public String getColumnName(int col) {
		return columName[col];
	}
	
	public int getColumnCount() {
		return columName.length;
	}

	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

}
