/** 
	@author Hammad Shaikh
**/

package com.controller;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import com.sprite.Enemy;

public class Controller {
	
	private int i;
	public List<Enemy> enemies;
	
	public Controller() {
		enemies = new ArrayList<Enemy>();
		addEnemy();
	}
	
	public void draw(Graphics2D g2d) {
		
		for(i=0;i<enemies.size();i++)
			enemies.get(i).draw(g2d);
	}

	public void update() {
		
		for(i=0;i<enemies.size();i++)
			enemies.get(i).update();
	}

	private void addEnemy() {
		
		enemies.add(new Enemy(50,0));  
		enemies.add(new Enemy(100,0));  
		enemies.add(new Enemy(200,0));  
		enemies.add(new Enemy(300,0));  
		enemies.add(new Enemy(500,0));  
	}

	public List<Enemy> getBounds() {
		return enemies; 
	}
 }
