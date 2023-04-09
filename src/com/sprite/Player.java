/** 
	@author Hammad Shaikh
**/

package com.sprite;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.ImageIcon;
import com.game.Game;
import com.state.State;

public class Player extends GlobalPosition {
	
	private static int playerX,playerY;
	private int velX,velY;
	private String playerimage;

	public Player(int x, int y) {
		super(x,y);
		playerX = getX();
		playerY = getY();
		velX = 0;
		velY = 0;
		playerimage = "/images/ship.png";
	}

	public void update() {
		
		playerX += velX;
		playerY += velY;
		
		if(playerX < 0)
			playerX = 0;
		
		if(playerY < 0)
			playerY = 0;
		
		if(playerX > 591)
			playerX = 591;
		
		if(playerY > 404)
			playerY = 404;
		
		Collision();
	}

	private void Collision() {
		
		int i;
		List<Enemy> enemies = Game.getController().getBounds();

		for(i=0;i<enemies.size();++i){
			
			if(getBounds().intersects(enemies.get(i).getBounds()))
				Game.state = State.END;	
		}
		
		List<Boss> bosses = Game.getBossController().getBounds();

		for(i=0;i<bosses.size();++i){
			
			if(getBounds().intersects(bosses.get(i).getBounds()))
				Game.state = State.END;	
		}
		
	}

	public static int getPlayerX() {
		return playerX;
	}

	public static int getPlayerY() {
		return playerY;
	}

	public void keyPressed(KeyEvent e) {
		
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_RIGHT)
			velX = 5;
		
		else if(key == KeyEvent.VK_LEFT)
			velX = -5;
		
		else if(key == KeyEvent.VK_UP)
			velY = -5;
		
		else if(key == KeyEvent.VK_DOWN)
			velY = 5;
		
	}

	public void keyReleased(KeyEvent e) {
		
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT)
			velX = 0;
		
		else if(key == KeyEvent.VK_UP || key == KeyEvent.VK_DOWN)
			velY = 0;	
		
	}

	private Rectangle getBounds() {
		return new Rectangle(playerX,playerY,30,28);
	}

	public void draw(Graphics2D g2d) {
		g2d.drawImage(getPlayerImage(), playerX, playerY, null);
	}

	private Image getPlayerImage() {
		ImageIcon i = new ImageIcon(getClass().getResource(playerimage));
		return i.getImage(); 
	}
 }

