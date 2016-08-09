/*�������� ���ִ� ��ü�� ǥ���� set�� ���� �н��Ѵ�.
 * set�� ���� ��ü �� HashSet�� �н�����!!
 * */
package com.sds.collection;

import java.util.HashSet;
import java.util.Iterator;

import javax.swing.JButton;


public class SetTest {

	public static void main(String[] args) {
		//Generic Type : �̷��� ������ ���� ä���� ���������� ���������� �ִ�.
		HashSet set = new HashSet();
		//auto boxing
		int x=3;
		Integer i = new Integer(3);
		//set.add(x); 
		/* ���� �������� �Ѵ�!! �ٵ� �� �ȳ���?? �÷��� �����ӿ��� �޼����μ��� int�� ������ �⺻�ڷ����� ����ϸ� �ڵ�����
		 * wrapper ��ü�� ��ȯ�Ǿ�����...��?? �������� �ǵ��� �ľ��Ͽ� ���ŷ��� �ʰ� ���ذ�...*/
		
		//set.add("���");//string ��ü�� ��
		set.add(new JButton("����ư"));//Jbutton�� ��
		set.add(new JButton("���Ʈ"));
		set.add(new JButton("�̹�ư"));
	
		Iterator it = set.iterator();
		
		while(it.hasNext()){
			JButton bt =(JButton)it.next();
			System.out.println(bt.getText());
			
		}
		
	}

}
