/*JTable�� ������ ������ ��, �ְ߰��� �����͸� ó���ϴ� Table Model
 * */
package com.sds.collection;

import javax.swing.table.AbstractTableModel;

public class PetModel extends AbstractTableModel{

	//�Ʒ��� ��� ~ �޼���� �����ڸ� ���Ѱ� �ƴ϶�!!! jtable�� ȣ���ϴ� �޼����̴�!!
	String[] column = {"�̸�","����","����"};
	String[][] data = {
			{"����","������","��"},
			{"����","������","��"},
			{"����","������","��"}
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
