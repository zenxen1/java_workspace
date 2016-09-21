package com.sds.shopping.client.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sds.shopping.client.buy.BuyMain;

public class ProductMain extends JPanel {
	ArrayList<String> promotion_title=new ArrayList<String>();
	JLabel[] la_promotion_title;
	
	public ProductMain() {
		//�Ʒ��� �ݺ����� ����Ǳ� ���� ���θ�� ��ϵ��� �̹�
		//���ؿ;� �ϹǷ�...
		getPromotionList(); 
		
		la_promotion_title = new JLabel[4];
		
		for(int i=0;i<promotion_title.size();i++){
			la_promotion_title[i] = new JLabel(promotion_title.get(i));
			la_promotion_title[i].setBackground(Color.ORANGE);
			la_promotion_title[i].setPreferredSize(new Dimension(780, 40));
			add(la_promotion_title[i]);
			
			//�� ���θ�� ���� ��ϵ� ��ǰ ��������!
			
			//��ǰ����!!
			getPromotionProductList(promotion_title.get(i));
		}
		
		setBackground(Color.YELLOW);
		this.setPreferredSize(new Dimension(780,1000));
	}
	
	//���θ�� ��ǰ ���� ��������!!
	public void getPromotionList(){
		Connection con=ClientMain.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from promotion";
		try {
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				promotion_title.add(rs.getString("title"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt!=null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void getPromotionProductList(String title){
		Connection con=ClientMain.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		StringBuffer sql = new StringBuffer();
		
		sql.append("select pr.product_id, product_name, price, stock, detail, img");
		sql.append(" from");
		sql.append(" promotion_product pm, product pr");
		sql.append(" where pm.product_id=pr.product_id");
		sql.append(" and ");
		sql.append(" pm.promotion_id=(select promotion_id from");
		sql.append(" promotion where title=?)");
		//System.out.println(sql.toString());
		
		try {
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, title);
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				Product product = new Product(
						rs.getString("img"),
						rs.getString("product_name"), 
						rs.getInt("price"));
				
				final String img = rs.getString("img");
				final String product_name = rs.getString("product_name");
				final int price = rs.getInt("price");
				final int stock = rs.getInt("stock");
				
				
				product.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						System.out.println("��ǰ�����");
						BuyMain buyMain = new BuyMain(img,product_name,price,stock);
					}
				});
				add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(rs!=pstmt){
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}
		
	}
	
	
	
}

















