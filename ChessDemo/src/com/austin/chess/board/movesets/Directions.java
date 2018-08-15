package com.austin.chess.board.movesets;

public enum Directions {
	VERTICAL(0, 1), HORIZONTAL(1, 0), Z_DIAGONAL(1, -1), N_DIAGONAL(1, 1);
	
	private int x;
	private int y;
	
	Directions(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() { return x; }
	public int getY() { return y; }
}
