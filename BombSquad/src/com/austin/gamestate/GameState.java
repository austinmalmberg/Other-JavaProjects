package com.austin.gamestate;

import java.awt.Graphics;

public abstract class GameState {
	protected GameStateManager gsm;
	
	public abstract void init();
	public abstract void update();
	public abstract void draw(Graphics g);
	public abstract void keyPressed(int k);
	public abstract void keyReleased(int k);
	public abstract void mousePressed(int x, int y);
	public abstract void mouseReleased(int x, int y);
	
}
