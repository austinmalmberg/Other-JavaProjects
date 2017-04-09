package game.state;


public abstract class GameState {
	
	protected GameStateManager gsm;
	
	public abstract void init();
	public abstract void draw(java.awt.Graphics2D g);
	public abstract void update();

}
