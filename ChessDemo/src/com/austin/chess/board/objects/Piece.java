package com.austin.chess.board.objects;
import com.austin.chess.board.Board;
import com.austin.chess.board.PieceType;
import com.austin.chess.board.Player;
import com.austin.chess.board.movesets.MoveSet;

import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public abstract class Piece extends BoardObject {
	
	private Circle bg;
	private final double radius = Tile.TILE_SIZE / 2 * 0.8;
	
	private double mouseOffsetX;
	private double mouseOffsetY;
	
	protected PieceType type;
	protected MoveSet moveset;
	
	private Player player;
	private Board board;
	
	public Piece(Board board, Player player, Coordinate pos) {
		super(pos);
		
		this.board = board;
		this.player = player;
		
		bg = new Circle(radius, player.getColor());
		bg.setStroke(Color.BLACK);
		
		setLayoutX((Tile.TILE_SIZE - radius*2) / 2);
		setLayoutY((Tile.TILE_SIZE - radius*2) / 2);
		
		bg.setOnMousePressed(e -> mousePressed(e));
		bg.setOnMouseDragged(e -> mouseDragged(e));
		bg.setOnMouseReleased(e -> mouseReleased(e));
		
		getChildren().add(bg);
	}
	
	private void mousePressed(MouseEvent e) {
		
		toFront();
		
		// the distances from the current piece location to the mouse location at the time of the click
		mouseOffsetX = e.getSceneX() - pos.getPosX();
		mouseOffsetY = e.getSceneY() - pos.getPosY();
		
		// get moveset
		moveset.getValidMoves(this);
		
		// highlight moves
	}
	
	private void mouseDragged(MouseEvent e) {		
		setTranslate(e.getSceneX() - mouseOffsetX, e.getSceneY() - mouseOffsetY);
	}
	
	private void mouseReleased(MouseEvent e) {
		Coordinate new_pos = new Coordinate(e.getSceneX(), e.getSceneY());
		
		if(board.movePiece(this, new_pos)) {
			
			// update new position
			pos.setFromPosX(e.getSceneX());
			pos.setFromPosY(e.getSceneY());
		}
		
		// snaps the piece into the center of the tile
		setTranslate(pos.getPosX(), pos.getPosY());
	}
	
	public Player getPlayer() { return player; }
}
