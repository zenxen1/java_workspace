/*
�ڹٸ� �����ؼ� ��κ��� �������α׷������� GUI Ŀ����Ʈ�� ������ ���� �÷������� ��ġ ����� ���� ���� �� �ִ� 
����� ���� �Ѵ�...
�ڹٴ� LayoutManager ��� ��ü�� �����ϰ� ������ ���� ������ �˸´� ��ġ������(LayoutManager)�� �����ؼ�
����ϰ� �ȴ�..

1.BorderLayout(��,��,��,��,������ ������ �����Ǵ� ��ġ ������)
2.FlowLayout(������Ʈ���� �������� ũ�� ������ ���� �帣���� ó���ϴ� ��ġ������)
3.GridLayout(����(�׸���)������� ������Ʈ�� ��ġ�ϴ� ��ġ ������)
4.GridBagLayout(GridLayout�� ����� ���� ���������� ó���ϴ� ��ġ ������)
5.CardLayout(ȭ�鿡 ������ ������Ʈ�� ���� 1���� �����Ű�� ��ġ ������)
*/
package study.gui;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Choice;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.TextArea;
import java.awt.TextField;

public class WidowTest {
	public static void main(String[] args) {
		Frame f = new Frame();
		Label la_id = new Label("ID");
		Label la_pw = new Label("PW");
		TextField t_id = new TextField(15);
		TextField t_pw = new TextField(15);
		Button bt = new Button("�α���");
		Choice c = new Choice();
		TextArea ta = new TextArea();
		Checkbox cb = new Checkbox();
		MenuBar mb = new  MenuBar();
		
		String[] menu = {"�̸�","�縧","�⸧","����","����",};
		Menu[] me = new Menu[5]; 
		for(int i=0; i<5;i++){

		}
		
		
		
		
		
		//�����ӿ� FlowLayout�� ��������!!
		//FlowLayout flow = new FlowLayout();
		//f.setLayout(flow);
		
		f.add(la_id); //�����쿡 ID ���� ����!!
		f.add(t_id); //�����쿡 id �ؽ�Ʈ�ʵ� ����!!
		f.add(la_pw); //�����쿡 PW ���� ����!!
		f.add(t_pw); //�����쿡 tw �ؽ�Ʈ �ʵ� ����!!
		f.add(bt); //�����쿡 ��ư ����!!
		f.add(c);
		f.add(ta);
		f.add(cb);
		f.setMenuBar(mb);
		
		
		
		
		f.setSize(400, 400);
		f.setVisible(true);
		
	}

}
