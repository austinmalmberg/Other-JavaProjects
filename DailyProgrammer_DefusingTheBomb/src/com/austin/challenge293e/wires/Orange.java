package com.austin.challenge293e.wires;

public class Orange implements WireState {

	Wire color;
	
	public Orange() {
		color = Wire.ORANGE;
	}

	public boolean explodes(Wire next) {
		if(next == null) return true;
		
		// must cut red or black
		return !(next == Wire.RED || next == Wire.BLACK);
	}
}
