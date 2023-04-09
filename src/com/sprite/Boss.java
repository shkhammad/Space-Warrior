package com.sprite;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;

import javax.swing.ImageIcon;

public class Boss extends GlobalPosition{
	
	private int bossX,bossY;
	private Random random;
	private double speed;

	private String enemy = "/images/enemy2.png"; 

	private static int dodges;

	public Boss(int x, int y) {
		super(x, y);
		bossX = getX();
		bossY = getY();
		random = new Random();
		dodges = 0;
		speed = random.nextInt(5) + 5;
	}
	
	public void draw(Graphics2D g2d) {
		g2d.drawImage(getEnemyImage(), bossX, bossY, null);	
	}

	public void update() {
		
		bossY += speed;
		
		if(bossY > 480){
			
			++dodges;
			
			//initial x,y and speed
			bossX = random.nextInt(640);
			bossY = 0;
			speed = random.nextInt(5) + 5;			
			
		}
	}	
	
	public static void setDodges(int dodges) {
		Boss.dodges = dodges;
	}
	
	public static int getDodges() {
		return dodges;
	}
	
	public Rectangle getBounds() {	
		return new Rectangle(bossX + 4, bossY + 10, 25, 19);
	}

	private Image getEnemyImage() {
		ImageIcon i =new ImageIcon(Enemy.class.getResource(enemy));
		return i.getImage();
	}
}
