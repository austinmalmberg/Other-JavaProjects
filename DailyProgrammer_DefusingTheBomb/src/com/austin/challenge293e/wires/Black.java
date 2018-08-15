package com.austin.challenge293e.wires;

public class Black implements WireState {

	Wire color;
	
	public Black() {
		color = Wire.BLACK;
	}
	
	public boolean explodes(Wire next) {
		if(next == null) return true;
		
		// can't cut white, green, orange next
		return (next == Wire.WHITE ||
				next == Wire.GREEN ||
				next == Wire.ORANGE);
	}
}
