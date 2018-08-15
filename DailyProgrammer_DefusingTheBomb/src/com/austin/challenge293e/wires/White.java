package com.austin.challenge293e.wires;

public class White implements WireState {

	Wire color;
	
	public White() {
		color = Wire.WHITE;
	}
	
	public boolean explodes(Wire next) {
		if(next == null) return true;
		
		// can't cut white or black
		return (next == Wire.WHITE || next == Wire.BLACK);
	}

	
}
