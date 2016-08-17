/*
 게임의 stage 로써 실제적으로 모든 그래픽이 처리되는 영역!!
 */
package com.sds.game;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;
public class GamePanel extends JPanel implements Runnable{
	public static final int WIDTH=1024;
	public static final int HEIGHT=768;
	Thread gameThread; //게임의 심장부!!!
	boolean flag=true;
	
	//오브젝트 매니져!
	ObjectMananger objectMananger;
	
	//주인공선언
	Hero hero;
	
	//적군들 선언
	Enemy[] enemy = new Enemy[5];
	
	public GamePanel() {
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
		objectMananger = new ObjectMananger();
		
		createHero();//주인공생성
		createEnemy();//적군생성
	}
	
	//주인공 등장 메서드 정의1!
	public void createHero(){
		hero = new Hero(100,200,50,50,"Hero",this);
		
		//오브젝트 리스트 등록(데이터베이스에 등록)
		objectMananger.addObject(hero);
	}
	
	public void createEnemy(){
		
		enemy[0] = new Enemy(600,100,30,30,"Enemy");
		enemy[1] = new Enemy(300,200,30,30,"Enemy");
		enemy[2] = new Enemy(500,300,30,30,"Enemy");
		enemy[3] = new Enemy(800,200,30,30,"Enemy");
		enemy[4] = new Enemy(750,270,30,30,"Enemy");
			
		objectMananger.addObject(enemy[0]);
		objectMananger.addObject(enemy[1]);
		objectMananger.addObject(enemy[2]);
		objectMananger.addObject(enemy[3]);
		objectMananger.addObject(enemy[4]);
		
	}
	
	public void paint(Graphics g) {
		//모든 게임 오브젝트들이 들어있는 명단을 이용하여 모든 게임 오브젝트의 tick, render 호출하게 하자!!
		for(int i=0;i<objectMananger.objectList.size();i++){
			GameObject obj = objectMananger.objectList.get(i);
			obj.tick();
			obj.render(g);
		}
		/*
		hero.render(g);

		//패널의 그래픽스 
		//System.out.println("paint호출!!");
		for(int i=0;i<enemy.length;i++){
			enemy[i].render(g);
		}
		*/
	}
	
	//게임 시작 메서드 
	public void startGame(){
		if(gameThread != null){
			return;
		}
		flag=true;
		gameThread = new Thread(this);
		gameThread.start();
	}
	//일시 정지 메서드 
	public void pauseGame(){
		flag=false;
		gameThread=null;
	}
	//게임종료 메서드 
	public void exitGame(){
		System.exit(-1); //프로세스 종료, 현재 자바프로그램 종료
	}
	
	public void run() {
		while(flag){
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//System.out.println("게임 엔진 작동 중...");
			
			repaint();
			/*
			hero.tick();
			repaint();//update ----> paint()
			
			//모든 화면에 등장한 적군의 물리량 변경!!!
			for(int i=0;i<enemy.length;i++){
				enemy[i].tick();
			}
			*/
		}
	}
	
}









