package com.austin.tictactoe;

import java.util.ArrayList;
import java.util.List;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class TicTacToe extends Application {
	
	// NOT OPTIMIZED FOR BIGGER TIC-TAC-TOE BOARDS
	
	public final int TILE_SIZE = 200;
	public final int NUM_TILES = 3;
	public final int DIM = TILE_SIZE * NUM_TILES;  // application dimensions (x and y)
	
	private Pane root;
	
	private Tile[][] board;
	
	private boolean x_turn;
	private boolean playable;	
	
	private List<Group> groups;
	
	private enum Orientation {
		HORIZONTAL, VERTICAL, DIAGONAL_LR, DIAGONAL_RL
	}
	
	// initialize variables
	public TicTacToe(String... args) {
		launch(args);
		
		root = new Pane();
		
		board = new Tile[NUM_TILES][NUM_TILES];
		
		x_turn = true;  // x starts
		playable = true;
		
		groups = new ArrayList<>();
	}
	
	// add elements to pane
	private Parent createContent() {
		
		// set dimensions
		root.setPrefSize(DIM, DIM);
		
		// add tiles to board
		for(int i = 0; i < NUM_TILES; i++) {
			for (int j = 0; j < NUM_TILES; j++) {
				Tile tile = new Tile();
				tile.setTranslateX(j * TILE_SIZE);
				tile.setTranslateY(i * TILE_SIZE);
				
				root.getChildren().add(tile);
				
				board[j][i] = tile;
			}
		}
		
		/*
		 * Creates tile groups to determine a winner.
		 */
		for(int y = 0; y < NUM_TILES; y++) {	// horizontals
			groups.add(new Group(Orientation.HORIZONTAL, board[0][y], board[1][y], board[2][y]));
		}
		
		
		for(int x = 0; x < NUM_TILES; x++) {	// verticals
			groups.add(new Group(Orientation.VERTICAL, board[x][0], board[x][1], board[x][2]));
		}
		
		groups.add(new Group(Orientation.DIAGONAL_LR, board[0][0], board[1][1], board[2][2]));	// left-right diagonal
		groups.add(new Group(Orientation.DIAGONAL_RL, board[2][0], board[1][1], board[0][2]));	// right-left diagonal
		
		
		return root;
	}
	
	private class Group {
		private Orientation orientation;
		private Tile[] tiles;
		
		public Group(Orientation orientation, Tile... tiles) {
			this.orientation = orientation;
			this.tiles = tiles;
		}
		
		public boolean winner() {
			if(tiles[0].getValue().isEmpty())
				return false;
			
			return tiles[0].getValue().equals(tiles[1].getValue())
					&& tiles[0].getValue().equals(tiles[2].getValue()); 
		}
	}
	
	private class Tile extends StackPane {
		
		private Rectangle border;
		
		private Text text = new Text();
		
		public Tile() {
			border = new Rectangle(TILE_SIZE, TILE_SIZE);
			border.setFill(null);
			border.setStroke(Color.BLACK);
			
			text.setFont(Font.font(84));
			
			setAlignment(Pos.CENTER);
			
			getChildren().addAll(border, text);
			
			setOnMouseClicked(event -> {
				if(!playable)	// checks for end of game
					return;
				
				if(!text.getText().isEmpty())	// prevents overriding tiles
					return;
				
				if(event.getButton() == MouseButton.PRIMARY && x_turn) {
					drawX();
				}
				if(event.getButton() == MouseButton.SECONDARY && !x_turn) {
					drawO();
				}
				
				x_turn = !x_turn;	// change turns
				
				checkWinner();
			});
		}
		
		public double getCenterX() {
			return getTranslateX() + TILE_SIZE / 2;
		}
		
		public double getCenterY() {
			return getTranslateY() + TILE_SIZE / 2;
		}
		
		public String getValue() {
			return text.getText();
		}
		
		private void drawX() {
			text.setText("X");
		}
		
		private void drawO() {
			text.setText("O");
		}
	}
	
	private void checkWinner() {
		for (Group g : groups) {
			if (g.winner()) {
				playable = false;
				winAnimation(g);
				break;
			}
		}
	}
	
	private void winAnimation(Group group) {		
		Line line = new Line();
		
		final int OFFSET = 60;
		
		// variables to modify the start and end points of the line
		// done so that the line goes *through* the text
		int x_mod = 0;
		int y_mod = 0;
		
		if(group.orientation == Orientation.HORIZONTAL) {
			x_mod = OFFSET;
			y_mod = 0;
		}
		if(group.orientation == Orientation.VERTICAL) {
			x_mod = 0;
			y_mod = OFFSET;
		}
		if(group.orientation == Orientation.DIAGONAL_LR) {
			x_mod = OFFSET;
			y_mod = OFFSET;
		}
		if(group.orientation == Orientation.DIAGONAL_RL) {
			x_mod = -OFFSET;
			y_mod = OFFSET;
		}
		
		line.setStroke(Color.RED);
		line.setStrokeWidth(4);
		
		line.setStartX(group.tiles[0].getCenterX() - x_mod);
		line.setStartY(group.tiles[0].getCenterY() - y_mod);
		
		line.setEndX(group.tiles[0].getCenterX() - x_mod);
		line.setEndY(group.tiles[0].getCenterY() - y_mod);
		
		root.getChildren().add(line);
		
		Timeline timeline = new Timeline();
		timeline.getKeyFrames().addAll(new KeyFrame(Duration.seconds(0.5),
				new KeyValue(line.endXProperty(), group.tiles[2].getCenterX() + x_mod),
				new KeyValue(line.endYProperty(), group.tiles[2].getCenterY() + y_mod)));
		timeline.play();
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.setScene(new Scene(createContent()));
		stage.setResizable(false);
		stage.sizeToScene();
		
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
