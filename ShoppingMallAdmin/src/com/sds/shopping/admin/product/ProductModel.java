/*JTable에게 적절한 데이터를 제공해 주자!!
 * */
package com.sds.shopping.admin.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import com.sds.shopping.admin.main.AppMain;

public class ProductModel extends AbstractTableModel{
	String[] columns = {
			"제품코드","하위카테고리","제품명","가격","재고량"
			,"상세설명","이미지"
	};
	
	ArrayList<String[]> list = new ArrayList<String[]>();
	public ProductModel() {
		selectAll();
	}
	//모든레코드 가져오기
	public void selectAll(){
		//최신에 등록된 레코드를 먼저보여주고 싶다 = 내림
		//반대는 = 오름
		Connection con = AppMain.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql = "select product_id,s.title as uuuu,product_name,price,stock,detail,img from product p, subcategory s where p.subcategory_id = s.subcategory_id order by product_id asc";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			list.removeAll(list);
			
			while(rs.next()){
				String[] record = new String[columns.length];
				record[0] = Integer.toString(rs.getInt("product_id"));
				record[1] = rs.getString(("uuuu"));
				record[2] = rs.getString("product_name");
				record[3] = Integer.toString(rs.getInt("price"));
				record[4] = Integer.toString(rs.getInt("stock"));
				record[5] = rs.getString("detail");
				record[6] = rs.getString("img");
				
				list.add(record);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(pstmt!=null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	//각 셀을 편집할지 여부를 결정하는 메서드!!
	public boolean isCellEditable(int row, int col) {
		boolean cellFlag = false;
		if(col >= 2 && col<=5){
			cellFlag=true;
		}else{
			cellFlag=false;
		}
		return cellFlag;
	}
	
	public int getColumnCount() {
		return columns.length;
	}
	
	public String getColumnName(int col) {
		return columns[col];
	}

	public int getRowCount() {
		return list.size();
	}

	public Object getValueAt(int row, int col) {
		String[] record = list.get(row);
		return record[col];
	}
	
	public void setValueAt(Object value, int row, int col) {
		String[] record = list.get(row);
		record[col]=(String)value;
		//데이터가 데이터가 변화 되었음을 알려주는 메서드 호출!!
		fireTableCellUpdated(row, col);
	}
	
	
}
