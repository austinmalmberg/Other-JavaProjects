package com.austin.main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class CandyCrush extends Application {

	public static final int TILE_SIZE = 80;
	public static final int WIDTH = 9;
	public static final int HEIGHT = 9;
	public static final int NUM_CANDIES = CandyColor.values().length;
	
	private Pane root;
	
	private List<Tile> tileList = new ArrayList<>();
	private List<Candy> candyList = new ArrayList<>();
	
	private Random rng = new Random();
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Scene scene = new Scene(createContent());
		stage.setTitle("Candy Crush");
		stage.setScene(scene);
		stage.sizeToScene();
		stage.setResizable(false);
		stage.show();
	}
	
	private Parent createContent() {
		root = new Pane();
		
		root.setPrefSize(WIDTH * TILE_SIZE, HEIGHT * TILE_SIZE);
		
		// generate game board
		for(int y = 0; y < HEIGHT; y++) {
			for(int x = 0; x < WIDTH; x++) {
				
				// generate tiles
				Tile tile = new Tile(TileType.NORMAL, x, y);
				
				tileList.add(tile);
				root.getChildren().add(tile);
			}
			
		}
		
		do {
			addCandiesToTopRow();
		} while(candyList.stream().filter(c -> c.isMovable()).count() > 0);
		
		return root;
	}
	
	private void addCandiesToTopRow() {
		// adds candy to all candies in the top row (that does not currently have candies)
		tileList.stream().filter(t -> t.getCol() == 0 && !t.hasCandy()).forEach(tile -> {
			Candy candy = new Candy(CandyType.NORMAL, CandyColor.values()[rng.nextInt(CandyColor.values().length)], tile.getRow(), tile.getCol());
			
			tile.setCandy(candy);
			
			candyList.add(candy);
			root.getChildren().add(candy);
		});
	}
	
	private boolean canMove(Tile t) {
		Tile below = tileList.;
		System.out.println();
		
		if(below.getTileType() == TileType.DISABLED) return false;
		if(below.getTileType() == TileType.NORMAL && !below.hasCandy()) return true;
		
		if(t.getTileType() == TileType.DISABLED) return false;
		
		Tile leftDiagonal;
		Tile rightDiagonal;
	}
}
