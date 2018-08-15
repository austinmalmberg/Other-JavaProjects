package com.austin.challenge293e;

import java.util.Arrays;

import com.austin.challenge293e.wires.Wire;
import com.austin.challenge293e.wires.WireState;

/**
 * If you cut a white cable you can't cut white or black cable.
 * If you cut a red cable you have to cut a green one
 * If you cut a black cable it is not allowed to cut a white, green or orange one
 * If you cut a orange cable you should cut a red or black one
 * If you cut a green one you have to cut a orange or white one
 * If you cut a purple cable you can't cut a purple, green, orange or white cable
 * If you have anything wrong in the wrong order, the bomb will explode.
 *  
 * @author Austin Malmberg
 *
 */
public class Bomb {
	
	Wire[] sequence;
	WireState currentState;
	
	public Bomb(String[] sequenceStringArray) {
		sequence = new Wire[sequenceStringArray.length];
		for(int i = 0; i < sequence.length; i++) {
			sequence[i] = Wire.getWire(sequenceStringArray[i]);
		}
	}
	
	public String defuse() {
		
		for(int i = 0; i < sequence.length-1; i++) {
			currentState = sequence[i].getWireState();
			
			if(currentState.explodes(sequence[i+1])) {
				return Arrays.asList(sequence) + " BOOM!!!!";
			}
		}
		
		return Arrays.asList(sequence) + " Bomb defused!";
	}
}
