package game.state;

import java.util.ArrayList;
import java.awt.Graphics2D;

public class GameStateManager {
	private ArrayList<GameState> gameStates;
	private int currentState;
	
	public static final int MENUSTATE = 0;
	public static final int COLLECTIONSTATE = 1;
	public static final int CLASSSELECTSTATE = 2;
	public static final int BOARDSTATE = 3;
	
	public GameStateManager() {
		gameStates = new ArrayList<GameState>();
		
		currentState = 0;
		gameStates.add(new MenuState(this));
		gameStates.add(new CollectionState(this));
		gameStates.add(new ClassSelectState(this));
		gameStates.add(new BoardState(this));
	}
	
	public void setState(int state) {
		currentState = state;
		gameStates.get(currentState).init();
	}
	public void update() {
		gameStates.get(currentState).update();
	}
	public void draw(Graphics2D g) {
		gameStates.get(currentState).draw(g);
	}
	
	public void keyPressed(int k) {
		gameStates.get(currentState).keyPressed(k);
	}
	public void keyReleased(int k) {
		gameStates.get(currentState).keyReleased(k);
	}
	
	public void mouseClicked(Object obj) {
		gameStates.get(currentState).mouseClicked(obj);
	}
	public void mouseEntered(Object obj) {
		gameStates.get(currentState).mouseEntered(obj);
	}
	public void mouseExited(Object obj) {
		gameStates.get(currentState).mouseEntered(obj);
	}
	public void mousePressed(Object obj) {
		gameStates.get(currentState).mousePressed(obj);
	}
	public void mouseReleased(Object obj) {
		gameStates.get(currentState).mouseReleased(obj);
	}
}
