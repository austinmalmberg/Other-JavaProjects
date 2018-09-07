package com.austin.patterns;

public class Oscillators {

	public static final boolean[][] BLINKER = new boolean[][] {
		{false, false, false, false, false},
		{false, false, false, false, false},
		{false, true , true , true , false},
		{false, false, false, false, false},
		{false, false, false, false, false}
	};
	
	public static final boolean[][] TOAD = new boolean[][] {
		{false, false, false, false, false, false},
		{false, false, false, false, false, false},
		{false, false, true , true , true , false},
		{false, true , true , true , false, false},
		{false, false, false, false, false, false},
		{false, false, false, false, false, false}
	};
	
	public static final boolean[][] BEACON = new boolean[][] {
		{false, false, false, false, false, false},
		{false, true , true , false, false, false},
		{false, true , true , false, false, false},
		{false, false, false, true , true , false},
		{false, false, false, true , true , false},
		{false, false, false, false, false, false}
	};
	
	public static final boolean[][] PULSAR = new boolean[][] {
		{false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
		{false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
		{false, false, false, false, true , true , true , false, false, false, true , true , true , false, false, false, false},
		{false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
		{false, false, true , false, false, false, false, true , false, true , false, false, false, false, true , false, false},
		{false, false, true , false, false, false, false, true , false, true , false, false, false, false, true , false, false},
		{false, false, true , false, false, false, false, true , false, true , false, false, false, false, true , false, false},
		{false, false, false, false, true , true , true , false, false, false, true , true , true , false, false, false, false},
		{false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
		{false, false, false, false, true , true , true , false, false, false, true , true , true , false, false, false, false},
		{false, false, true , false, false, false, false, true , false, true , false, false, false, false, true , false, false},
		{false, false, true , false, false, false, false, true , false, true , false, false, false, false, true , false, false},
		{false, false, true , false, false, false, false, true , false, true , false, false, false, false, true , false, false},
		{false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
		{false, false, false, false, true , true , true , false, false, false, true , true , true , false, false, false, false},
		{false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
		{false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false}
	};
	
}
