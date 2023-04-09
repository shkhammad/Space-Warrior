package com.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import com.sprite.Player;

public class PlayerCoordinates {
	
	public void draw(Graphics2D g2d) {
		
		g2d.setColor(Color.white);
		
		Font font = new Font("Agency FB",Font.BOLD,25);
	    g2d.setFont(font);
	    
	    g2d.drawString("X", 30, 370);
	    g2d.drawString(Integer.toString(Player.getPlayerX()), 50, 370);
		
	    g2d.drawString("Y", 30, 400);
	    g2d.drawString(Integer.toString(Player.getPlayerY()), 50, 400);
	    
	}
}
