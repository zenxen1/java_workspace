package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

/*자바에서는 마우스 누르는 이벤트를 click이라고 부르지 않는다!!
그럼 ActionEvent라 한다!!
GUI 컴포넌트 상에서 클릭 이벤트가 발생하면, 제일 먼저 os가 감지하여 
알맞는 정보를 JVM에 넘기면, 이제서야 jvm은 해당 이벤트에 알맞는
EVENT 객체를 메모리에 올린다!!
ex) 마우스클릭 -> WINDOW감지 -> JVM전달 -->ActionEvent 객체 인스턴스 생성 ->리스너에 전달
*/
public class EventTest extends JFrame implements ActionListener{
	JButton bt;
	JButton bt2;
	
	//has a 관계? 멤버변수로 보유한 데이터가 객체형일때...
	public EventTest(){
		bt = new JButton("왼쪽버튼");
		bt2 = new JButton("우측버튼");
		//부착전에 레이아웃 결정!!
		setLayout(new FlowLayout());
		add(bt);
		add(bt2);
		//버튼과 리스너와의 연결!!!
		bt.addActionListener(this);
		bt2.addActionListener(this);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setSize(300, 400);
		
	}

	//jdk 5부터 지원하는 어노테이션이라는 주석!!
	//일반 주석과 틀린점? 프로그램 실행시 사용될 수 있는 주석
	@Override
	//아래의 메서드는 사용자가 ActionEvent 일으킬때 마다 호출된다
	//그리고 매개변수로 해당 ActionEvent 인스턴스가 전달된다!!!
	
	//이벤트를 일으킨 주체 컴포넌트를 자바에서는 이벤트 소스라 한다. 따라서 현재 action
	//이벤트를 일으킨 주체는 버튼이므로, 버튼이 이벤트 소스가 된다...
	public void actionPerformed(ActionEvent e) {
		//Action 이벤트는 반드시 버튼에만 제공 할수 있는 이벤트가 아니라 다른 컴포넌트도 ActionEvent를 일으킬수
		//있다. 따라서 sun에서는 현재 발생한 이벤트가 버튼에 의한 것인지, 다른 컴포넌트에 의한 것인 예측할 수 
		//없으므로 가장 상위인 object형으로 받아버린다...
		Object obj = e.getSource();
		JButton btn =(JButton)obj;
		
		if(btn==bt){
			System.out.println("좌측눌렀어");
		}else if(btn==bt2){
			System.out.println("우측눌렀어");
		}
	}
	
	
	public static void main(String[] args){
		new EventTest();
		
	}

}
