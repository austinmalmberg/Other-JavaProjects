package com.austin.chess.ui.board;

import java.awt.Point;
import java.util.Map;

import com.austin.chess.logic.board.Board;
import com.austin.chess.logic.piece.PieceType;

import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;

public class ChessBoard extends FlowPane {
	
	private Board board;
	private Map<PieceType, ImageView> pieceImages;
	
	public static final Color[] TILE_COLORS = {Color.BLANCHEDALMOND, Color.GRAY}; 

	public ChessBoard(Board board) {
		super();
		
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
