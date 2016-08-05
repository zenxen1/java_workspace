/*�ڹ� ����� ���ø����̼��� �̺�Ʈ ���� ����
 * 1�ܰ� - �˸´� �����ʸ� �����ϱ�!!
 * 2�ܰ� - �������� �޼��� ������ �ϱ�!!(�ҿ����� �޼��� �ϼ�)
 * 3�ܰ� - �̺�Ʈ �ҽ�(�̺�Ʈ ����Ų ������Ʈ)�� �����ʿ��� �����ʿ��� ����!!
 * 
 * */
package gui;

import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class KeyTest extends JFrame implements KeyListener {
	JTextField txt;
	JButton bt;
	
	public KeyTest(){
		txt = new JTextField(20);
		bt = new JButton("��ư");
		
		setLayout(new FlowLayout());
		add(txt);
		add(bt);
		
		//���� Ŭ������ ������ ����, �� Key ������
		txt.addKeyListener(this);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setSize(300, 400);
		
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		//System.out.println("�����ٴ�����?");
	}
	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("������ ������?");
	}
	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	
	public static void main(String[] args) {
		
		new KeyTest();
		
	}
}
