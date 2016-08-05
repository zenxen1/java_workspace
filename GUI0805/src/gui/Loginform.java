package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Loginform extends JFrame{
	
	JLabel la_t;
	JLabel la_id;
	JTextField tf_id;
	JLabel la_pw;
	JTextField tf_pw;
	JButton bt_l;
	JButton bt_s;
	JPanel panel;
	JPanel panel2;
	JPanel panel3;
	
	public Loginform(){
		la_t = new JLabel("·Î±×ÀÎ");
		la_id = new JLabel("ID");
		tf_id = new JTextField(20);
		la_pw = new JLabel("PW");
		tf_pw = new JTextField(20);
		bt_l = new JButton("Login");
		bt_s = new JButton("Sign");
		panel = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		
		tf_id.setBackground(Color.yellow);
		tf_pw.setBackground(Color.yellow);
				
		setLayout(new BorderLayout());
		panel2.setLayout(new GridLayout(2,2));
		
		panel.setBackground(Color.white);
		panel2.setBackground(Color.white);
		panel3.setBackground(Color.white);
			
		panel.add(bt_l);
		panel.add(bt_s);
		panel2.add(la_id);
		panel2.add(tf_id);
		panel2.add(la_pw);
		panel2.add(tf_pw);
		panel3.add(la_t);
					
		add(panel3,BorderLayout.NORTH);
		add(panel2,BorderLayout.CENTER);
		add(panel,BorderLayout.SOUTH);
		
		setVisible(true);
		setSize(300, 160);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		new Loginform();

	}

}
