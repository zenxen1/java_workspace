package com.sds.work;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy2 {
	FileInputStream fis;
	FileOutputStream fos;
	String name="C:/java_workspace/GUI0810/res1/profile.png";
	String desk="C:/java_workspace/GUI0810/res1/pro.png";
	
	public FileCopy2() {
		try {
			fis = new FileInputStream(name);
			fos = new FileOutputStream(desk);
			while(true){
				int data = fis.read();
				System.out.println(data);
				fos.write(data);
				if(data == -1)break;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(fos != null){
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(fis != null){
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		
			
			
	}
	
	public static void main(String[] args){
		new FileCopy2();
	}

}
