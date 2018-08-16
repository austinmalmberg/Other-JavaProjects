package com.austin.chess.logical.piece;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.austin.chess.logical.board.Board;

public abstract class Piece implements Moveable {

	protected Board board;
	protected int r, c;
	
	protected final PieceColor color;
	protected final PieceType type;
	
	protected List<Point> attackMoves;		// 
	protected List<Point> passiveMoves;		// A list of Non-attacking moves.  i.e. vertical pawn moves (cannot capture)
	protected List<Point> moveset;		// attack + passive moves
	
	protected List<Point> validMoves;		// only possible moves
	
	public Piece(PieceColor color, PieceType type) {
		this.color = color;
		this.type = type;
	}
	
	public Piece(Board board, int r, int c, PieceColor color, PieceType type) {
		this.board = board;
		this.r = r;
		this.c = c;
		
		this.color = color;
		this.type = type;
		
		attackMoves = new ArrayList<>();
		passiveMoves = new ArrayList<>();
		moveset = new ArrayList<>();
		
		validMoves = new ArrayList<>();
	}
	
	public void setLocation(Point p) {
		this.r = p.x;
		this.c = p.y;
	}
	public void setLocation(int r, int c) {
		this.r = r;
		this.c = c;
	}
	
	public PieceColor color() { return color; }
	public PieceType type() { return type; }
	public int r() { return r; }
	public int c() { return c; }
	
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
	
	public List<Point> reverse(List<Point> points) {
		List<Point> rev = new ArrayList<>(points);
		Collections.reverse(rev);
		
		return rev;
	}
	
	public abstract String toString();
}
