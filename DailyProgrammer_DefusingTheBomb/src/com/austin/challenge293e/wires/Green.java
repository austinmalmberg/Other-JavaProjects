package com.austin.challenge293e.wires;

public class Green implements WireState {

	Wire color;
	
	public Green() {
		color = Wire.GREEN;
	}
	
	public boolean explodes(Wire next) {
		if(next == null) return true;
		
		// next must be orange or white
		return !(next == Wire.ORANGE || next == Wire.WHITE);
	}

}
