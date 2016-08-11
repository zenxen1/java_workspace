/*실행중인 프로그램에서 봤을때 한글이 안깨질 방법을 알아보자
 * 문자스트림...
 * 
 * 스트림의 종류
 * 방향성 - 입력,출력
 * 문자지원 여부 - 문자기반 (2 byte 씩 묶어서 이해할 수 있는 스트림)
 *                     - 바이트기반(1 byte 씩만 이해할 수 있는 스트림)
 * reader,wirter 는 문자기반 출력,입력 스트림이다..
 * 
 * 바이트기반, 문자기반, 버퍼기반 3단계가 전부!!
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
	BufferedReader buffr;//버퍼 처리된 문자 기반 입력 스트림
	BufferedWriter buffw; //버퍼 처리된 문자 기반 출력 스트림
	
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
			if(reader != null){ //메모리에 있다면 지우자!! 가비지컬렉터가 언제 없애는지 모름...
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
