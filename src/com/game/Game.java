/** 
	@author Hammad Shaikh
**/

package com.game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.controller.BossController;
import com.controller.Controller;
import com.eventhandler.KeyInput;
import com.eventhandler.MouseInput;
import com.sprite.Boss;
import com.sprite.Enemy;
import com.sprite.Player;
import com.state.State;


public class Game extends JPanel implements ActionListener {
	
	//universal identifier for serializable classes
	private static final long serialVersionUID = 1L;
	
	//static-fields
	private static Player player;
	private static Controller controller;
	private static BossController bossController;
	public static State state;
	
	
	//non-static fields
	private Menu menu;
	private EndGame endGame;
	private String background;
	private Timer gametimer;
	private ScorePanel scorePanel;
	private PlayerCoordinates playerCoordinates;
	
	
	public Game() {
		
		//for making all the components set to focus
		setFocusable(true);
		background = "/images/space.png";
		
		//swing-timer
		gametimer = new Timer(1,this);
		gametimer.start();

		//static
		player = new Player(300,380);
		controller = new Controller();
		bossController = new BossController();
		state = State.MENU;
		
		//non-static
		scorePanel = new ScorePanel();
		menu = new Menu();
		endGame = new EndGame();
		playerCoordinates = new PlayerCoordinates();
		
		addKeyListener(new KeyInput(player));
		addMouseListener(new MouseInput());			
	}
   
	@Override
	public void paintComponent(Graphics g) {
		
		Graphics2D g2D = (Graphics2D) g;
		g2D.drawImage(getBackgroundImage(),0,0,null);

		if(state == State.MENU){
			removeKeyListener(endGame);
			menu.draw(g2D);
		}
		
		else if(state == State.GAME){
			removeKeyListener(endGame);
			player.draw(g2D);
			controller.draw(g2D);
			bossController.draw(g2D);			
			scorePanel.draw(g2D);
			playerCoordinates.draw(g2D);
		}
		
		else if(state == State.END) {
			
			ScorePanel.score = Math.max(ScorePanel.score, Enemy.getDodges() + Boss.getDodges());
			endGame.draw(g2D);		
			scorePanel.draw(g2D);
			playerCoordinates.draw(g2D);
			addKeyListener(endGame);
		}
		
		else if(state == State.RESPAWN) {
			removeKeyListener(endGame);
			controller = new Controller();
			bossController = new BossController();			
			player = new Player(300,380);
			addKeyListener(new KeyInput(player));
			Enemy.setDodges(0);
			Boss.setDodges(0);
			state = State.MENU;
		}
			
	}

	private Image getBackgroundImage() {
	   ImageIcon i = new ImageIcon(getClass().getResource(background));
	   return i.getImage();
	}
	
	@Override
	public void actionPerformed(ActionEvent ee) {

		repaint();
		
		if(state == State.GAME){ 	
			player.update();
			controller.update();
			bossController.update();
		}
	}
	
	public static Controller getController() {
		return controller;
	}

	public static BossController getBossController() {
		return bossController;
	}
 }

