/*11
 * ���ӿ� ������ ��ü�� �����ϴ� Ŭ���� ���� 
 * 
 * ��ü�� ���� ������ �����ͺ��̽�ȭ ���Ѽ� �����ϵ�,
 * �޸𸮻�... ��ü�� ��Ƽ� ���� = �÷��� �����ӿ� 
 * */
package com.sds.game;
import java.util.ArrayList;

public class ObjectManager {
	ArrayList<GameObject> objectList=new ArrayList<GameObject>(); //�޸𸮻� �����ͺ��̽�!!
	
	//������Ʈ �߰�
	public void addObject(GameObject obj){
		objectList.add(obj);
	}
	
	//������Ʈ ����
	public void removeObject(GameObject obj){
		objectList.remove(obj);
	}
}











