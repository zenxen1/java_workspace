package gui;
import java.awt.Frame;
import java.awt.MenuBar;
import java.awt.Menu;
import java.awt.TextArea;
import java.awt.MenuItem;

class Memo{
	public static void main(String[] args){
		//�޸��� ������ ����
		Frame frame=new Frame();

		//�޴���
		MenuBar bar = new MenuBar();

		//�޴���...
		String[] menuTitle = {"����","����","����","����","����"};
		Menu[] menus = new Menu[5];
		for(int i=0;i<menus.length;i++){
			menus[i]=new Menu(menuTitle[i]);0
			bar.add(menus[i]);
		}
		//�����쿡 �޴��� ����
		frame.setMenuBar(bar);

		//�޴������۵�...
		String[] menuitemtitle = {"����","����","��Ÿ","�ڹ�","�ø�"};
		MenuItem[] menuitems = new MenuItem[5];
		for(int i =0;i<menuitems.length;i++){
			menuitems[i] = new MenuItem(menuitemtitle[i]);
			menus[0].add(menuitems[i]);
		}
		

		//TextArea ����
		TextArea area = new TextArea(30,40);
		frame.add(area);

		//������ ũ��,���̰��ϱ�....
		frame.setSize(600,500);
		frame.setVisible(true);
	}
}
