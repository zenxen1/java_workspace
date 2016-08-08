/*비주얼 컴포넌트들은 대부분 sun에서 적절히 디자인 해놓은
 * 것이기 때문에 개발자가 주도하여 , 그래픽 처리를 할 필요가 없다. 하지만 컴포넌트 중 개발자가 그래픽처리를 주도하여
 * 그래픽 처리를 할 필요가 없다 하지만 컴포넌트 중 개발자가 그래픽 처리를 주도하여 개발 할수 있도록 지원하는
 * 컴포넌트가 있다.
 * 속이텅빈유형 ---> canvas,jpanel,jframe등등..
 *                          즉 캔버스와 컨테이너류는 모두 가능
 * 
 * java.awt에서는 image 클래스가 일반이 안닌 추상클래스이다
 * 따라서 new할수 없다!!
 * 해결책) 원칙상 추상클래스는 자식에 의해 완성되므로, Image를 상속받아 
 * 메서드를 재정의한 후 자식 클래스의 인스턴스를 올릴때, 부모도 올라오지만...주로
 * sun에서 제공하는 객체가 추상일 경우 반드시 이 원칙대로 개발 할 필요는 없게 해놓은 경우가 많다
 * 주로 , 이미 추상클래스의 인스턴스를 간접적으로 편하게 얻을 수 있는 방법을 제공해 준다..
 * awt에서는 toolkit을 이용하여 이미지를 얻게해준다
 * */

package com.sds.gallery;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class MyCanvas extends Canvas{
	Toolkit kit=Toolkit.getDefaultToolkit();
	
	//위에서 얻는 toolkit을 이용하여 이미지를 얻어올수 있다..!!
	Image img;
	
	public MyCanvas() {
		setBackground(Color.yellow);
		img = kit.getImage("C:/java_workspace/GUI0808/res/설현.png");
	}
	@Override
	public void paint(Graphics g) {
		g.drawRect(100, 50, 200, 200);
		g.drawString("나는 그림 스트링", 100, 100);
		g.drawOval(0, 0, 100, 100);
		g.drawImage(img, 0, 100, this);
	}
}
