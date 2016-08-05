//�ڹ��� GUI ���� API����  java.awt ��Ű������ �����Ѵ� Ư�� ������� ���� �ٸ� ������Ʈ���� ������ ���ִ�
//��ü�� ��ġ�� ������ ����ؾ� �ϸ�, �� ��ġ�� ������ 5������ �ִ� 
//�� �� BorderLayout�� 
package gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;

public class BorderTest {

	

	public static void main(String[] args) {
		Frame frame = new Frame();
		Button bt_north = new Button("����");
		Button bt_west = new Button("����");
		Button bt_center = new Button("����");
		Button bt_east = new Button("����");
		Button bt_south = new Button("����");
		
		bt_west.setPreferredSize(new Dimension(200, 400));
		//BorderLayout�� ��������!!
		BorderLayout layout = new BorderLayout();
		
		//Frame�� ���̾ƿ��� ��������
		//�����ڰ� ���̾ƿ��� ������ ������, �ش� ��ü�� ����Ʈ ��ġ�����ڰ� ����ǰ� Frame�� ��� ����Ʈ ��ġ�����ڴ� 
		//BorderLayout�̴�!! ���� BorderLayout�� ��� �����ڰ� ������ �������� ������ Center �̴�.
		
		frame.setLayout(layout);
		
		frame.add(bt_north,BorderLayout.NORTH);
		frame.add(bt_west,BorderLayout.WEST);
		frame.add(bt_center,BorderLayout.CENTER);
		frame.add(bt_east,BorderLayout.EAST);
		frame.add(bt_south,BorderLayout.SOUTH);
		
		frame.setVisible(true);
		frame.setSize(500, 500);


	}

}
