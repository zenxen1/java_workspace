package com.sds.client.chatting;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JPanel;

import org.json.simple.JSONArray;
import org.json.simple.JSONAware;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.sds.client.AppMain;

public class UserList extends JPanel{
	
	String[] path={"profile.png","2.png","3.png","4.png"};
	String[] status={"오늘잠수탐","벌써2년","법인세","바람소리"};
	
	
	public UserList() {
		setPreferredSize(new Dimension(400, 450));
		getList();
	}
	
	//전체 회원목록 가져오기!!
	public void getList(){
		//소켓을 통해, userlist 요청하자!!
		StringBuffer sb = new StringBuffer();
		sb.append("{");
		sb.append("\"request\" : \"userlist\"");
		sb.append("}");
		
		try {
			AppMain.buffw.write(sb.toString()+"\n");
			AppMain.buffw.flush();
			
			//서버로 부터 결과 받기!!
			String data = AppMain.buffr.readLine();
			System.out.println(data);
			
			
			JSONParser parser = new JSONParser();
			JSONObject jsonObject = (JSONObject)parser.parse(data);
			String result = (String)jsonObject.get("result");
			if(result.equals("ok")){
				JSONArray jsonArray=(JSONArray)jsonObject.get("data");
						
				for(int i=0;i<jsonArray.size();i++){
					JSONObject obj = (JSONObject)jsonArray.get(i);
										
					Item item = new Item((String)obj.get("profile"), (String)obj.get("status"),(Long)obj.get("chatmember"));
					add(item);
				}
				/*
				for(int i=0;i<4;i++){
												
					Item item = new Item(path[i], status[i]);
					add(item);
				}
					*/	 
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
