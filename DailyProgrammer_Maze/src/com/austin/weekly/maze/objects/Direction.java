package com.austin.weekly.maze.objects;

public enum Direction {	
	Left(0, -1),
	Right(0, 1),
	Up(-1, 0),
	Down(1, 0);
	
	private final int y;
	private final int x;
	
	Direction(int y, int x) {
		this.y = y;
		this.x = x;
	}

	public int x() { return x; }
	public int y() { return y; }
}
