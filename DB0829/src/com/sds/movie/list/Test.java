package com.sds.movie.list;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Test {

	public static void main(String[] args) {
		// 워크북의 역활 - 엑셀파일을 제어하기 위한 객체
		Connection con = null;
		PreparedStatement pstmt=null;
		ResultSet rs;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","java0819","java0819");
			System.out.println(con);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		File file = new File("C:/movie.xlsx");
		try {
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet movie = workbook.getSheet("movie");
			int total = movie.getPhysicalNumberOfRows();
			
			
			for (int i = 1; i < total; i++) {
				XSSFRow row = movie.getRow(i);
				
				//하나의 레코드가 완료되는 시점
				String sql = "insert into movie(movie_id,title,genre_id,show_time,open_day)";
				sql=sql + " values(seq_movie.nextval,?,?,?,?)";
				
				pstmt = con.prepareStatement(sql);
				
				for (int a = 0; a < 4; a++) {
					XSSFCell cell = row.getCell(a);
					if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING) {
						System.out.print(cell.getStringCellValue());
						pstmt.setString(a+1,cell.getStringCellValue());
					} else if (cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC) {
						System.out.print(cell.getNumericCellValue());
						pstmt.setInt(a+1, (int)cell.getNumericCellValue());
					}
				}
			
				System.out.println(sql);
				pstmt.executeUpdate();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
