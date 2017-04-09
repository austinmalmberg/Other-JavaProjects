package com.austin.minesweeper;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Minesweeper extends Application {
	
	//Add transition
	
	private static final int TILE_SIZE = 40;
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	
	private static final int X_TILES = WIDTH / TILE_SIZE;
	private static final int Y_TILES = HEIGHT / TILE_SIZE;

	private Tile[][] grid = new Tile[X_TILES][Y_TILES];
	private Scene scene; 
	
	private boolean running;
	
	private Parent createContent() {
		Pane root = new Pane();
		root.setPrefSize(WIDTH, HEIGHT);  // set dimensions
		
		running = true;
		
		// generate tiles
		for(int y = 0; y < Y_TILES; y++) {
			for(int x = 0; x < X_TILES; x++) {
				Tile tile = new Tile(x, y, Math.random() < 0.02);
				
				grid[x][y] = tile;
				root.getChildren().add(tile);
			}
		}
		
		return root;
	}
	
	private class Tile extends StackPane {
		private int x, y;
		private boolean has_bomb;
		private boolean is_open;
		
		private Rectangle background = new Rectangle(TILE_SIZE - 2, TILE_SIZE - 2);
		private Text text = new Text();
		
		private Font normal_font = Font.font("Ariel", FontWeight.NORMAL, 18);
		private Font alert_font = Font.font("Ariel", FontWeight.EXTRA_BOLD, 18);
		
		public Tile(int x, int y, boolean has_bomb) {
			this.x = x;
			this.y = y;
			this.has_bomb = has_bomb;
			
			is_open = false;
			
			text.setVisible(false);
			
			background.setFill(Color.DARKGRAY);
			background.setStroke(Color.LIGHTGRAY);
			
			getChildren().addAll(background, text);
			
			setTranslateX(x * Minesweeper.TILE_SIZE);
			setTranslateY(y * Minesweeper.TILE_SIZE);
			
			setOnMouseClicked(new EventHandler<MouseEvent>() {
				public void handle(MouseEvent e) {
					if(e.getButton() == MouseButton.PRIMARY)  // left click
						open();
					if(e.getButton() == MouseButton.SECONDARY)  // right click
						declareBomb();
				}
			});
		}
		
		public void open() {
			if(is_open) return;
			
			is_open = true;
			
			if(has_bomb) {
				System.out.println("Game Over!");
				
				running = false;

				text.setFill(Color.RED);
				text.setFont(alert_font);
				text.setText("X");
				text.setVisible(true);
				background.setFill(null);
				
//				if(!running) {
//					try {
//						Thread.sleep(1000);
						scene.setRoot(createContent());  // resets game
//					} catch (InterruptedException ie) {
//						ie.printStackTrace();
//					}
//				}
				
				return;
			}
			
			text.setFill(Color.BLACK);
			text.setFont(normal_font);
			
			// count the number of bombs in adjacent tiles
			long count = getNeighbors(this).stream().filter(t -> t.has_bomb).count();
			
			if(count == 0) text.setText("");
			if(count > 0) text.setText(String.valueOf(count));
			
			text.setVisible(true);
			background.setFill(null);
			
			if(text.getText().isEmpty()) {
				getNeighbors(this).forEach(Tile::open);
			}
		}
		
		public void declareBomb() {
			if(is_open) return;
			
			if(text.getText() == "!") {
				text.setFill(Color.BLACK);
				text.setVisible(false);
				text.setText("");
			} else {
				text.setFill(Color.RED);
				text.setFont(alert_font);
				text.setText("!");
				text.setVisible(true);
			}
		}
		
		private List<Tile> getNeighbors(Tile tile) {
			List<Tile> neighbors = new ArrayList<>();
			
			// points around specified tile (relative to it's position)
			int[] points = new int[] {
					-1, -1,
					-1, 0,
					-1, 1,
					0, -1,
					0, 1,
					1, -1,
					1, 0,
					1, 1
			};
			
			for(int i = 0; i < points.length; i++) {
				int dx = points[i];
				int dy = points[++i];
				
				int new_x = tile.x + dx;
				int new_y = tile.y + dy;
				
				if(new_x >= 0 && new_x < X_TILES
						&& new_y >= 0 && new_y < Y_TILES) {
					neighbors.add(grid[new_x][new_y]);
				}
			}
			
			return neighbors;
		}
	}
	
	public void start(Stage stage) throws Exception {
		scene = new Scene(createContent());
		
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {		
		launch(args);
	}
}


