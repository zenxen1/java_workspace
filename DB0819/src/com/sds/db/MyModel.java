/*Jtable은 디자인에 불과하기 때문에 실제적인 테이블에 대한 정보는 모델이 제공한다!!
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
	
	//큰 배열을 컬렉션 프레임웍으로 대체하자!! 유연하니깐...
	ArrayList<String[]> data = new <String[]> ArrayList();
	
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public MyModel(Connection con) {
		this.con = con;
		
		selectAll();
	}
	
	//모든 레코드 가져오기!!!
	public void selectAll(){
		String sql="select * from book order by book_id asc";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			//8.기존 data 삭제
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
	
	//8.레코드 한건 삭제
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
