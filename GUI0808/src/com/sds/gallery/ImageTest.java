/*�ڹ��� ��� gui������Ʈ�� ������ �׸��� ��ü�� �Ǿ�
 * �����θ� �׸���. �̋� �׸� �׸��� ������ paint�޼���� ǥ���Ǹ�,
 * �� paint �޼����� �Ű������� �ȷ�Ʈ��Ȱ�� ��ü�� Graphics ��ü�� �μ��� ���޵ȴ�.
 * ex) ��ư ������ �׸��� ����
 * */
package com.sds.gallery;

import javax.swing.JFrame;

public class ImageTest extends JFrame{

	MyButton bt;
	MyCanvas can;
	
	public ImageTest(){
		bt=new MyButton("Ŀ���� ��ư");
		can=new MyCanvas();
		add(can);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setSize(300, 400);
	}

	public static void main(String[] args) {
		new ImageTest();

	}

}
