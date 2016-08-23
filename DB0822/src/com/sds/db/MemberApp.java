package com.sds.db;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

class  MemberApp{
	String url="jdbc:mariadb://localhost:3306/iot";
	String user = "root";
	String password ="";
	Connection con; //점수후,, 접속 정보를 보유한 객체
	PreparedStatement pstmt;
	ResultSet rs;
	public MemberApp(){
		
		try{
			//mariadb 용 jdbc 드라이버(static 영역) 로드!!
			Class.forName("org.mariadb.jdbc.Driver");

			//mariadb에 접속하자!!
			con = DriverManager.getConnection(url, user, password);
			if(con !=null){
				System.out.println("등록성공");
				String sql ="select * from member2";
				pstmt =con.prepareStatement(sql);
				rs = pstmt.executeQuery();

			while(rs.next()){
				System.out.println(rs.getString("name"));
			}
			}else{
			}
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			if(rs!=null){
				try{
					rs.close();
				catch(SQLException e1){
					e1.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args){
		//조회(select)
		new MemberApp();
	}
}
