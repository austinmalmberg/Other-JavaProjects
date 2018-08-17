package com.austin.chess.logic.piece;

import java.awt.Point;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.austin.chess.logic.board.Board;

public class Pawn extends Piece {

	private int direction_mod;
	
	public Pawn(PieceColor color) {
		super(color, PieceType.PAWN);
	}
	
	public Pawn(Board board, int r, int c, PieceColor color) {
		super(board, r, c, color, PieceType.PAWN);
		
		direction_mod = color == PieceColor.WHITE ? 1 : -1;
	}
	
	@Override
	protected void updateAttackMoves() {
		// forward one and to either side
		attackMoves = Stream.concat(board.relatedPoints().getDiagonal(r, c).stream(), board.relatedPoints().getInverseDiagonal(r, c).stream())
				.filter(point -> point.x == r + 1*direction_mod)
				.collect(Collectors.toList());
	}

	@Override
	protected void updatePassiveMoves() {
		int maxMoves = onStartingRow() ? 2 : 1;
		List<Point> file = board.relatedPoints().getFile(c);
		passiveMoves = file.subList(r + 1 * direction_mod, r+1 + maxMoves * direction_mod);
	}
	
	@Override
	public void updateValidMoves() {
		validMoves = board.getPassiveMoves(passiveMoves);
		validMoves.addAll(attackMoves.stream().filter(point -> board.isEnemyAtLocation(color, point)).collect(Collectors.toList()));
	}
	
	private boolean onStartingRow() {
		return (color == PieceColor.WHITE && r == 1) ||
				(color == PieceColor.BLACK && r == board.ROWS - 2);
	}
	
	@Override
	public String toString() { return color == PieceColor.WHITE ? "i" : "j"; }
}
