/** 
	@author Hammad Shaikh
**/

package com.sprite;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;
import javax.swing.ImageIcon;


public class Enemy extends GlobalPosition {
	
	private int enemyX,enemyY;
	private Random random;
	private double speed;

	private String enemy="/images/enemy1.png"; 

	private static int dodges;

	public Enemy(int x, int y) {
		super(x, y);
		enemyX = getX();
		enemyY = getY();
		random = new Random();
		dodges = 0;
		speed = random.nextInt(3) + 2;
	}
	
	public void draw(Graphics2D g2d) {
		g2d.drawImage(getEnemyImage(), enemyX, enemyY, null);	
	}

	public void update() {
		
		enemyY += speed;
		
		if(enemyY > 480){
			
			++dodges;
			
			//initial x,y and speed
			enemyX = random.nextInt(640);
			enemyY = 0;
			speed = random.nextInt(3) + 2;			
			
		}
	}	
	
	public static void setDodges(int dodges) {
		Enemy.dodges = dodges;
	}
	
	public static int getDodges() {
		return dodges;
	}
	
	public Rectangle getBounds() {	
		return new Rectangle(enemyX + 4, enemyY + 10, 25, 19);
	}

	private Image getEnemyImage() {
		ImageIcon i =new ImageIcon(Enemy.class.getResource(enemy));
		return i.getImage();
	}
 }

