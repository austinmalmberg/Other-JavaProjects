package Opponent;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import Entity.HUD;
import Entity.Opponent;
import Entity.Player;
import GameState.GameState;
import GameState.GameStateManager;
import Main.GamePanel;

public class LevelState extends GameState {

	private Player player;
	private Opponent opponent;
	
	private HUD hud;
	
	public LevelState(GameStateManager gsm) {
		this.gsm = gsm;
		
	}
	
	public void init() {
		
		player = new Player(tileMap);
		player.setPosition(x, y);
		
		hud = new HUD(player);
		
		opponent = new Opponent(tileMap);
		opponent.setPosition(x, y);
	}


	public void update() {
		
		// update player
		player.update();
		
		// update all enemies
		opponent.update();
	}


	public void draw(Graphics2D g) {
		
		// draw tilemap
		tileMap.draw(g);
		
		// draw player
		player.draw(g);
		
		// draw enemies
		opponent.draw(g);
		
		// draw HUD
		hud.draw(g);
	}


	public void keyPressed(int k) {
		if (k == KeyEvent.VK_UP) player.setUp(true);
		if (k == KeyEvent.VK_DOWN) player.setDown(true);
	}

	public void keyReleased(int k) {
		if (k == KeyEvent.VK_UP) player.setUp(false);
		if (k == KeyEvent.VK_DOWN) player.setDown(false);
	}

}
