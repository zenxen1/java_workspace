/*JTable �����⿡ �Ұ��ϱ� ������ ���� �����͸� ������ ��ü�� TableModel�� �����Ͽ�, ȸ������ ���α׷��� �����
 * JTable�� ������ �����͸� ó���� ����!!
 * */
package com.sds.collection;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class MemberModel extends AbstractTableModel{
	String[] column = {"ID","�̸�","���"};
	//String[][] data = new String[0][0];
	
	//�迭�� �� ũ���� ��������� �����Ƿ�, �÷��� ���������� �̿��Ͽ� ����� ��������
	ArrayList<String[]> list = new ArrayList<String[]>();
	
	public String getColumnName(int col) {
		return column[col];
	}
	public int getColumnCount() {
		return column.length;
	}
	public int getRowCount() {
		return list.size();
	}

	public Object getValueAt(int row, int col) {
		String[] record= list.get(row);
		return record[col];
	}
	
	public boolean isCellEditable(int row, int col) {
		System.out.println(row+","+col+"�����ұ��?");
		if(col==1){
			return false;
		}else{
			return true;
		}
	}
	
	public void setValueAt(Object v, int row, int col) {
		System.out.println(v+"����"+row+","+col+"�����Ҳ���");
		list.get(row)[col] =(String) v;
	}

}
