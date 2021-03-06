//접속자마다 1:1로 요청을 처리하기 위한 서버측의 쓰레드 소켓을 봐관한다..
//왜?? 각종 요청이나 대화를 나눌려고...
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
	Servermain serverMain;
	
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	StringBuffer sb;
	
	public ServerThread(Servermain serverMain, Socket client) {
		this.client = client;
		this.serverMain = serverMain;
		con=serverMain.con;
		try {
			buffr = new BufferedReader(new InputStreamReader(client.getInputStream()));
			buffw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void listen(){
		try {
			String msg =buffr.readLine();
			//3.request=login&id=zino&pwd=1234
			//제이슨형식으로  하자
			serverMain.area.append(msg+"\n");
			
			//msg는 클라이언트의 요청 타입에 따라 서버측의 업무내용은 달라질수 있다(즉 언제나 채팅은 아니다..)
			JSONParser jsonParser = new JSONParser();
			try {
				//파싱한 이후 시점부터는 문자열에 불과했던 제이슨 형식의 데이터를 마치 객체처럼 사용할수 있다.
				JSONObject jsonObject = (JSONObject)jsonParser.parse(msg);
				
				//5.클라이언트읭 요청이 로그인 이라면..
				if(jsonObject.get("request").equals("login")){
					serverMain.area.append("로그인을 원하는 군요");
					
					//쿼리문 수행
					String sql="select * from chatmember";
					sql=sql+" where id=? and password=?";
					
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, (String)jsonObject.get("id"));
					pstmt.setString(2, (String)jsonObject.get("password"));
					
					rs = pstmt.executeQuery();//select 문일 경우 
					
					//rs정보를 문자열로 변환하여 보내주자!!!
					sb = new StringBuffer();
					
					sb.delete(0, sb.length());
					
					sb.append("{");
					sb.append("\"response\" : \"login\",");
					
					if(rs.next()){
						String name = rs.getString("name");
						int chatmember_id = rs.getInt("chatmember_id");
						
						sb.append("\"result\":\"ok\",");
						sb.append("\"data\":{");
						sb.append("\"name\":\""+name+"\",");
						sb.append("\"chatmember_id\":"+chatmember_id);
						sb.append("}");
					}else{
						sb.append("\"result\":\"fail\",");
						sb.append("\"data\":{");
						sb.append("}");
					}
					sb.append("}");
					
					release(pstmt, rs);
					//쿼리객체 생성..불과 (수행도 못함)
					
					//클라이언트의 요청이 대화라면
				}else if(jsonObject.get("request").equals("chat")){
				
					//클라이언트의 요청이 회원가입이라면
				}else if(jsonObject.get("request").equals("regist")){
					
				}else if(jsonObject.get("request").equals("userlist")){
					String sql ="select * from chatmember";
					pstmt = con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
					rs = pstmt.executeQuery();
					
					//rs의 커서 위치를 레코드의 제일 마지막으로 옮기기
					rs.last();
					int total = rs.getRow();//현재 레코드의 위치를 반환!!
					
					sb.delete(0, sb.length());//String buffer 초기화
					
					sb.append("{");
					sb.append("\"response\" : \"userlist\",");
					sb.append("\"result\":\"ok\",");
					sb.append("\"data\":[");
					
					int count =0;
					
					rs.beforeFirst();
					while(rs.next()){
						count++;
					
						int chatmember_id = rs.getInt("chatmember_id");
						String id = rs.getString("id");
						String password = rs.getString("password");
						String name = rs.getString("name");
						String profile = rs.getString("profile");
						String status = rs.getString("status");
						
						sb.append("{");
						sb.append("\"chatmember\":"+chatmember_id+",");
						sb.append("\"id\":\""+id+"\",");
						sb.append("\"password\":\""+password+"\",");
						sb.append("\"name\":\""+name+"\",");
						sb.append("\"profile\":\""+profile+"\",");
						sb.append("\"status\":\""+status+"\"");
						if(count <= total-1){
							sb.append("},");
						}else{
							sb.append("}");
						}
					}
					sb.append("]");
					sb.append("}");
					
				}
			} catch (ParseException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			sendMsg(sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void sendMsg(String msg){
		try {
			buffw.write(msg+"\n");
			buffw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void run() {
		while(true){
			listen();
		}
	}
	//데이터베이스 관련 객체 닫는 메서드!!
	//DML (insert,
	public void release(PreparedStatement pstmt){
		try {
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void release(PreparedStatement pstmt,ResultSet rs){
		try {
			pstmt.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
