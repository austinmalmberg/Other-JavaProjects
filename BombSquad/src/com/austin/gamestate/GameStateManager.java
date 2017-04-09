package com.austin.gamestate;

import java.awt.Graphics;
import java.util.ArrayList;

import com.austin.gamestate.level.LevelState;

public class GameStateManager {

	private ArrayList<GameState> gameStates;
	private int currentState;
	
	public static final int MENU_STATE = 0;
	public static final int LEVEL_STATE = 1;
	
	public GameStateManager() {
		gameStates = new ArrayList<>();
		
		gameStates.add(new MenuState(this));
		gameStates.add(new LevelState(this));
		
		setState(MENU_STATE);
	}
	
	public void setState(int state) {
		currentState = state;
		gameStates.get(currentState).init();
	}
	
	public void update() {
		gameStates.get(currentState).update();
	}
	
	public void draw(Graphics g) {
		gameStates.get(currentState).draw(g);
	}
	
	public void keyPressed(int k) {
		gameStates.get(currentState).keyPressed(k);
	}
	
	public void keyReleased(int k) {
		gameStates.get(currentState).keyReleased(k);
	}
	
	public void mousePressed(int x, int y) {
		gameStates.get(currentState).mousePressed(x, y);
	}
	
	public void mouseReleased(int x, int y) {
		gameStates.get(currentState).mouseReleased(x, y);
	}
}
