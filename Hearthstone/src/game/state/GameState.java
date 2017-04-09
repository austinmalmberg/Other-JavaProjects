package game.state;

import java.awt.Graphics2D;

public abstract class GameState {

	protected GameStateManager gsm;
	
	public abstract void init();
	public abstract void update();
	public abstract void draw(Graphics2D g);
	
	public abstract void keyPressed(int k);
	public abstract void keyReleased(int k);
	
	public abstract void mouseClicked(Object obj);
	public abstract void mouseEntered(Object obj);
	public abstract void mouseExited(Object obj);
	public abstract void mousePressed(Object obj);
	public abstract void mouseReleased(Object obj);
}
