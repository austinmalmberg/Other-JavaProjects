package com.austin.weekly.maze;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

import com.austin.weekly.maze.objects.Player;
import com.austin.weekly.maze.objects.Troll;

public class Maze {
	public static final char EMPTY_TILE = ' ';
	public static final char ESCAPE_TILE = 'O';
	public static final char BLOCK_TILE = '#';
	
	public static final char ENEMY_CHAR = 'T';
	public static final int NUM_ENEMIES = 3;
	
	public static int x_max;	// length
	public static int y_max;	// height
	
	private Path path;
		
	private HashMap<Character, Integer> charMap;
	private char[][] map;	// char[0][0] is upper-left position
	
	private Player player;
	private List<Troll> trolls;

	Maze(Path path) {
		this.path = path;
		
		init();
	}
	
	private void init() {
		setDimensions();
		
		charMap = new HashMap<>();
		map = getMap();
		
		player = new Player(this);		
		drawPlayer();
		
		trolls = new ArrayList<>();
		for(int i = 0; i < NUM_ENEMIES; i++) {
			trolls.add(new Troll(this));
		}
		drawTrolls();
	}
	
	void update(char input) {
		clearMazeObjects();
		
	// update player position
		player.update(this, input);
		drawPlayer();
		
	// update troll positions
		for(Troll troll : trolls) {
			troll.update(this, player.getY(), player.getX());
		}
		drawTrolls();
	}
	
	private void clearMazeObjects() {
		map[player.getY()][player.getX()] = EMPTY_TILE;
		
		for(Troll t : trolls) {
			map[t.getY()][t.getX()] = EMPTY_TILE;
		}
	}
	
	private void drawPlayer() {
		// player moves block
		if(map[player.getY()][player.getX()] == BLOCK_TILE) {			
			// check if troll gets crushed
			for(Troll t : trolls) {
				if(player.getY() + player.getDirection().y() == t.getY() &&
						player.getX() + player.getDirection().x() == t.getX()) {
					
					System.out.println("Splat...you crushed a troll.  Gross!!");
					t.setDead(true);
				}
			}
			trolls.removeIf(t -> t.isDead());
			
			// move block to the next space
			map[player.getY() + player.getDirection().y()][player.getX() + player.getDirection().x()] = BLOCK_TILE;
		}
		
		// player escapes
		if(map[player.getY()][player.getX()] == ESCAPE_TILE) player.setEscaped(true);
		
		map[player.getY()][player.getX()] = player.getChar();
	}
	
	private void drawTrolls() {
		for(Troll t : trolls) {			
			// check if troll eats player
			if(t.getY() == player.getY() && t.getX() == player.getX()) {
				t.eat();
				player.setDead(true);
			}
			
			// troll moves block
			if(map[t.getY()][t.getX()] == BLOCK_TILE) {				
				// check if player is crushed
				if(t.getY() + t.getDirection().y() == player.getY() &&
						t.getX() + t.getDirection().x() == player.getX()) {
					System.out.println("You were crushed by a block.");
					player.setDead(true);
				}
				
				map[t.getY() + t.getDirection().y()][t.getX() + t.getDirection().x()] = BLOCK_TILE;
			}
			map[t.getY()][t.getX()] = t.getChar();
		}
	}
	
	private void setDimensions() {		
		try {
			x_max = Files.lines(path).max(Comparator.comparingInt(String::length)).get().length();
			y_max = (int) Files.lines(path).count();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private int y_counter = 0;
	private char[][] getMap() {
		char[][] map = new char[y_max][x_max];	// maze
		
		try{
			
			Files.lines(path).forEach(s -> {
					map[y_counter] = s.toCharArray();
					
					for(char c : map[y_counter]) {
						if(charMap.containsKey(c)) {
							charMap.put(c, charMap.get(c) + 1);
						} else {
							charMap.put(c, 1);
						}
					}
					
					y_counter++;
				});
		} catch (Exception e) {
			System.out.println("Problem loading: " + path.toString());
			e.printStackTrace();
			System.exit(0);
		}
		
		return map;
	}
	
	void print() {
		Stream.of(map)
			.forEach(System.out::println);
	}
	
	public char charAt(int y, int x) {
		return map[y][x];
	}
	
	boolean playerEscaped() { return player.hasEscaped(); }
	boolean playerDead() { return player.isDead(); }
	
	int getMaxX() { return x_max; }
	int getMaxY() { return y_max; }
}
