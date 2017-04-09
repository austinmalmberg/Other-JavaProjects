package com.austin.challenge.i237;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class HeightMapOfBoxes {
	public static void main(String[] args) {
		HeightMap hm = new HeightMap("/com/austin/challenge/i237/heightmap1.txt");
		
		Direction direction = Direction.RIGHT;
		Level level = Level.ZERO;
		for(int y = 0; y < hm.getHeight(); y++) {
			for(int x = 0; x < hm.getWidth(); x++) {
				fill(hm, direction, level, x, y);
			}
		}
		
		hm.print();
	}
	
	public static void fill(HeightMap hm, Direction d, Level l, int x, int y) {
		char c = hm.get(x, y);
		
		if(c == ' ') hm.set(l.sign(), x, y);
		if(c == '|' || c == '-' || c == '+') fill(hm, d.next(), l, x, y);  // StackOverflow
	}
}

class HeightMap {
	private int width;
	private int height;
	private char[][] heightMap;
	
	public HeightMap(String filename) {		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(getClass().getResource(filename).toURI()))));
			
			width = Integer.parseInt(br.readLine().trim());
			height = Integer.parseInt(br.readLine().trim());
			
			heightMap = new char[width][height];
			
			String line;
			int y_index = 0;
			while((line = br.readLine()) != null) {
				for(int i = 0; i < line.length(); i++) {
					heightMap[i][y_index] = line.charAt(i);
				}
				y_index++;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public int getWidth() { return width; }
	public int getHeight() { return height; }
	public char[][] getMap() {
		return heightMap;
	}
	
	public char get(int x, int y) {
		return heightMap[x][y];
	}
	public void set(char value, int x, int y) {
		heightMap[x][y] = value;
	}
	
	public void print() {
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				System.out.print(heightMap[x][y]);
			}
			System.out.println();
		}
	}
}
enum Level {
	ZERO('#'),
	ONE('='),
	TWO('-'),
	THREE('.'),
	FOUR(' ') {
		@Override
		Level next() {
			return values()[0];
		}
	};
	
	private final char sign;
	Level(char sign) {
		this.sign = sign;
	}
	
	Level next() {
		return values()[ordinal() + 1];
	}
	
	char sign() { return sign; }
}

enum Direction {
	RIGHT(1, 0),
	DOWN(1, 0),
	LEFT(-1, 0),
	UP(0, -1) {
		@Override
		public Direction next() {
			return values()[0];
		}
	};
	
	private final int x;
	private final int y;
	Direction(int x, int y) {
		this.x = x;
		this.y = y;
	}

	Direction next() {
		return values()[ordinal() + 1];
	}
	
	int x() { return x; }
	int y() { return y; }
}
