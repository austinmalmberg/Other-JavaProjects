package com.austin.weekly.maze.objects;

import com.austin.weekly.maze.Maze;

public class Player extends MazeObject {	
	
	public static final String DIRECTIONS = "adws";		// must be in LEFT, RIGHT, UP, DOWN order
	public static final String ICONS = "<>^v";
	
	private boolean escaped;
	
	public Player(Maze maze) {
		super(maze);
	}
	
	protected void init() {
		dir = Direction.Right;
		dead = false;
		escaped = false;
	}
	
	public void update(Maze maze, char input) {
		dir = Direction.values()[DIRECTIONS.indexOf(input)];	// update player direction from input
		
		if(maze.charAt(y + dir.y(), x + dir.x()) == Troll.ICON ||	// player runs into troll
				maze.charAt(y + dir.y(), x + dir.x()) == Maze.EMPTY_TILE ||	// move to adjacent empty cell
				maze.charAt(y + dir.y(), x + dir.x()) == Maze.ESCAPE_TILE)	// escape
			move();
		else if(maze.charAt(y + dir.y(), x + dir.x()) == Maze.BLOCK_TILE &&			// block is moveable
				(maze.charAt(y + dir.y() * 2, x + dir.x() * 2) == Maze.EMPTY_TILE ||
				maze.charAt(y + dir.y() * 2, x + dir.x() * 2) == Troll.ICON))
			move();
	}
	
	public void move() {
		y += dir.y();
		x += dir.x();
	}
	
	public char getChar() {
		return ICONS.charAt(dir.ordinal());
	}
	
	public void setEscaped(boolean escaped) { this.escaped = escaped; }
	public boolean hasEscaped() { return escaped; }
}
