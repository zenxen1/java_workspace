//���� ����Ŭ �����ͺ��̽��� ���� ������ ���� ��� ��ü!!
package com.sds.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OracleManager {
	
	Connection con;
	PreparedStatement pstmt;
	
	public OracleManager(Connection con) {
		this.con=con;
	}
	//��� ���ڵ� ��ȸ
	public void selectAll(){
	
		String sql="select * from member2";
		try {
			pstmt=con.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
