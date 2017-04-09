package com.austin.challenge.h242;

public class Tile {
	
	Color color;
	Number number;
	
	public Tile() {	}
	public Tile(Color c, Number n) {
		color = c;
		number = n;
	}
	
	public Color getColor() { return color; }	
	public Number getNumber() { return number; }
	
	public String toString() {
		return color + " " + number;
	}
}

enum Color {
	BLACK,
	YELLOW,
	RED,
	PURPLE;
}

enum Number {
	ONE,
	TWO,
	THREE,
	FOUR,
	FIVE,
	SIX,
	SEVEN,
	EIGHT,
	NINE,
	TEN,
	ELEVEN,
	TWELVE,
	THIRTEEN;
}
