package com.austin.challenge293e.wires;

public class Purple implements WireState {

	Wire color;
	
	public Purple() {
		color = Wire.PURPLE;
	}
	
	public boolean explodes(Wire next) {
		if(next == null) return true;
		
		// can't cut purple, green, orange, or white
		return (next == Wire.PURPLE ||
				next == Wire.GREEN ||
				next == Wire.ORANGE ||
				next == Wire.WHITE);
	}
}
