package com.sds.db;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class BookMain extends JFrame implements ItemListener,ActionListener{
	JPanel p_west; //좌측 입력폼에 사용할 패널
	Choice ch_top, ch_sub; //상,하위 카테고리 출력 
	JTextField t_bookname, t_publisher, t_author, t_price;
	JButton bt_regist;

	//북쪽 관련 
	JPanel p_north;
	Choice ch_category;
	JTextField t_keyword;
	JButton bt_search;
	
	//센터관련 
	JTable table;
	JScrollPane scroll;
	
	//접속 정보 (jdbc=java database connectivity )
	String url="jdbc:oracle:thin:@localhost:1521:XE";
	String user="java0819";
	String password="java0819";

	//jdbc  관련 객체 중 접속 후, 그 정보를 가진 객체!!
	//따라서 접속을 끊으려면 이 객체를 이용해야 한다!!
	Connection con;
	
	//쿼리문 수행 객체!! 인터페이스 이므로new 불가!
	//접속이 되어야 쿼리문을 실행할 수 있으므로,  con 으로
	//부터 인스턴스를 얻어와야 한다!!
	PreparedStatement pstmt;
	
	//쿼리 수행 후 레코드가 반환되는  경우 , 즉 select문을 수행
	//시 결과집합을 담는 역할을 수행하는 인터페이스!!
	ResultSet rs;
	
	public BookMain() {
		p_west = new JPanel();
		ch_top = new Choice();
		ch_sub = new Choice();
		t_bookname = new JTextField(10);
		t_publisher = new JTextField(10);
		t_author = new JTextField(10);
		t_price = new JTextField(10);
		bt_regist = new JButton("등록");
		
		p_north = new JPanel();
		ch_category = new Choice();
		t_keyword = new JTextField(30);
		bt_search = new JButton("검색");
		
		table  = new JTable();
		scroll = new JScrollPane(table);
		
		//조합하기!
		p_west.setPreferredSize(new Dimension(150,600));
		ch_top.setPreferredSize(new Dimension(120, 30));
		ch_sub.setPreferredSize(new Dimension(120, 30));
		
		ch_top.add("선	택 ▼");
		ch_sub.add("선	택 ▼");
		
		p_west.add(ch_top);
		p_west.add(ch_sub);
		p_west.add(t_bookname);
		p_west.add(t_publisher);
		p_west.add(t_author);
		p_west.add(t_price);
		
		p_west.add(bt_regist);
		p_west.setBackground(Color.WHITE);
		add(p_west, BorderLayout.WEST);
		
		//북쪽 구성
		p_north.add(ch_category);
		p_north.add(t_keyword);
		p_north.add(bt_search);
		
		ch_category.add("도서명");
		ch_category.add("출판사");
		ch_category.add("저자");
		
		add(p_north, BorderLayout.NORTH);
		add(scroll);
		
		
		//상위카테고리 초이스와 리스너 연결
		ch_top.addItemListener(this);
		
		//윈도우와  윈도우 리스너 연결
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				//db닫기!!
				if(con!=null){
					try {
						con.close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}			
				//프로세스 죽이기!
				System.exit(0);
			}
		});
		
		//버튼과 리스너연결
		bt_regist.addActionListener(this);
		
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800,600);
		setLocationRelativeTo(null); //화면 중앙으로..
		setVisible(true);
		
		connect();
		//상위 목록 가져오기!!
		getTopCategory();
	}
	
	//데이터베이스 접속하기!!(프로그램이 가동될때...)
	public void connect(){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//JOptionPane.showMessageDialog(this,"드라이버 로드 성공");
			this.setTitle("드라이버 로드 성공");
			//접속
			con=DriverManager.getConnection(url, user, password);
			if(con==null){
				JOptionPane.showMessageDialog(this, "접속 실패!!");
				return;
			}
			//JOptionPane.showMessageDialog(this, "접속성공");
			this.setTitle("접속 성공");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	//상위카테고리 가져오기!!
	public void getTopCategory(){
		//드라이버 로드!!
		try {
			//상위카테고리 가져오기!!!
			String sql="select * from topcategory";
			pstmt=con.prepareStatement(sql);
			
			//쿼리수행!!
			rs=pstmt.executeQuery();
			
			//초이스 컴포넌트에 알맞는 데이터 채우세요!
			while(rs.next()){
				ch_top.add(rs.getString("title"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			if(pstmt!=null){
				try {
					pstmt.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}			
		}
	}
	
	//하위 카테고리 목록 가져오기 
	public void getSubCategory(String title){
		//JOptionPane.showMessageDialog(this,"선택했어?");
		StringBuffer sql= new StringBuffer();

		sql.append("select * from subcategory");
		sql.append(" where topcategory_id=(");
		sql.append(" select topcategory_id from ");
		sql.append(" topcategory where title='"+title+"'");
		sql.append(")");
		
		//System.out.println(sql.toString());
		
		//쿼리 수행!!!
		try {
			pstmt=con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			
			ch_sub.removeAll();
			ch_sub.add("▼선택");
			
			while(rs.next()){
				ch_sub.add(rs.getString("title"));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			if(pstmt!=null){
				try {
					pstmt.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}			
		}
	}
	
	public void itemStateChanged(ItemEvent e) {
		Choice ch=(Choice)e.getSource();
		getSubCategory(ch.getSelectedItem());
		System.out.println(ch);
	}
	
	//book 테이블에 메서드 1건 넣기
	public void registBook(){
		String sql ="insert into book(book_id,subcategory_id,bookname,publisher,author,price)";
		sql=sql+" values(seq_book.nextval, )";
	}
	 
	public void actionPerformed(ActionEvent e) {
		registBook();
	}
	
	public static void main(String[] args) {
		new BookMain();
	}

}





