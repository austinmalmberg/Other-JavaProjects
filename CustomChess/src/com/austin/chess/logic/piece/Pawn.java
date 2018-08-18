package com.austin.chess.logic.piece;

import java.awt.Point;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.austin.chess.logic.board.Board;

public class Pawn extends Piece {

	private int direction_mod;
	
	public Pawn(Board board, Point location, PieceColor color) {
		super(board, location, color, PieceType.PAWN);
		
		direction_mod = color == PieceColor.WHITE ? 1 : -1;
	}
	
	@Override
	protected void updateAttackMoves() {
		// forward one and to either side
		attackMoves = Stream.concat(board.relatedPoints().getDiagonal(location).stream(), board.relatedPoints().getInverseDiagonal(location).stream())
				.filter(point -> point.x == location.x + 1*direction_mod)
				.collect(Collectors.toList());
	}

	@Override
	protected void updatePassiveMoves() {
		int maxMoves = onStartingRow() ? 2 : 1;
		List<Point> file = board.relatedPoints().getFile(location.y);
		passiveMoves = file.subList(location.x + 1 * direction_mod, location.x+1 + maxMoves * direction_mod);
	}
	
	@Override
	public void updateValidMoves() {
		validMoves = board.getPassiveMoves(passiveMoves);
		validMoves.addAll(attackMoves.stream().filter(point -> board.isEnemyAtLocation(color, point)).collect(Collectors.toList()));
	}
	
	private boolean onStartingRow() {
		return (color == PieceColor.WHITE && location.x == 1) ||
				(color == PieceColor.BLACK && location.x == Board.ROWS - 2);
	}
	
	@Override
	public boolean offeringCheck() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public String toString() { return color == PieceColor.WHITE ? "i" : "j"; }
}
