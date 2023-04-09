/** 
	@author Hammad Shaikh
**/

package com.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import com.sprite.Boss;
import com.sprite.Enemy;

public class ScorePanel {
	
	public static int score = 0;
	
	public void draw(Graphics2D g2d) {
			 	
		g2d.setColor(Color.WHITE);
		
		Font f0 = new Font("Bodoni MT Black",Font.PLAIN, 25);
		g2d.setFont(f0);	
		g2d.drawString("Score", 450, 25);
		
		Font f1 = new Font("Bodoni MT Black",Font.PLAIN, 22);
		g2d.setFont(f1);	
		g2d.drawString(Integer.toString(Enemy.getDodges() + Boss.getDodges()), 540, 25);
		
		Font f3 = new Font("Bodoni MT Black",Font.PLAIN,25);
		g2d.setFont(f3);	
		g2d.drawString("Hi Score", 10, 25);
		
		Font f4 = new Font("Bodoni MT Black",Font.PLAIN,22);
		g2d.setFont(f4);		
		g2d.drawString(Integer.toString(Math.max(score, Enemy.getDodges() + Boss.getDodges())), 130, 25);
			
	}
}
