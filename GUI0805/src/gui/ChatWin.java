/*
 * java.awt�� os �÷������� (Linux, Mac, Window..)�������� Ʋ����. ���� �̸� ������ api�� Swing�� ����غ���
 * 
 * Swing Ư¡
 * -javax.swing ��Ű������ ����
 * -������Ʈ�� awt ���� ���� Button --> JButton
 * 
 * ����!! - awt�� ���ؼ��� �ȵȴ�!!!
 *          ��? ���� �������°� �̿ܿ��� ������ ���ȴ�!!!
 *          ���)GUI ���α׷��� ���߽� swing + awg ����!!
 * 
 * �ڹ��� GUI ������Ʈ�� ���� ũ�� 2���� �ִ�.
 * 1. Container (���� �����ϴ� ������Ʈ) 
 *     - JFrame(BorderLayout ����Ʈ)
 *     - JPanel(FlowLayout ����Ʈ)
 *        �����̳��̴�..������ �ܵ����� ������ �� ����, �ݵ�� �����Ӿȿ� �ҼӵǾ� �ִ�.
 *        Ư¡ - ���� ������ �ʴ´�(div ���)
 *        �ֿ뵵 - Frame������ ������ ������ ���̾ƿ��� ���� ��Ű�� ������ ���
 *     - Applet(FlowLayout ����Ʈ)
 * 2. Visual Component(���Դ��ϴ� ������Ʈ) 
 *     - JButton, JCheckbox, JTextArea ���
 * */
package gui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatWin extends JFrame{
	JTextArea ta;
	JTextField tf;
	JButton bt;
	JPanel panel;
	
	public ChatWin(){
		super("ä��Ŭ���̾�Ʈ");
		JTextArea ta = new JTextArea();
		JTextField tf = new JTextField(15);
		JButton bt = new JButton("����");
		JPanel panel = new JPanel();
		
		//�гο� txt�� bt�� ����!1
		panel.add(tf);
		panel.add(bt);
		
		//area �� ���Ϳ� ����!!
		add(ta,BorderLayout.CENTER);
		add(panel,BorderLayout.SOUTH);
		
		//������ â�� ������, ���μ����� ���̱�!!
		setDefaultCloseOperation(EXIT_ON_CLOSE );
		
		setSize(300, 400);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new ChatWin();
	
	}

}
