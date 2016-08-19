package com.sds.game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.text.Highlighter.Highlight;

//2 jpanel�� ��ӹ޴� ����...����Ʈ �޼��带 ������ �ϱ� ���ؼ�...
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
	
	//7 ���ΰ� ���� �޼���
	public void createShip(){
		ship = new Ship(0, 300, 50, 50, "Ship",objectManager);
		objectManager.objectList.add(ship);
	}
	
	//14 �������� �޼���
	public void createEnemy(){
		for(int i=0;i<7;i++){
			enemy = new Enemy(900, 100+(100*i), 50, 50, "Enemy", objectManager);
			objectManager.objectList.add(enemy);
		}
	}
	
	//21.������ �޼���
	public void createBlock(){
		//����
		for(int i=0;i<20;i++){
			Block block = new Block(i*50, 0, 50, 50, "Block", objectManager);
			objectManager.addObject(block);
		}
		//�Ʒ���
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
		
		//12 �����϶����� ������ �ٽ� �׷��ش�
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		//6 ��� ���� ������Ʈ�� tick(),render() ȣ��
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
			//System.out.println("���� ���� �۵���...");
			//5 ��� ������Ʈ���� ������� tick(), render();
			repaint(); //update() --> paint();
		}
	}
}
