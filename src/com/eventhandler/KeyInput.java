/** 
	@author Hammad Shaikh
**/

package com.eventhandler;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import com.sprite.Player;

public class KeyInput extends KeyAdapter {
	
	private Player p;
	
	public KeyInput(Player p) {
		this.p = p;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		p.keyPressed(e);
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		p.keyReleased(e);
	}
 }

