/*���� �����忡�� ȭ�鿡 ������ ������Ʈ���� ������ ó���ϴٺ��� ���� �������� �������� ������, 
 * ���� �ϰ����̸鼭 ü�輺�ִ� ��ü�� ������ ���簡 �ʿ��ϰ�, �� ��ü�� �̸��� ObjectManager �� �Ѵ�.
 * */
package com.sds.game;

import java.util.ArrayList;

public class ObjectMananger {
	//���ӿ� �����ϰԵ� ��� ��ü�� ��Ե� �÷���
	ArrayList<GameObject> objectList = new ArrayList<GameObject>();
	
	//ȭ�鿡 �����Ű��!! = �÷��� �����ӿ��� �߰�
	public void addObject(GameObject gameObject){
		objectList.add(gameObject);
		
	}
	
	//ȭ�鿡 �����ϱ�!! = �÷��� �����ӿ��� ����
	public void removeObject(GameObject gameObject){
		objectList.remove(gameObject);
	}
	
}
