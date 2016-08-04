/*
자바도 다른 응용 프로그램 처럼, GUI를 지원한다.
예) 윈도우, 버튼, 체크박스, TextArea 등등을 지원...
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
		//모든 GUI 컴포넌트가 올려질 윈도우 창
		//자바에서 프레임은 디폴트속성이 존재하는데....
		//기본이 보이지 않는 속성을 가지고 있다
		//따라서 보이게 하자!!
		Frame win = new Frame();
		
		win.setVisible(true);
		win.setSize(300,400);
		win.setTitle("나 윈도우");
		
				
		Button bt = new Button("나버튼");
		//자바언어도 html처럼, 각 컴포넌트를 부착하기에 앞서 어디에 어떻게 붙일지에 대한 디자인기능이 지원된다
		//이 예제에서는 무시하고 가겠따...
		FlowLayout flow = new FlowLayout();
		win.setLayout(flow);//배치 방법을 결정하는 메서드	

		//버튼을 프레임에 부착;
		win.add(bt);

		//자바에서는 객체형도 자료형이다!! 따라서 배열도 얼마든지 가능하다..
		Checkbox[] ch = new Checkbox[20];
		for(int i=0;i<20;i++){
			Checkbox c = new Checkbox(i+"번째 박스");
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
