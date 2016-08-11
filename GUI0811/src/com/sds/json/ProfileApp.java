package com.sds.json;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ProfileApp {
	FileReader reader; //������ ������� �� �Է½�Ʈ��
	BufferedReader buffr;
	String path = "C:/java_workspace/GUI0811/res/member.json";
	
	
	public ProfileApp() {
		try {
			reader = new FileReader(path);
			buffr = new BufferedReader(reader);
			
			String data = null;
			StringBuffer sb = new StringBuffer();
			while((data = buffr.readLine()) !=null){
				//System.out.println(data);
				sb.append(data);
			}
			//System.out.println(sb.toString());
			//�Ľ̽���
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject)jsonParser.parse(sb.toString());
			JSONArray jsonArray=(JSONArray)jsonObject.get("members");
			
			for(int i=0;i<jsonArray.size();i++){
				JSONObject member = (JSONObject)jsonArray.get(i);
				System.out.println(member.get("name")+","+member.get("gender"));
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
				System.out.println("���̽� ������ ������");
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		new ProfileApp();

	}

}
