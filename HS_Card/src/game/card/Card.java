package game.card;

import java.awt.Font;

public interface Card {
	
	public static final Font FONT = new Font("Arial", Font.PLAIN, 10);
	
	public static final int WIDTH = 120;
	public static final int HEIGHT = 160;
	
	void init();
	
	void update();	// update mana cost, health, attack
	
	void draw(java.awt.Graphics2D g);		// draw basic card, mana cost, health, attack
	
	int getX();
	int getY();
	void setPosition(int x, int y);
}
