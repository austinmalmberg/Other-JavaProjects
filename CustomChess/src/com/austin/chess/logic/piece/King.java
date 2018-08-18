package com.austin.chess.logic.piece;

import java.awt.Point;
import java.util.stream.Collectors;

import com.austin.chess.logic.board.Board;

public class King extends Piece {
	
	private final int MAX_TILES = 1;
	
	public King(Board board, Point location, PieceColor color) {
		super(board, location, color, PieceType.KING);
	}
	
	@Override
	protected void updateAttackMoves() {		
		attackMoves = board.relatedPoints().getSurroundingPoints(MAX_TILES);
	}

	@Override
	protected void updatePassiveMoves() {}

	@Override
	public void updateValidMoves() {
		validMoves = attackMoves.stream().filter(point -> !board.tileAttackedByEnemy(color, point)).collect(Collectors.toList());
	}

	@Override
	public boolean offeringCheck() {
		return false;
	}
	
	@Override
	public String toString() { return color == PieceColor.WHITE ? "K" : "k"; }
}
