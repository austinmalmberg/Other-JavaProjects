package minesweeper.board;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

import minesweeper.board.gameobjects.GameObject;
import minesweeper.board.gameobjects.Tile;
import minesweeper.main.GamePanel;

public class Board extends GameObject {
	
	private final int BOMB = -1;
	private final int TILE_PADDING = 2;
	
	private int num_bombs;
	
	// -1 is bomb
	// 0 is no bombs surrounding tile
	// 1+ is how many bombs are adjacent to tile
	private int[][] tile_map;
	private ArrayList<Tile> tiles;
	
	// array dimensions
	private int dim_x;
	private int dim_y;
	
	Random rng;
	
	public Board() {
		
		// dimensions of board relative to tile size
		width = GamePanel.TILES_X * (Tile.WIDTH + TILE_PADDING);
		height = GamePanel.TILES_Y * (Tile.HEIGHT + TILE_PADDING);
		
		x = (GamePanel.WIDTH / 2) - (width / 2);  // center board horizontally
		y = GamePanel.HEIGHT - (height + TILE_PADDING);
		
		num_bombs = (GamePanel.TILES_X * GamePanel.TILES_Y * GamePanel.BOMB_DENSITY) / 100;
		
		tile_map = new int[GamePanel.TILES_X][GamePanel.TILES_Y];
		
		tiles = new ArrayList<>();
		
		// tile_map array dimensions
		dim_x = GamePanel.TILES_X - 1;
		dim_y = GamePanel.TILES_Y - 1;
		
		rng = new Random();
		
		init();
		
		printTileMap();
	}
	
	public void init() {
		loadBombs();
		
		addTiles();
	}
	
	public void update() {
		
	}
	
	public void draw(java.awt.Graphics g) {
		// fill board
		g.setColor(Color.DARK_GRAY);
		g.fillRect(x, y, width, height);
		
//		// draw tiles
		for(Tile t : tiles) {
			t.draw(g);
		}
		
		// reveal starting location
	}
	
	public void mousePressed(MouseEvent m) {
		
	}
	
	public void mouseReleased(MouseEvent m) {
		
	}
	
	private void printTileMap() {		
		for(int j = 0; j < dim_y; j++) {
			for (int i = 0; i < dim_x; i++) {
				System.out.printf("%3d", tile_map[i][j]);
			}
			System.out.println();
		}
	}
	
	private void loadBombs() {
		while (num_bombs > 0) {
			int i = rng.nextInt(GamePanel.TILES_X);
			int j = rng.nextInt(GamePanel.TILES_Y);
			
			if(tile_map[i][j] != BOMB) {
				tile_map[i][j] = BOMB;  // assign bomb to tile
				
				// UPDATE TILE MAP by increasing the number of all adjacent tiles by one
				for(int k = -1; k <= 1; k++) {
					for(int l = -1; l <= 1; l++) {
						
						increaseCount: {
							int mod_i = i + k;
							int mod_j = j + l;
							
							// break if tile indexes are out of bounds
							if(mod_i < 0 || mod_i > dim_x) break increaseCount;
							if(mod_j < 0 || mod_j > dim_y) break increaseCount;
							
							// break if the tile index is another bomb
							if(tile_map[mod_i][mod_j] == BOMB) break increaseCount;
							
							tile_map[mod_i][mod_j]++;
						}			
					
					}
				}
				
				num_bombs--;
			}
		}
	}
	
	private void addTiles() {
		for(int i = 0; i <= dim_y; i++) {
			for(int j = 0; j <= dim_x; j++) {
				int tile_x = x + (TILE_PADDING * j) + (j * Tile.WIDTH);
				int tile_y = y + (TILE_PADDING * i) + (i * Tile.HEIGHT);
				
				tiles.add(new Tile(tile_x, tile_y, tile_map[j][i]));
			}
		}
	}
}
