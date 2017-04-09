package game.state;

import game.card.*;

import java.awt.Graphics2D;

import background.Background;

public class BoardState extends GameState {
	private Background bg;
	
	Card c;
	
	public BoardState(GameStateManager gsm) {
		this.gsm = gsm;
		
		try {
			bg = new Background("/backgrounds/boardbg.png");
			
			c = new ChillwindYeti();
			c.setPosition(300, 100);
		} catch (Exception e) {
			
		}
	}
	
	@Override
	public void init() {
		// board
		
		// hand
		
		// deck
		
		// card

	}

	@Override
	public void draw(Graphics2D g) {
		bg.draw(g);
		
		c.draw(g);
	}

	@Override
	public void update() {
		c.update();
	}

}
