//영화상영정보 처리 화면..
package com.sds.movie.list;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.sds.main.AppMain;

public class MovieList extends JPanel implements ActionListener{
	//서쪽
	JPanel p_west;
	ImageIcon icon;
	JLabel la_img;
	Choice ch_genre;
	JTextField t_title, t_moive_id,t_openday,t_showtime;
	JButton bt_img,bt_edit, bt_delete;
	JFileChooser chooser;
	
	//센터 
	JScrollPane scroll;
	JTable table;
	MovieModel movieModel;
	
	//스트림
	FileInputStream fis;
	FileOutputStream fos;
	
	public MovieList() {
		p_west = new JPanel();
		p_west.setBackground(Color.YELLOW);
		p_west.setPreferredSize(new Dimension(150, 500));
		
		//서쪽영역의 컴포넌트들...
		URL url = this.getClass().getClassLoader().getResource("moive_default.png");
		icon = new ImageIcon(url);
		la_img = new JLabel(icon);
		
		ch_genre = new Choice();
		
		getGenre();
		
		t_title = new JTextField(10);
		t_openday = new JTextField(10);
		t_showtime = new JTextField(10);
		t_moive_id = new JTextField(10);
		
		bt_edit = new JButton("수정");
		bt_delete = new JButton("삭제");
		bt_img = new JButton("이미지등록");
		
		chooser = new JFileChooser("C:/Users/lee/Downloads");
		
		p_west.add(la_img);
		p_west.add(bt_img);
		p_west.add(ch_genre);
		p_west.add(t_title);
		p_west.add(t_moive_id);
		p_west.add(t_openday);
		p_west.add(t_showtime);
		p_west.add(bt_edit);
		p_west.add(bt_delete);
		
		
				
		movieModel = new MovieModel();
		table = new JTable(movieModel);
		scroll = new JScrollPane(table);
		
		setLayout( new BorderLayout());
		add(p_west, BorderLayout.WEST);
		add(scroll);
		
		//버튼과 리스너 연결
		bt_img.addActionListener(this);
		bt_edit.addActionListener(this);
		bt_delete.addActionListener(this);
		
		//테이블과 마우스리스너와 연결
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				String title = (String)table.getValueAt(row, 1);
				String movie_id = (String)table.getValueAt(row, 2);
				String openday = (String)table.getValueAt(row, 3);
				String showtime = (String)table.getValueAt(row, 4);
				
				//선택한 레코드와 일치하는 장르가 초이스 컴포넌트에 선택되어 있게 처리..
				String genre =(String)table.getValueAt(row, 0);
				ch_genre.select(genre);
				//그림을 바꾸자
				String img = (String)table.getValueAt(row, 5);
				URL url = this.getClass().getClassLoader().getResource(img);
				icon = new ImageIcon(url);
				la_img.setIcon(icon);
				
				t_title.setText(title);
				t_moive_id.setText(movie_id);
				t_openday.setText(openday.substring(0,9));
				t_showtime.setText(showtime);
				System.out.println(title);
				
			}
		});
	}
	
	//장르를 db에서 불러다 놓자!!
	public void getGenre(){
		Connection con = AppMain.getConnection();
		PreparedStatement pstmt= null;
		ResultSet rs=null;
		String sql ="select * from gener";
		
		try {
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				ch_genre.add(rs.getString("title"));
				
			}
		} catch (SQLException e) {
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
	
	public void setProfileImg(){
		int result = chooser.showOpenDialog(this);
		
		if(result == JFileChooser.APPROVE_OPTION){
			//유저가 보유한 로컬 드라이브에 있는파일을, 현재 프로젝트안의 res로 복사하자
			File file = chooser.getSelectedFile();
			//System.out.println(file.getAbsolutePath());
			try {
				fis = new FileInputStream(file);
				//System.out.println(this.getClass().getClassLoader().getResource("./"));
				
				//URL url = this.getClass().getClassLoader().getResource(".");
			
				String dir="C:/Users/lee/Desktop/movieimg/";
				fos = new FileOutputStream(dir + file.getName());
				System.out.println(fos);
				
				int data;
				byte[] b=new byte[1024];
				while((data = fis.read(b)) != -1){
					System.out.println(data);
					fos.write(b);
					fos.flush();
				}
				
				//DB에 파일명 update
				Connection con = AppMain.getConnection();
				String sql="update movie set img=? where movie_id=?";
				PreparedStatement pstmt;
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, file.getName());
				pstmt.setInt(2, Integer.parseInt(t_moive_id.getText()));
				int updateCount=pstmt.executeUpdate();
				JOptionPane.showMessageDialog(this, updateCount+"개의 레코드가 변경되었습니다.");
				
				//데이터베이스 조회를 다시 일으키고, 테이블 모델에게 변경을 알려야한다
				movieModel.selectAll();
				movieModel.fireTableDataChanged();
				table.updateUI();
				
				System.out.println(sql);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				if(fos!=null){
					try {
						fos.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(fis!=null){
					try {
						fis.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		}
	}
	
	public void deleteMovie(){
		Connection con = AppMain.getConnection();
		PreparedStatement pstmt=null;
		//파일삭제
		
		String filename = (String)table.getValueAt(table.getSelectedRow(), 5);
		File file = new File("C:/Users/lee/Desktop/movieimg/"+filename);
		boolean flag = file.delete(); // 파일삭제
		
		if(flag){
			//DB 삭제
			String sql="delete  from movie where movie_id = ?";
			
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, Integer.parseInt(t_moive_id.getText()));
				int result = pstmt.executeUpdate();
				JOptionPane.showMessageDialog(this, result + "건이 삭제되었습니다.");
				movieModel.selectAll();
				movieModel.fireTableDataChanged();
				table.updateUI();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
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
		 
	}
	
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == bt_img
				){
			setProfileImg();
		}else if(obj == bt_edit){
			
		}else if(obj == bt_delete){
			deleteMovie();
		}
	}
}





