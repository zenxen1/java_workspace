/*JTable에 보여질 데이터 중, 애견관련 데이터를 처리하는 Table Model
 * */
package com.sds.collection;

import javax.swing.table.AbstractTableModel;

public class PetModel extends AbstractTableModel{

	//아래의 모든 ~ 메서드는 개발자를 위한게 아니라!!! jtable을 호출하는 메서드이다!!
	String[] column = {"이름","종류","성별"};
	String[][] data = {
			{"냥이","길고냥이","남"},
			{"응이","길고냥이","여"},
			{"옹이","길고냥이","남"}
	};
	public String getColumnName(int col) {
		
		return column[col];
	}
	public int getColumnCount() {
		return column.length;
	}

	public int getRowCount() {
		return data.length;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		
		return data[rowIndex][columnIndex];
	}
	

}
