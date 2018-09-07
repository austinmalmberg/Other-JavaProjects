package com.austin.patterns;

public class Stills {

	public static final boolean[][] BLOCK = new boolean[][] {
		{false, false, false, false},
		{false, true , true , false},
		{false, true , true , false},
		{false, false, false, false}
	};
	
	public static boolean[][] BEEHIVE = new boolean[][] {
		{false, false, false, false, false, false},
		{false, false, true , true , false, false},
		{false, true , false, false, true , false},
		{false, false, true , true , false, false},
		{false, false, false, false, false, false}
	};
	
	public static final boolean[][] LOAF = new boolean[][] {
		{false, false, false, false, false, false},
		{false, false, true , true , false, false},
		{false, true , false, false, true , false},
		{false, false, true , false, true , false},
		{false, false, false, true , false, false},
		{false, false, false, false, false, false}
	};
}
