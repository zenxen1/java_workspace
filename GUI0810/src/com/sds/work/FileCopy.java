/*
사진을 실행중인 자바 프로그램으로 읽어들여, 원하는 디렉토리에 복원시키자!!= 복사
자바에서는 입출려과 관련된 기능을 java.io 패키지에서 지원하며
이예제에서는 여러 입출력 관련 기능중 파일을 대상으로 한 io 처리를 실습해본다
*/
package com.sds.work;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
class FileCopy{
	FileInputStream fis; // 파일을 대상으로 한 입력 스트립
	FileOutputStream fos; // 파일을 대상으로 한 출력스트림
	String name; 
	String dest; 

	public void Copy(){
		//아래의 코드는 실행시 에러의 가능성을 안고 있는 고드이다!!
		//따라서 올바르지 않은 경로를 실수로 넣을 경우, 프로그램은 아무런 대책이 없다
		//은 비정상 종료가 되어 버린다!! 
		//예외처리의 목적? 비정상 종료의 방지
		try{
			fis = new FileInputStream(name);
			fos = new FileOutputStream(dest);
			int data;//읽어들인 알갱이 1알을 받기 위한 변수
			while(true){
			    data = fis.read();// 1byte 읽기
				//System.out.println(data);
				//읽어들인 데이터 빈 파일에 출력하자!!
				fos.write(data);
				if(data==-1)break;
			}

		}catch(FileNotFoundException e){
			e.printStackTrace();
			System.out.println("존재하지 않는 경로 입니다.");
		}catch(IOException e){
			System.out.println("파일을 일기 에러!!");
		}finally{
			/*예외처리시 try문이건, catch문이 수행된 이후 무조건 처리해야 할 로직이 있다면 finally에서 작업해 준다!!
			   finally이란? try문이나 catch문을 진입한 실행부는 반드시 finally에 도달하게 되어있다. 따라서 반드시
			   처리해야 할 작업에 사용될 수 있다...
			   사실상 거의 대부분 db 닫는 작업, 스트림 닫는 작업에 압도적으로 많이 사용됨*/

		
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
