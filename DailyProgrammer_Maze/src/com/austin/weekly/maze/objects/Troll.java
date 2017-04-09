package com.austin.weekly.maze.objects;

import com.austin.weekly.maze.Maze;

public class Troll extends MazeObject {

	public static final char ICON = 'T';
	
	private final int CHASE_RANGE = 6;
	private boolean chasing;
	
	public Troll(Maze maze) {
		super(maze);
	}
	
	protected void init() {
		dir = Direction.values()[r.nextInt(Direction.values().length)];
		
		chasing = false;
	}

	public void update(Maze maze, int player_y, int player_x) {
		if(y - player_y == 0 && x - player_x == 0) return;	// don't move if on player
		
		checkChase(player_y, player_x);
		
		if(chasing) {
			pursue(maze, player_y, player_x);
		} else {
			wander(maze);
		}
	}
	
	private void pursue(Maze maze, int player_y, int player_x) {
		// move in vertical direction
		if(Math.abs(y - player_y) > Math.abs(x - player_x)) {
			dir = getVerticalDirection(y - player_y);
			
		// move in horizontal direction
		} else if(Math.abs(y - player_y) < Math.abs(x - player_x)) { 
			dir = getHorzontalDirection(x - player_x);
		} else {
			// pick a random direction because trolls are easily confused
			dir = r.nextBoolean() ?	getVerticalDirection(y - player_y) : getHorzontalDirection(x - player_x);
		}
		
		if(Player.ICONS.contains(maze.charAt(y + dir.y(), x + dir.x())+"") ||	// eat player
				maze.charAt(y + dir.y(), x + dir.x()) == Maze.EMPTY_TILE)		// move to empty tile
			move();
		else if(maze.charAt(y + dir.y(), x + dir.x()) == Maze.BLOCK_TILE &&		// move block
				(maze.charAt(y + dir.y() * 2, x + dir.x() * 2) == Maze.EMPTY_TILE ||
				Player.ICONS.contains(maze.charAt(y + dir.y() * 2, x + dir.x() * 2)+"")))
			move();
			
	}
	
	private void wander(Maze maze) {
		dir = Direction.values()[r.nextInt(Direction.values().length)];
		
		if(Player.ICONS.contains(maze.charAt(y + dir.y(), x + dir.x())+"") ||	// eat player
				maze.charAt(y + dir.y(), x + dir.x()) == Maze.EMPTY_TILE)		// move to empty tile
			move();
	}
	
	private void move() {
			y += dir.y();
			x += dir.x();
	}
	
	private Direction getHorzontalDirection(int diff) {
		return diff > 0 ? Direction.Left : Direction.Right;
	}
	
	private Direction getVerticalDirection(int diff) {
		return diff > 0 ? Direction.Up : Direction.Down;
	}
	
	private void checkChase(int player_y, int player_x) {
		
		// begin chasing
		if(!chasing && Math.abs(y - player_y) <= CHASE_RANGE && Math.abs(x - player_x) <= CHASE_RANGE) {
			System.out.println("Troll: Mmmm, smells like fresh meat!!");
			chasing = true;
		}
		
		// lose chase
		if(chasing && (Math.abs(y - player_y) > CHASE_RANGE || Math.abs(x - player_x) > CHASE_RANGE)) {
			System.out.println("Troll: Where did you go, you little worm?!");
			chasing = false;
		}
	}
	
	public void setChase(boolean b) {
		chasing = b;
	}
	
	public boolean isChasing() { return chasing; }
	
	public char getChar() {
		return ICON;
	}
	
	public void eat() {
		System.out.println("Troll: Ahahaha.  I've finally found you and now I'm going to eat you.");
	}
}
