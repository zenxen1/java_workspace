/*
������ �������� �ڹ� ���α׷����� �о�鿩, ���ϴ� ���丮�� ������Ű��!!= ����
�ڹٿ����� ������� ���õ� ����� java.io ��Ű������ �����ϸ�
�̿��������� ���� ����� ���� ����� ������ ������� �� io ó���� �ǽ��غ���
*/
package com.sds.work;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
class FileCopy{
	FileInputStream fis; // ������ ������� �� �Է� ��Ʈ��
	FileOutputStream fos; // ������ ������� �� ��½�Ʈ��
	String name; 
	String dest; 

	public void Copy(){
		//�Ʒ��� �ڵ�� ����� ������ ���ɼ��� �Ȱ� �ִ� ����̴�!!
		//���� �ùٸ��� ���� ��θ� �Ǽ��� ���� ���, ���α׷��� �ƹ��� ��å�� ����
		//�� ������ ���ᰡ �Ǿ� ������!! 
		//����ó���� ����? ������ ������ ����
		try{
			fis = new FileInputStream(name);
			fos = new FileOutputStream(dest);
			int data;//�о���� �˰��� 1���� �ޱ� ���� ����
			while(true){
			    data = fis.read();// 1byte �б�
				//System.out.println(data);
				//�о���� ������ �� ���Ͽ� �������!!
				fos.write(data);
				if(data==-1)break;
			}

		}catch(FileNotFoundException e){
			e.printStackTrace();
			System.out.println("�������� �ʴ� ��� �Դϴ�.");
		}catch(IOException e){
			System.out.println("������ �ϱ� ����!!");
		}finally{
			/*����ó���� try���̰�, catch���� ����� ���� ������ ó���ؾ� �� ������ �ִٸ� finally���� �۾��� �ش�!!
			   finally�̶�? try���̳� catch���� ������ ����δ� �ݵ�� finally�� �����ϰ� �Ǿ��ִ�. ���� �ݵ��
			   ó���ؾ� �� �۾��� ���� �� �ִ�...
			   ��ǻ� ���� ��κ� db �ݴ� �۾�, ��Ʈ�� �ݴ� �۾��� �е������� ���� ����*/

		
			if(fos!=null){
				try{
					fos.close();
				}catch(IOException e){
				}
			}
			if(fis!=null){
				try{
					fis.close();
				}catch(IOException e){
				}
			}
		}
	}
}
