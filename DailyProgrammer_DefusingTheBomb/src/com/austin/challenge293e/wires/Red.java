package com.austin.challenge293e.wires;

public class Red implements WireState {

	Wire color;
	
	public Red() {
		color = Wire.RED;
	}

	public boolean explodes(Wire next) {
		if(next == null) return true;		
		
		// green must be cut next
		return !(next == Wire.GREEN);
	}
}
