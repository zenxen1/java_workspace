package com.sds.stream;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.File;

public class  StreamTest{
	InputStream is;
	InputStreamReader reader;
	BufferedReader buffr;

	FileWriter writer;
	BufferedWriter buffw; 
	File file;
	String data;
	
	//String desk = "C:/test.txt";
	public StreamTest(){
		is = System.in;
		reader = new InputStreamReader(is);
		buffr = new BufferedReader(reader);
		file = new File("C:/test.txt");
		

	
	try{
		data = null;
		writer = new FileWriter(file);
		buffw = new BufferedWriter(writer);

			while(true){
				data = buffr.readLine();
				System.out.println(data);
				buffw.write(data);
				if(data.equals("exit")){
					//return;
					System.exit(0);
				}
			}
		} catch (IOException e) {
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
		new StreamTest();
	}
}
