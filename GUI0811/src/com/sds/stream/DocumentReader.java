/*�������� ���α׷����� ������ �ѱ��� �ȱ��� ����� �˾ƺ���
 * ���ڽ�Ʈ��...
 * 
 * ��Ʈ���� ����
 * ���⼺ - �Է�,���
 * �������� ���� - ���ڱ�� (2 byte �� ��� ������ �� �ִ� ��Ʈ��)
 *                     - ����Ʈ���(1 byte ���� ������ �� �ִ� ��Ʈ��)
 * reader,wirter �� ���ڱ�� ���,�Է� ��Ʈ���̴�..
 * 
 * ����Ʈ���, ���ڱ��, ���۱�� 3�ܰ谡 ����!!
 * */
package com.sds.stream;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DocumentReader {
	FileInputStream fis;
	FileOutputStream fos;
	FileReader reader;
	FileWriter writer;
	BufferedReader buffr;//���� ó���� ���� ��� �Է� ��Ʈ��
	BufferedWriter buffw; //���� ó���� ���� ��� ��� ��Ʈ��
	
	String ori = "C:/java_workspace/GUI0811/res/memo.txt";
	String desk = "C:/java_workspace/GUI0811/res/memo1.txt";

	public DocumentReader() {
		
		try {
			reader = new FileReader(ori);
			writer = new FileWriter(desk);
			
			buffr = new BufferedReader(reader);
			buffw = new BufferedWriter(writer);
						
			//int data;
			String data = null;
			while ((data= buffr.readLine())!=null){
				System.out.println(data);
				buffw.write(data);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(reader != null){ //�޸𸮿� �ִٸ� ������!! �������÷��Ͱ� ���� ���ִ��� ��...
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(writer != null){
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public static void main(String[] args) {
		new DocumentReader();
	}
}
