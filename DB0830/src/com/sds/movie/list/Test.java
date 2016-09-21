package com.sds.movie.list;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.SystemOutLogger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Test {
	
	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:Oracle:thin:@localhost:1521:XE","java0819","java0819");
			System.out.println(con);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// XSSFWorkbook 파일 접근
		File file = new File("c:/movieDB.xlsx");
		try {
			XSSFWorkbook workbook=new XSSFWorkbook(file);
			
			// 열린 파일에 대해 시트를 접근해 보자!!
			
			
		 	XSSFSheet sheet = workbook.getSheet("movie");
		 	/*
			for(int i=0;i<sheet.getLastRowNum()+1;i++){
				XSSFRow row = sheet.getRow(i);
				for(int j=0;j<row.getLastCellNum();j++){
					XSSFCell cell = row.getCell(j);
					System.out.print(cell);
				}
				System.out.println("\n");
			}
			 */	
			int total=sheet.getPhysicalNumberOfRows();
			
			// 하나의 레코드가 완성되는 시점
			
			for(int i=1;i<total;i++){
				XSSFRow row=sheet.getRow(i);

				String sql="insert into movie(movie_id, title, genre_id, show_time, open_day)";
				sql=sql+" values(seq_movie.nextval, ?, ?, ?, ?)";
				
				try {
					pstmt = con.prepareStatement(sql);
		
					for(int a=0;a<4;a++){
						XSSFCell cell=row.getCell(a);
						if(cell.getCellType() ==XSSFCell.CELL_TYPE_STRING){
							pstmt.setString(a+1, cell.getStringCellValue());
						}else if(cell.getCellType() ==XSSFCell.CELL_TYPE_NUMERIC){
							pstmt.setInt(a+1, (int)cell.getNumericCellValue());
						}
					}
					System.out.println(sql);
					pstmt.executeUpdate();
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
