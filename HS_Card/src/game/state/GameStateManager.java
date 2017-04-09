package game.state;

import java.util.ArrayList;

public class GameStateManager {
	
	private ArrayList<GameState> gameStates;
	private int currentState;
	
	public static final int BOARD_STATE = 0;
	
	public GameStateManager() {
		gameStates = new ArrayList<GameState>();
		
		currentState = 0;
		
		gameStates.add(new BoardState(this));
	}
	
	public void setState(int state) {
		currentState = state;
		gameStates.get(currentState).init();
	}
	
	public void update() {
		gameStates.get(currentState).update();
	}
	
	public void draw(java.awt.Graphics2D g) {
		gameStates.get(currentState).draw(g);
	}
}
