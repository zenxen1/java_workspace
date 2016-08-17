/*
 ������ stage �ν� ���������� ��� �׷����� ó���Ǵ� ����!!
 */
package com.sds.game;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;
public class GamePanel extends JPanel implements Runnable{
	public static final int WIDTH=1024;
	public static final int HEIGHT=768;
	Thread gameThread; //������ �����!!!
	boolean flag=true;
	
	//������Ʈ �Ŵ���!
	ObjectMananger objectMananger;
	
	//���ΰ�����
	Hero hero;
	
	//������ ����
	Enemy[] enemy = new Enemy[5];
	
	public GamePanel() {
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
		objectMananger = new ObjectMananger();
		
		createHero();//���ΰ�����
		createEnemy();//��������
	}
	
	//���ΰ� ���� �޼��� ����1!
	public void createHero(){
		hero = new Hero(100,200,50,50,"Hero",this);
		
		//������Ʈ ����Ʈ ���(�����ͺ��̽��� ���)
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
		//��� ���� ������Ʈ���� ����ִ� ����� �̿��Ͽ� ��� ���� ������Ʈ�� tick, render ȣ���ϰ� ����!!
		for(int i=0;i<objectMananger.objectList.size();i++){
			GameObject obj = objectMananger.objectList.get(i);
			obj.tick();
			obj.render(g);
		}
		/*
		hero.render(g);

		//�г��� �׷��Ƚ� 
		//System.out.println("paintȣ��!!");
		for(int i=0;i<enemy.length;i++){
			enemy[i].render(g);
		}
		*/
	}
	
	//���� ���� �޼��� 
	public void startGame(){
		if(gameThread != null){
			return;
		}
		flag=true;
		gameThread = new Thread(this);
		gameThread.start();
	}
	//�Ͻ� ���� �޼��� 
	public void pauseGame(){
		flag=false;
		gameThread=null;
	}
	//�������� �޼��� 
	public void exitGame(){
		System.exit(-1); //���μ��� ����, ���� �ڹ����α׷� ����
	}
	
	public void run() {
		while(flag){
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//System.out.println("���� ���� �۵� ��...");
			
			repaint();
			/*
			hero.tick();
			repaint();//update ----> paint()
			
			//��� ȭ�鿡 ������ ������ ������ ����!!!
			for(int i=0;i<enemy.length;i++){
				enemy[i].tick();
			}
			*/
		}
	}
	
}









