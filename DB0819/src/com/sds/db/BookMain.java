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
	JPanel p_west; //���� �Է����� ����� �г�
	Choice ch_top, ch_sub; //��,���� ī�װ� ��� 
	JTextField t_bookname, t_publisher, t_author, t_price;
	JButton bt_regist;

	//���� ���� 
	JPanel p_north;
	Choice ch_category;
	JTextField t_keyword;
	JButton bt_search;
	
	//���Ͱ��� 
	JTable table;
	JScrollPane scroll;
	
	//���� ���� (jdbc=java database connectivity )
	String url="jdbc:oracle:thin:@localhost:1521:XE";
	String user="java0819";
	String password="java0819";

	//jdbc  ���� ��ü �� ���� ��, �� ������ ���� ��ü!!
	//���� ������ �������� �� ��ü�� �̿��ؾ� �Ѵ�!!
	Connection con;
	
	//������ ���� ��ü!! �������̽� �̹Ƿ�new �Ұ�!
	//������ �Ǿ�� �������� ������ �� �����Ƿ�,  con ����
	//���� �ν��Ͻ��� ���;� �Ѵ�!!
	PreparedStatement pstmt;
	
	//���� ���� �� ���ڵ尡 ��ȯ�Ǵ�  ��� , �� select���� ����
	//�� ��������� ��� ������ �����ϴ� �������̽�!!
	ResultSet rs;
	
	public BookMain() {
		p_west = new JPanel();
		ch_top = new Choice();
		ch_sub = new Choice();
		t_bookname = new JTextField(10);
		t_publisher = new JTextField(10);
		t_author = new JTextField(10);
		t_price = new JTextField(10);
		bt_regist = new JButton("���");
		
		p_north = new JPanel();
		ch_category = new Choice();
		t_keyword = new JTextField(30);
		bt_search = new JButton("�˻�");
		
		table  = new JTable();
		scroll = new JScrollPane(table);
		
		//�����ϱ�!
		p_west.setPreferredSize(new Dimension(150,600));
		ch_top.setPreferredSize(new Dimension(120, 30));
		ch_sub.setPreferredSize(new Dimension(120, 30));
		
		ch_top.add("��	�� ��");
		ch_sub.add("��	�� ��");
		
		p_west.add(ch_top);
		p_west.add(ch_sub);
		p_west.add(t_bookname);
		p_west.add(t_publisher);
		p_west.add(t_author);
		p_west.add(t_price);
		
		p_west.add(bt_regist);
		p_west.setBackground(Color.WHITE);
		add(p_west, BorderLayout.WEST);
		
		//���� ����
		p_north.add(ch_category);
		p_north.add(t_keyword);
		p_north.add(bt_search);
		
		ch_category.add("������");
		ch_category.add("���ǻ�");
		ch_category.add("����");
		
		add(p_north, BorderLayout.NORTH);
		add(scroll);
		
		
		//����ī�װ� ���̽��� ������ ����
		ch_top.addItemListener(this);
		
		//�������  ������ ������ ����
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				//db�ݱ�!!
				if(con!=null){
					try {
						con.close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}			
				//���μ��� ���̱�!
				System.exit(0);
			}
		});
		
		//��ư�� �����ʿ���
		bt_regist.addActionListener(this);
		
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800,600);
		setLocationRelativeTo(null); //ȭ�� �߾�����..
		setVisible(true);
		
		connect();
		//���� ��� ��������!!
		getTopCategory();
	}
	
	//�����ͺ��̽� �����ϱ�!!(���α׷��� �����ɶ�...)
	public void connect(){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//JOptionPane.showMessageDialog(this,"����̹� �ε� ����");
			this.setTitle("����̹� �ε� ����");
			//����
			con=DriverManager.getConnection(url, user, password);
			if(con==null){
				JOptionPane.showMessageDialog(this, "���� ����!!");
				return;
			}
			//JOptionPane.showMessageDialog(this, "���Ӽ���");
			this.setTitle("���� ����");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	//����ī�װ� ��������!!
	public void getTopCategory(){
		//����̹� �ε�!!
		try {
			//����ī�װ� ��������!!!
			String sql="select * from topcategory";
			pstmt=con.prepareStatement(sql);
			
			//��������!!
			rs=pstmt.executeQuery();
			
			//���̽� ������Ʈ�� �˸´� ������ ä�켼��!
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
	
	//���� ī�װ� ��� �������� 
	public void getSubCategory(String title){
		//JOptionPane.showMessageDialog(this,"�����߾�?");
		StringBuffer sql= new StringBuffer();

		sql.append("select * from subcategory");
		sql.append(" where topcategory_id=(");
		sql.append(" select topcategory_id from ");
		sql.append(" topcategory where title='"+title+"'");
		sql.append(")");
		
		//System.out.println(sql.toString());
		
		//���� ����!!!
		try {
			pstmt=con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			
			ch_sub.removeAll();
			ch_sub.add("�弱��");
			
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
	
	//book ���̺� �޼��� 1�� �ֱ�
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





