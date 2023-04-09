/** 
	@author Hammad Shaikh
**/

package com.application;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import com.game.Game;

public class Main extends JFrame{

	private static final long serialVersionUID = 1L;

	public Main() {
		initUI();
	}
	
	private void initUI() {
		
		add(new Game());
		pack();
		setTitle("SW");
		setSize(640,480);
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
	}
	
	public static void main(String [] args) {
		
		//explicitly scheduling the object on the EDT (event dispatcher thread)
		//since most Swing object methods are not thread-safe
		SwingUtilities.invokeLater(() -> {
			
			Main main = new Main();
			main.setVisible(true);
		});
		
	}
 }

