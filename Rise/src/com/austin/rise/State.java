package com.austin.rise;

public enum State {
	OUT ("Out"), STANDING ("Standing"), SITTING ("Sitting");
	
	private final String s;
	
	State(String s) {
		this.s = s;
	}
	
	String getState() { return s; }
}
