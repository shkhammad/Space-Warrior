/** 
	@author Hammad Shaikh
**/

package com.controller;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import com.sprite.Boss;

public class BossController {
	
	private int i;
	public List<Boss> bosses;
	
	public BossController() {
		bosses = new ArrayList<Boss>();
		addBoss();
	}
	
	public void draw(Graphics2D g2d) {
		
		for(i=0;i<bosses.size();i++)
			bosses.get(i).draw(g2d);
	}

	public void update() {
		
		for(i=0;i<bosses.size();i++)
			bosses.get(i).update();
	}

	private void addBoss() {
		
		bosses.add(new Boss(600,0));  
		bosses.add(new Boss(250,0));  		 
	}

	public List<Boss> getBounds() {
		return bosses; 
	}
}
