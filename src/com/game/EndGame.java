/** 
	@author Hammad Shaikh
**/

package com.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import com.state.State;

public class EndGame extends KeyAdapter{
	
	public void draw(Graphics2D g2d) {
		g2d.setColor(Color.white);
		
		Font f0 = new Font("Broadway",Font.BOLD,60);
	    g2d.setFont(f0);
	    g2d.drawString("Game", 130, 188);
	    g2d.drawString("Over", 335, 240);
	    	    
		Font f1 = new Font("Agency FB",Font.PLAIN,30);
	    g2d.setFont(f1);
	    g2d.drawString("Press Space To Continue", 200, 360);
	     
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_SPACE) 
			Game.state = State.RESPAWN;
	}
}
