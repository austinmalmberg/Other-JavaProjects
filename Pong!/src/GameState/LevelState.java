package GameState;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import Entity.Enemy;
import Entity.HUD;
import Entity.Player;
import Entity.Enemies.Slugger;
import Main.GamePanel;
import TileMap.Background;
import TileMap.TileMap;

public class LevelState extends GameState {

	
	public LevelState(GameStateManager gsm) {
		this.gsm = gsm;
		
	}
	
	public void init() {
		
		player = new Player(tileMap);
		player.setPosition(100, 150);
		
		hud = new HUD(player);
		
		enemies = new ArrayList<Enemy>();
		
		Slugger s;
		s = new Slugger(tileMap);
		s.setPosition(250,100);
		enemies.add(s);
	}


	public void update() {
		
		// update player
		player.update();
		
		// center camera on player
		tileMap.setPosition(GamePanel.WIDTH / 2 - player.getX(), GamePanel.HEIGHT / 2 - player.getY());
		
		// set background
		bg.setPosition(tileMap.getX(), tileMap.getY());
		
		// update all enemies
		for (int i = 0; i < enemies.size(); i++) {
			enemies.get(i).update();
		}
	}


	public void draw(Graphics2D g) {
		
		// draw bg
		bg.draw(g);
		
		// draw tilemap
		tileMap.draw(g);
		
		// draw player
		player.draw(g);
		
		// draw enemies
		for (int i = 0; i < enemies.size(); i++) {
			enemies.get(i).draw(g);
		}
		
		// draw HUD
		hud.draw(g);
	}


	public void keyPressed(int k) {
		if (k == KeyEvent.VK_LEFT) player.setLeft(true);
		if (k == KeyEvent.VK_RIGHT) player.setRight(true);
		if (k == KeyEvent.VK_UP) player.setUp(true);
		if (k == KeyEvent.VK_DOWN) player.setDown(true);
		if (k == KeyEvent.VK_W) player.setJumping(true);
		if (k == KeyEvent.VK_E) player.setGliding(true);
		if (k == KeyEvent.VK_R) player.setScratching();
		if (k == KeyEvent.VK_F) player.setFiring();
	}

	public void keyReleased(int k) {
		if (k == KeyEvent.VK_LEFT) player.setLeft(false);
		if (k == KeyEvent.VK_RIGHT) player.setRight(false);
		if (k == KeyEvent.VK_UP) player.setUp(false);
		if (k == KeyEvent.VK_DOWN) player.setDown(false);
		if (k == KeyEvent.VK_W) player.setJumping(false);
		if (k == KeyEvent.VK_E) player.setGliding(false);
	}

}
