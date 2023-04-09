/** 
	@author Hammad Shaikh
**/

package com.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Menu {
	
	private Rectangle pButton = new Rectangle(250,210,120,60);
	private Rectangle qButton = new Rectangle(250,330,120,60);
	
	public void draw(Graphics2D g2d) {
		
		Font f0 = new Font("Broadway",Font.PLAIN,60);
		g2d.setFont(f0);
		g2d.setColor(Color.white);
	    g2d.drawString("SPACE",210,80);
	    g2d.drawString("WARRIOR",155,150);
	    
	    Font f1 = new Font("Agency FB",Font.BOLD,40);
	    g2d.setFont(f1);
	    g2d.drawString("Play",pButton.x + 31,pButton.y + 47);
	    g2d.draw(pButton);
	    g2d.drawString("Quit",qButton.x + 31,qButton.y + 47);
	    g2d.draw(qButton);
	}
 }

