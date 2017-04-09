package com.austin.rise;

public class StateManager {
	
	State currentState; // {OUT, STANDING, SITTING}
	
	public StateManager() {		
		currentState = State.OUT;
	}
	
	public void setState(State newState) { currentState = newState; }
	public State getState() { return currentState; }
}
