package com.austin.chess.ui.board;

import java.awt.Point;

import com.austin.chess.logical.board.Board;
import com.austin.chess.ui.GameInterface;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;

public class ChessBoard extends FlowPane {
	
	private GameInterface game;
	
	public static final Color[] TILE_COLORS = {Color.BLANCHEDALMOND, Color.GRAY}; 

	public ChessBoard(GameInterface game) {
		super();
		
		this.game = game;
		
		setPrefSize(Board.COLUMNS * Tile.WIDTH, Board.ROWS * Tile.HEIGHT);
		
		for(int r = 0; r < Board.ROWS; r++) {
			for(int c = 0; c < Board.COLUMNS; c++) {
				Tile t = new Tile(this, new Point(Board.ROWS-1 - r, c), TILE_COLORS[(r+c) % 2]);
				getChildren().add(t);
			}
		}
		
		setOnMouseDragged(this::onMouseDragged);
		setOnMouseClicked(this::onMouseClicked);
	}
	
	public void printTile(Point p) {
		System.out.println(p.x + ", " + p.y);
	}
	
	public void onMouseDragged(MouseEvent e) {
		
	}
	
	public void onMouseClicked(MouseEvent e) {
		
	}
}
