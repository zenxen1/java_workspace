/*1.Stream �̶�? �������� �帧
 * 
 * 2. �з�
 *   (1) ���⼺(�������� ���α׷��� ���� = ���μ���)
 *   		�Է�(Input)
 *   		���(Output)
 *   (2) ������ó�� ���
 *       -����Ʈ��� ��Ʈ�� �⺻ ��Ʈ���̸� 1byte�� ����
 *       -���ڱ�� ��Ʈ�� 
 *         2byte�� �����ϴ� ��Ʈ��
 *         �񿵾�� ���ڵ�(2byte�� ó��) ǥ���� �� �ִ�
 *        -���۱�� ��Ʈ��
 *         ������ ������ ���� �߰��Ҷ���, ���ۿ� ��Ƶ� �����͸� �о���̵��� ó���� ��Ʈ�� 
 * */
package com.sds.stream;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class keyBoardStream {
	InputStream is;
	InputStreamReader reader;
	BufferedReader buffer;
	
	public keyBoardStream() {
		//keyboard, ���ڵ� ��ĳ�ʵ� �ý����� �����ϴ� ��Ʈ���� �����ڰ� ���ϴ� ������ ������� ������ �� ����!!
		//���� �ý������κ��� ���;� �Ѵ�!!
		is=System.in;
		reader = new InputStreamReader(is);
		buffer = new BufferedReader(reader);
		
		String data=null;
		int count=0;
		try {
			while(true){
				data = buffer.readLine();
				count++;
				System.out.println(data);
				System.out.println(count);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new keyBoardStream();
	}

}
