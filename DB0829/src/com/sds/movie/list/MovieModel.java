package com.sds.movie.list;

import javax.swing.table.AbstractTableModel;

public class MovieModel extends AbstractTableModel{
<<<<<<< HEAD
	String[] columName={
=======
	String[] columnName={
>>>>>>> zenxen1/master
			"movie_id",
			"영화제목",
			"genre_id",
			"개봉일",
			"상영시간"
<<<<<<< HEAD
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
=======
	};
	
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
	 
	//영화목록 가져오기 
	public void selectAll(){
		String sql="select m.genre_id, title, move_id, open_day,show_time from movie m, genre g";
		sql=sql + "where m.genre_id=gener_id";
	}
	
}












>>>>>>> zenxen1/master
