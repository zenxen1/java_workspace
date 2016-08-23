/*Jtable�� �����ο� �Ұ��ϱ� ������ �������� ���̺� ���� ������ ���� �����Ѵ�!!
 * */

package com.sds.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class MyModel extends AbstractTableModel{
	String[] columTitle={
			"BOOK_ID",
			"CATEGORY_ID",
			"BOOK_NAME",
			"PUBLISHER",
			"AUTHOR",
			"PRICE",
			"REGDATA"
	};
	
	//ū �迭�� �÷��� �����ӿ����� ��ü����!! �����ϴϱ�...
	ArrayList<String[]> data = new <String[]> ArrayList();
	
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public MyModel(Connection con) {
		this.con = con;
		
		selectAll();
	}
	
	//��� ���ڵ� ��������!!!
	public void selectAll(){
		String sql="select * from book order by book_id asc";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			//8.���� data ����
			data.removeAll(data);
			
			while(rs.next()){
				String[] record = new String[columTitle.length];
				record[0] = Integer.toString(rs.getInt("BOOK_ID"));
				record[1] = Integer.toString(rs.getInt("SUBCATEGORY_ID"));
				record[2] = rs.getString("bookname");
				record[3] = rs.getString("publisher");
				record[4] = rs.getString("author");
				record[5] = Integer.toString(rs.getInt("price"));
				record[6] = rs.getString("regdate");
				
				data.add(record);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(rs !=null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt !=null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}	
	
	//8.���ڵ� �Ѱ� ����
	public int deleteBook(int book_id){
		int result=0;
		String sql = "delete from book where book_id="+book_id;
		try {
			pstmt=con.prepareStatement(sql);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(pstmt != null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	
	public String getColumnName(int col) {
	
		return columTitle[col];
		
	}
	public int getColumnCount() {
		return columTitle.length;
	}

	public int getRowCount() {
		return data.size();
	}

	public Object getValueAt(int row, int col) {
		String[] record=data.get(row);
		return record[col];
	}
	
}
