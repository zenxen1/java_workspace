package com.sds.stream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class  Test{
	InputStream is;
	InputStreamReader reader;
	BufferedReader buffr;

	FileWriter writer;
	BufferedWriter buffw; 
	File file;
	String data;
	
	//String desk = "C:/test.txt";
	public Test(){
		is = System.in;
		reader = new InputStreamReader(is);
		buffr = new BufferedReader(reader);
		file = new File("C:/test.txt");
		

	
	try{
		
		//data = null;
		

			while((data = buffr.readLine()) !=null){
			
				//System.out.println(data);
				
				if(data.equals("exit")){
					//return;
					System.exit(0);
				}
				savefile();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void savefile(){
		try {
			writer = new FileWriter(file);
			buffw = new BufferedWriter(writer);
			buffw.write(data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(buffw != null){
				try {
					buffw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		
	}
	public static void main(String[] args)	{
		new Test();
	}
}
