package com.austin.chess.logic.piece;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.austin.chess.logic.board.Board;

public abstract class Piece implements Moveable {

	protected Board board;
	
	protected Point location;	// update pieces with points instead of r, c
	
	protected final PieceColor color;
	protected final PieceType type;
	
	protected List<Point> attackMoves;		// 
	protected List<Point> passiveMoves;		// A list of Non-attacking moves.  i.e. vertical pawn moves (cannot capture)
	protected List<Point> moveset;		// attack + passive moves
	
	protected List<Point> validMoves;		// only possible moves
	
	public Piece(Board board, Point location, PieceColor color, PieceType type) {
		this.board = board;
		this.location = location;
		
		this.color = color;
		this.type = type;
		
		attackMoves = new ArrayList<>();
		passiveMoves = new ArrayList<>();
		moveset = new ArrayList<>();
		
		validMoves = new ArrayList<>();
	}
	
	public void setLocation(Point location) {
		this.location = location;
	}
	
	public PieceColor color() { return color; }
	public PieceType type() { return type; }
	
	public Point getLocation() { return location; }
	public int r() { return location.x; }
	public int c() { return location.y; }
	
	/**
	 * @return All attacking and passive moves.
	 */
	public List<Point> moveset() { return moveset; }
	public List<Point> validMoves() { return validMoves; }
	
	protected abstract void updateAttackMoves();
	protected abstract void updatePassiveMoves();
	
	/**
	 * Called when a piece moves.  Updates all possible moves.
	 */
	public void updateMoveset() {
		updateAttackMoves();
		updatePassiveMoves();
		
		moveset = new ArrayList<>(attackMoves);
		moveset.addAll(passiveMoves);
	}
	
	/**
	 * Updates every turn.
	 */
	public abstract void updateValidMoves();
	
	public boolean canMove(Point to) {
		return validMoves.contains(to);
	}
	
	public abstract boolean offeringCheck();
	
	public List<Point> reverse(List<Point> points) {
		List<Point> rev = new ArrayList<>(points);
		Collections.reverse(rev);
		
		return rev;
	}
	
	public abstract String toString();
}
