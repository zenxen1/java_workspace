package gui;
import java.awt.Frame;
import java.awt.MenuBar;
import java.awt.Menu;
import java.awt.TextArea;
import java.awt.MenuItem;

class Memo{
	public static void main(String[] args){
		//메모장 윈도우 선언
		Frame frame=new Frame();

		//메뉴바
		MenuBar bar = new MenuBar();

		//메뉴들...
		String[] menuTitle = {"파일","편집","서식","보기","도움말"};
		Menu[] menus = new Menu[5];
		for(int i=0;i<menus.length;i++){
			menus[i]=new Menu(menuTitle[i]);0
			bar.add(menus[i]);
		}
		//윈도우에 메뉴바 부착
		frame.setMenuBar(bar);

		//메뉴아이템들...
		String[] menuitemtitle = {"열기","저장","기타","자바","올리"};
		MenuItem[] menuitems = new MenuItem[5];
		for(int i =0;i<menuitems.length;i++){
			menuitems[i] = new MenuItem(menuitemtitle[i]);
			menus[0].add(menuitems[i]);
		}
		

		//TextArea 부착
		TextArea area = new TextArea(30,40);
		frame.add(area);

		//윈도우 크기,보이게하기....
		frame.setSize(600,500);
		frame.setVisible(true);
	}
}
