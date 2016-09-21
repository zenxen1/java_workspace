/*
���θ��� �������� ���� ������!!
���� ������ �����Ͱ� �ִٸ� �� Ŭ������ �����ϸ� ����..
*/
package com.sds.shopping.admin.main;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.sds.shopping.admin.member.MemberMain;
import com.sds.shopping.admin.order.OrderMain;
import com.sds.shopping.admin.partner.PartnerMain;
import com.sds.shopping.admin.product.ProductMain;
import com.sds.shopping.admin.sales.SalesMain;
import com.sds.shopping.admin.staff.StaffMain;
public class AppMain extends JFrame{
	private static Connection con;
	public static final int CONTENT_WIDTH=700;
	public static final int CONTENT_HEIGHT=550;
	
	JPanel p_north;
	JButton[] menu;
	String[] menuTitle={
			"��ǰ����","�ֹ�����","ȸ������","�������"
			,"��ü����","����������"
	};
	
	JPanel p_container; //��� �гε��� ��ġ��ų �߾� �г�!!
	JPanel[] p_contents;//�� ȭ����� ����ų �����ڷ���!!

	public AppMain() {	
		connect();
		
		p_north = new JPanel();
		menu = new JButton[menuTitle.length];
		
		for(int i=0;i<menuTitle.length;i++){
			menu[i] = new JButton(menuTitle[i]);
			p_north.add(menu[i]);
		}
		add(p_north, BorderLayout.NORTH);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				//�����ͺ��̽� ���� ���� 
				if(con !=null){
					try {
						con.close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				//���μ��� ����
				System.exit(0);
			}
		});
		
		p_container = new JPanel();
		
		p_contents = new JPanel[menuTitle.length];
		p_contents[0] = new ProductMain();
		p_contents[1] = new OrderMain();
		p_contents[2] = new MemberMain();
		p_contents[3] = new SalesMain();
		p_contents[4] = new PartnerMain();
		p_contents[5] = new StaffMain();
		
		for(int i=0;i<p_contents.length;i++){
			p_container.add(p_contents[i]);
		}
		
		add(p_container);
		setSize(700, 600);
		setVisible(true);
	}
	
	public void connect(){
		//�ڹ� �ҽ� �ڵ� �ܺο� �� Ư�� ������ ������ �о�ͼ�
		//�����ͺ��̽� ������ �����ϸ�, ������������ ��������
		//��?? db ������ ����Ǿ �ڹټҽ��� �ٲ��� �ʾƵ�
		//       �ȴ�..
		URL url=this.getClass().getClassLoader().getResource("com/sds/shopping/db/db.data");
		//System.out.println(url.getPath());
		FileInputStream fis=null;
		
		try {
			fis = new FileInputStream(url.getPath());
			//System.out.println("��Ʈ�� ����");
			
			//key-value �� �̷���� �����͸� �ؼ����ִ� ��ü
			Properties props=new Properties();
			props.load(fis); //������ �ν��� ����!!
			
			String driver=props.getProperty("driver");
			String host=props.getProperty("url");
			String user=props.getProperty("user");
			String password=props.getProperty("password");
			
			Class.forName(driver);
			//�����ͺ��̽� ���� ó��~~~~
			con=DriverManager.getConnection(host, user, password);
			if(con !=null){
				setTitle("���� ����!!");
			}else{
				setTitle("���� ����!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(fis !=null){
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();	
				}
			}
		}
		
	}
	
	//�ܺ��� ��ü���� �� �޼��带 ���ؼ��� ������ 
	//Connection �� �������� ����!!
	public static Connection getConnection(){
		return con;
	}
	
	public static void main(String[] args) {
		new AppMain();
	}

}







