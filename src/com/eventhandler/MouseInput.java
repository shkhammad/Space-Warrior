/** 
	@author Hammad Shaikh
**/

package com.eventhandler;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import com.game.Game;
import com.state.State;

public class MouseInput implements MouseListener {
    
    public void mousePressed(MouseEvent e) {
		
		int mx = e.getX();
		int my = e.getY();

		if(mx >= 250 && mx <= 370){
			if(my >= 210 && my <= 270)
				Game.state = State.GAME;
		}
		
		if(mx >= 250 && mx <= 370){
			if(my >= 330 && my <= 390)
				System.exit(1);
		}
	}
	
    public void mouseClicked(MouseEvent e) {}
    
	public void mouseReleased(MouseEvent e) {}
    
    public void mouseEntered(MouseEvent e) {}
    
    public void mouseExited(MouseEvent e) {}
 }

