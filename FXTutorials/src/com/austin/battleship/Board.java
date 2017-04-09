package com.austin.battleship;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Board extends Pane {
	public final int TILE_PER_ROW = 10;
	public final int TILE_SIZE = BattleshipDemo.WIDTH / TILE_PER_ROW;
	
	private Rectangle bg;
	
	private final int num_ships = 5;
	private SimpleIntegerProperty ships_remaining;
	
	public Board() {
		setPrefSize(BattleshipDemo.WIDTH, BattleshipDemo.WIDTH);
		
		bg = new Rectangle(BattleshipDemo.WIDTH, BattleshipDemo.WIDTH);
		bg.setFill(Color.LIGHTGRAY);
		
		ships_remaining = new SimpleIntegerProperty(num_ships);
		
		getChildren().add(bg);
		
		// add tiles
		for (int y = 0; y < TILE_PER_ROW; y++) {
			for (int x = 0; x < TILE_PER_ROW; x++) {
				Tile t = new Tile(x + ", " +y);
				
				t.setTranslateX(x * TILE_SIZE);
				t.setTranslateY(y * TILE_SIZE);
				
				getChildren().add(t);
			}
		}
	}
	
	public SimpleIntegerProperty shipsRemaining() {
		return ships_remaining;
	}
	
	private enum Status {
		PLACE_SHIPS, LAUNCH_MISSILE, DISABLED
	}
	
	private class Tile extends StackPane {
		
		private Rectangle bg;
		private Text t;
		
		private Status status;
		
		public Tile(String s) {
			setPrefSize(TILE_SIZE, TILE_SIZE);
			
			bg = new Rectangle(TILE_SIZE, TILE_SIZE);
			bg.setFill(Color.DARKGRAY);
			bg.setStroke(Color.WHITE);
			
			t = new Text(s);
			
			setOnMouseClicked(event -> {
				if(status == Status.DISABLED) return;
				
				bg.setFill(Color.RED);
				t.setVisible(false);
			});
			
			getChildren().addAll(bg, t);
		}
	}
}
