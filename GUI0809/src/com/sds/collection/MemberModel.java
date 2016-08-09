/*JTable�� ������ ������ ��, ȸ������ �����͸� ó���ϴ� TableModel
 ���� table ���� ������ ��� �޼���� �����ڰ� ȣ���ϴ°��� �ƴ϶�, JTable ȭ�鿡 �������� ������ ȣ���Ѵ�
 �� �ý����� ȣ���Ѵ�.
 * */

package com.sds.collection;

import javax.swing.table.AbstractTableModel;

public class MemberModel extends AbstractTableModel{
	
	String[] column = {"��ȣ","�̸�","��й�ȣ","�̸���"};
	
	String[][] data={
			{"1","ȫ�浿","0000","zejd@naver.com"},
			{"2","�̱浿","0340","zesdfd@naver.com"},
			{"3","���浿","0230","zsdfd@naver.com"}
	};
	
	public String getColumnName(int col) {
		System.out.println(col+"��° ������ "+column[col]);
		return column[col];
	}
	
	//�� �÷��� ����
	public int getColumnCount() {
		
		return column.length;
	}

	//�� ���ڵ� ��
	public int getRowCount() {
	
		return data.length;
	}

	//���׸� ������ ������
	public Object getValueAt(int row, int col) {
		//System.out.println(row+col+"ȣ��~~");
		return data[row][col];
	}

}
