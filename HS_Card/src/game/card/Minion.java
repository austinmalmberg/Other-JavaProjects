package game.card;

import java.awt.Color;
import java.awt.image.BufferedImage;

public abstract class Minion implements Card {
	
	protected BufferedImage image;
	
	protected int x;
	protected int y;

	protected int def_mana;
	protected int def_attack;
	protected int def_health;
	
	protected int max_mana;
	protected int max_attack;
	protected int max_health;
	
	protected int mana;
	protected int attack;
	protected int health;
	
	public Minion() {
		init();
		
		max_mana = mana = def_mana;
		max_attack = attack = def_attack;
		max_health = health = def_health;
	}
	
	public int getMana() {
		return def_mana;
	}
	public int getAttack() {
		return def_attack;
	}
	public int getHealth() {
		return def_health;
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void draw(java.awt.Graphics2D g, int mana, int attack, int health) {
		g.drawImage(image, getX(), getY(), null);
		g.setColor(Color.WHITE);
		g.setFont(FONT);
		g.drawString(Integer.toString(mana), getX() + 5, getY() + 12); // top left
		g.drawString(Integer.toString(attack), getX() + 5, getY() + HEIGHT - 5);  // bottom left
		g.drawString(Integer.toString(health), getX() + WIDTH - 10, getY() + HEIGHT - 5);
	}
}
