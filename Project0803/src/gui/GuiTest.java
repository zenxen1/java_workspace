/*
�ڹٵ� �ٸ� ���� ���α׷� ó��, GUI�� �����Ѵ�.
��) ������, ��ư, üũ�ڽ�, TextArea ����� ����...
*/
package gui;
import java.awt.Frame;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Checkbox;
import java.awt.TextField;
import java.awt.TextArea;
import java.awt.Choice;

class GuiTest{
	public static void main(String[] args){
		//��� GUI ������Ʈ�� �÷��� ������ â
		//�ڹٿ��� �������� ����Ʈ�Ӽ��� �����ϴµ�....
		//�⺻�� ������ �ʴ� �Ӽ��� ������ �ִ�
		//���� ���̰� ����!!
		Frame win = new Frame();
		
		win.setVisible(true);
		win.setSize(300,400);
		win.setTitle("�� ������");
		
				
		Button bt = new Button("����ư");
		//�ڹپ� htmló��, �� ������Ʈ�� �����ϱ⿡ �ռ� ��� ��� �������� ���� �����α���� �����ȴ�
		//�� ���������� �����ϰ� ���ڵ�...
		FlowLayout flow = new FlowLayout();
		win.setLayout(flow);//��ġ ����� �����ϴ� �޼���	

		//��ư�� �����ӿ� ����;
		win.add(bt);

		//�ڹٿ����� ��ü���� �ڷ����̴�!! ���� �迭�� �󸶵��� �����ϴ�..
		Checkbox[] ch = new Checkbox[20];
		for(int i=0;i<20;i++){
			Checkbox c = new Checkbox(i+"��° �ڽ�");
			ch[i]=c;
			win.add(ch[i]);
		}

		TextField tf = new TextField(20);
		win.add(tf);

		TextArea area = new TextArea(20,20);
		win.add(area);

		Choice c = new Choice();
		for(int i=1;i<13;i++){
			c.add(Integer.toString(i));
		}
		win.add(c);
	}
}
