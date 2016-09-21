/*
 * �����ڸ��� 1:1�� ��û�� ó���ϱ� ���� 
 * �������� ������!! ������ �����Ѵ�..
 * ��?? ���� ��û�̳� ��ȭ�� ��������...
 * 
 * */
package com.sds.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ServerThread extends Thread{
	Socket client;
	BufferedReader buffr;
	BufferedWriter buffw;
	ServerMain serverMain;
	
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	StringBuffer sb = new StringBuffer();
	
	public ServerThread(ServerMain serverMain,Socket client) {
		this.serverMain=serverMain;
		this.client=client;
		con=serverMain.con;
		
		try {
			buffr = new BufferedReader(new InputStreamReader(client.getInputStream()));
			buffw= new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//���
	public void listen(){
		try {
			String msg=buffr.readLine();
			serverMain.area.append(msg+"\n");
			
			//msg�� Ŭ���̾�Ʈ�� ��û Ÿ�Կ� ���� �������� ����
			//������ �޶��� �� �ִ� ( �� ������ ä���� �ƴϴ�...)
			JSONParser jsonParser = new JSONParser();
			
			//�Ľ��� ���� �������ʹ� ���ڿ��� �Ұ��ߴ� ���̽�����
			//�� �����͸� ��ġ ��üó�� ����� �� �ִ�!!
			JSONObject jsonObject=(JSONObject)jsonParser.parse(msg);
			
			//Ŭ���̾�Ʈ�� ��û�� �α��� �̶��...
			if(jsonObject.get("request").equals("login")){
				serverMain.area.append("�α����� ���ϴ� ����");
				
				//������ ����
				String sql="select * from chatmember where id=? and password=?";
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, (String)jsonObject.get("id"));
				pstmt.setString(2, (String)jsonObject.get("password"));
				
				rs=pstmt.executeQuery(); //select ���� ���...
				
				//StringBuffer ����� ��� ����!!!
				sb.delete(0, sb.length());
				
				//rs������ ���ڿ��� �����Ͽ� ��������!!
				sb.append("{");
				sb.append("\"response\" : \"login\",");
				if(rs.next()){
					String name=rs.getString("name");
					int chatmember_id=rs.getInt("chatmember_id");
					
					sb.append("\"result\" : \"ok\",");
					sb.append("\"data\" : {");
					sb.append("\"name\" : \""+name+"\",");
					sb.append("\"chatmember_id\":"+chatmember_id);
					sb.append("}");
				}else{
					sb.append("\"result\" : \"fail\",");
					sb.append("\"data\" : {");
					sb.append("}");
				}
				sb.append("}");
				
				release(pstmt, rs);//�ݳ�!!
				
			//Ŭ���̾�Ʈ�� ��û�� ��ȭ���..	
			}else if(jsonObject.get("request").equals("chat")){
				
			//Ŭ���̾�Ʈ�� ��û�� ȸ�������̶��..
			}else if(jsonObject.get("request").equals("regist")){
				
			}else if(jsonObject.get("request").equals("userlist")){
				String sql="select * from chatmember";
				pstmt=con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				rs=pstmt.executeQuery();
				
				//rs�� Ŀ�� ��ġ�� ���ڵ��� ���� ���������� 
				//�ű�� 
				rs.last();
				int total=rs.getRow(); //���� ���ڵ��� ��ġ�� ��ȯ!!
				
				sb.delete(0, sb.length()); //StringBuffer �ʱ�ȭ
				sb.append("{");
				sb.append("\"response\" : \"userlist\",");
				sb.append("\"result\" : \"ok\",");
				sb.append("\"data\" : [");
				
				int count=0;
				rs.beforeFirst();
				
				while(rs.next()){
					count++;
					
					int chatmember_id=rs.getInt("chatmember_id");
					String id=rs.getString("id");
					String password=rs.getString("password");
					String name=rs.getString("name");
					String profile=rs.getString("profile");
					String status=rs.getString("status");
					
					sb.append("{");
					sb.append("\"chatmember_id\" : "+chatmember_id+",");
					sb.append("\"id\" : \""+id+"\",");
					sb.append("\"password\" : \""+password+"\",");
					sb.append("\"name\" : \""+name+"\",");
					sb.append("\"profile\" : \""+profile+"\",");
					sb.append("\"status\" : \""+status+"\"");
					
					if(count <= total-1){
						sb.append("},");
					}else{
						sb.append("}");
					}					
				}
				sb.append("]");
				sb.append("}");	
			}
			
			sendMsg(sb.toString());//�ٽ� ����!!
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//���ϰ�
	public void sendMsg(String msg){
		try {
			buffw.write(msg+"\n");
			buffw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void run(){
		while(true){
			listen();
		}
	}
	
	//�����ͺ��̽� ���� ��ü �ݴ� �޼���!!
	//DML (insert, update , delete)
	public void release(PreparedStatement pstmt){
		if(pstmt !=null){
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	//select ���� ���
	public void release(PreparedStatement pstmt, ResultSet rs){
		if(pstmt !=null){
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}









