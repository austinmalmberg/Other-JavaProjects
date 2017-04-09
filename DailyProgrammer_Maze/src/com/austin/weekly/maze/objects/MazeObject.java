package com.austin.weekly.maze.objects;

import com.austin.weekly.maze.Maze;

public abstract class MazeObject {
	
	protected int x;
	protected int y;
	
	protected Direction dir;
	
	protected boolean dead;
	
	java.util.Random r = new java.util.Random();
	
	MazeObject(Maze maze) {
		// cannot spawn on walls or the escape char
		
		do{
			y = r.nextInt(Maze.y_max);
			x = r.nextInt(Maze.x_max);
		} while(maze.charAt(y, x) != Maze.EMPTY_TILE);
		
		init();
	}
	
	protected abstract void init();
	
	public abstract char getChar();
	
	public Direction getDirection() { return dir; }
	
	public int getY() { return y; }
	public int getX() { return x; }
	
	public boolean isDead() { return dead; }
	public void setDead(boolean dead) { this.dead = dead; }
}
