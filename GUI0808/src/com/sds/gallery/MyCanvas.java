/*���־� ������Ʈ���� ��κ� sun���� ������ ������ �س���
 * ���̱� ������ �����ڰ� �ֵ��Ͽ� , �׷��� ó���� �� �ʿ䰡 ����. ������ ������Ʈ �� �����ڰ� �׷���ó���� �ֵ��Ͽ�
 * �׷��� ó���� �� �ʿ䰡 ���� ������ ������Ʈ �� �����ڰ� �׷��� ó���� �ֵ��Ͽ� ���� �Ҽ� �ֵ��� �����ϴ�
 * ������Ʈ�� �ִ�.
 * �����ֺ����� ---> canvas,jpanel,jframe���..
 *                          �� ĵ������ �����̳ʷ��� ��� ����
 * 
 * java.awt������ image Ŭ������ �Ϲ��� �ȴ� �߻�Ŭ�����̴�
 * ���� new�Ҽ� ����!!
 * �ذ�å) ��Ģ�� �߻�Ŭ������ �ڽĿ� ���� �ϼ��ǹǷ�, Image�� ��ӹ޾� 
 * �޼��带 �������� �� �ڽ� Ŭ������ �ν��Ͻ��� �ø���, �θ� �ö������...�ַ�
 * sun���� �����ϴ� ��ü�� �߻��� ��� �ݵ�� �� ��Ģ��� ���� �� �ʿ�� ���� �س��� ��찡 ����
 * �ַ� , �̹� �߻�Ŭ������ �ν��Ͻ��� ���������� ���ϰ� ���� �� �ִ� ����� ������ �ش�..
 * awt������ toolkit�� �̿��Ͽ� �̹����� ������ش�
 * */

package com.sds.gallery;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class MyCanvas extends Canvas{
	Toolkit kit=Toolkit.getDefaultToolkit();
	
	//������ ��� toolkit�� �̿��Ͽ� �̹����� ���ü� �ִ�..!!
	Image img;
	
	public MyCanvas() {
		setBackground(Color.yellow);
		img = kit.getImage("C:/java_workspace/GUI0808/res/����.png");
	}
	@Override
	public void paint(Graphics g) {
		g.drawRect(100, 50, 200, 200);
		g.drawString("���� �׸� ��Ʈ��", 100, 100);
		g.drawOval(0, 0, 100, 100);
		g.drawImage(img, 0, 100, this);
	}
}
