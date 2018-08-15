package com.austin.chess.board.objects;

import com.austin.chess.board.Board;

public class Coordinate implements Comparable<Coordinate> {

	private int x;
	private int y;
	
	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Coordinate(double x, double y) {
		this.x = (int) (x / Tile.TILE_SIZE);
		this.y = (int) (y / Tile.TILE_SIZE);
	}
	
	public void setX(int x) { this.x = x; }
	public void setY(int y) { this.y = y; }
	
	public void setFromPosX(double x) { this.x = (int) x / Tile.TILE_SIZE; }
	public void setFromPosY(double y) { this.y = (int) y / Tile.TILE_SIZE; }
	
	public int getX() { return x; }
	public int getY() { return y; }
	
	public double getPosX() { return x * Tile.TILE_SIZE; }
	public double getPosY() { return y * Tile.TILE_SIZE; }
	
	public String toString() { return String.format("%n(%d, %d)", x, y); }

	public boolean inBounds() {
		return x >= 0 && x < Board.COLUMNS &&
				y >= 0 && y < Board.ROWS;
	}
	
	@Override
	public int compareTo(Coordinate o) {
		
		if(x > o.x) return 1;
		if(x < o.x) return -1;
		
		if(y > o.y) return 1;
		if(y < o.y) return -1;
		
		return 0;
	}
}
