package com.austin.chess.logic.piece;

import java.util.stream.Collectors;

import com.austin.chess.logic.board.Board;

public class King extends Piece {
	
	private final int MAX_TILES = 1;
	
	public King(PieceColor color) {
		super(color, PieceType.KING);
	}

	public King(Board board, int r, int c, PieceColor color) {
		super(board, r, c, color, PieceType.KING);
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
	public String toString() { return color == PieceColor.WHITE ? "K" : "k"; }

}
