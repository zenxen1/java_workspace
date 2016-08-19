package com.sds.game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.text.Highlighter.Highlight;

//2 jpanel을 상속받는 이유...페이트 메서드를 재정의 하기 위해서...
public class GamePanel extends JPanel implements Runnable{
	public static final int WIDTH=1024;
	public static final int HEIGHT=768;
	Thread gameThred;
	boolean running;
	ObjectManager objectManager;
	Ship ship;
	Enemy enemy;
	
	public GamePanel() {
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		objectManager = new ObjectManager();
		createShip();
		createEnemy();
		createBlock();
	}
	
	//7 주인공 등장 메서드
	public void createShip(){
		ship = new Ship(0, 300, 50, 50, "Ship",objectManager);
		objectManager.objectList.add(ship);
	}
	
	//14 적군등장 메서드
	public void createEnemy(){
		for(int i=0;i<7;i++){
			enemy = new Enemy(900, 100+(100*i), 50, 50, "Enemy", objectManager);
			objectManager.objectList.add(enemy);
		}
	}
	
	//21.블랙생성 메서드
	public void createBlock(){
		//윗블럭
		for(int i=0;i<20;i++){
			Block block = new Block(i*50, 0, 50, 50, "Block", objectManager);
			objectManager.addObject(block);
		}
		//아랫블럭
		for(int i=0;i<20;i++){
			Block block = new Block(i*50,HEIGHT-50, 50, 50, "Block", objectManager);
			objectManager.addObject(block);
		}
	}
	
	protected void paintComponent(Graphics g) {
		/*
		Image img;
		try {
			img = ImageIO.read(this.getClass().getClassLoader().getResource("space.jpg"));
			g.drawImage(img,0, 0, WIDTH, HEIGHT, this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		//Graphics2D g2=(Graphics2D)g;
		
		//12 움직일때마다 블랙으로 다시 그려준다
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		//6 모든 게임 오브젝트의 tick(),render() 호출
		//ship.rander(g);
		for(int i=0;i<objectManager.objectList.size();i++){
			GameObject obj = objectManager.objectList.get(i);
			obj.rander(g);
			obj.tick();
		}
	}
	public void startGame(){
		if(gameThred != null){
			return;
		}
		gameThred = new Thread(this);
		gameThred.start();
		running = true;
	}
	public void pauseGame(){
		gameThred = null;
		running = false;
	}
	public void exitGame(){
		System.exit(0);
	}
	public void run(){
		while(running){
			try {
				gameThred.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//System.out.println("게임 엔진 작동중...");
			//5 모든 오브젝트들을 대상으로 tick(), render();
			repaint(); //update() --> paint();
		}
	}
}
