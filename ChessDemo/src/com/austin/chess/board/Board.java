package com.austin.chess.board;
import com.austin.chess.board.objects.Coordinate;
import com.austin.chess.board.objects.Piece;
import com.austin.chess.board.objects.Tile;
import com.austin.chess.board.pieces.Pawn;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class Board extends StackPane {
	
	public static final int ROWS = 8;
	public static final int COLUMNS = 8;
	
	public static final int WIDTH = COLUMNS * Tile.TILE_SIZE;
	public static final int HEIGHT = ROWS * Tile.TILE_SIZE;
	
	private Piece[][] board;
	private Tile[][] tiles;
	
	Log log;
	
	public Board() {
		log = new Log(this);
		
		initBoard();
		initPieces();
	}

	private void initBoard() {
		
		tiles = new Tile[COLUMNS][ROWS];
		
		boolean lightTile;
		for(int row = 0; row < ROWS; row++) {
			for(int col = 0; col < COLUMNS; col++) {
				lightTile = (row+col) % 2 == 0;				
				Tile t = new Tile(new Coordinate(col, row), lightTile);
				
				getChildren().add(t);
				
				tiles[col][row] = t;
			}
		}
	}
	
	private void initPieces() {
		
		board = new Piece[COLUMNS][ROWS];
		
		for(int row = 0; row < ROWS; row++) {
			for(int col = 0; col < COLUMNS; col++) {
				Piece piece = null;
				Coordinate coords = new Coordinate(col, row);
				
				if(row < 2)
					piece = new Pawn(this, Player.WHITE, coords);
				
				if(row > 5)
					piece = new Pawn(this, Player.BLACK, coords);
				
				if(piece != null) {
					getChildren().add(piece);
				}
				
				board[col][row] = piece;
			}
		}
	}
	
	public void pieceUpdated(Piece piece, Coordinate src, Coordinate dest) {
		log.update(piece, src, dest);
	}
	
	public boolean movePiece(Piece piece, Coordinate dest) {
		
		if(!dest.inBounds()) return false;
		
		Piece destPiece = board[dest.getX()][dest.getY()];
		
		if(destPiece != null) {
			
			if(piece.getPlayer() == destPiece.getPlayer()) {	// already a piece of the same color at destination
				return false;
			} else {
				getChildren().remove(destPiece);	// capture piece of opposing color
				
				/* place piece onto the side panel */
			}
		}
		
		board[piece.getCoordinates().getX()][piece.getCoordinates().getY()] = null;
		board[dest.getX()][dest.getY()] = piece;
		
		return true;
	}
	
	public void highlightSquares(Coordinate[] coords, boolean highlight) {
		for(Coordinate c : coords) {
			tiles[c.getX()][c.getY()].setHighlight(highlight);
		}
	}
	
	public boolean isEmpty(Coordinate c) {
		return board[c.getX()][c.getY()] == null;
	}
	
	public Piece getPieceAtCoord(Coordinate c) {
		return board[c.getX()][c.getY()];
	}
}
