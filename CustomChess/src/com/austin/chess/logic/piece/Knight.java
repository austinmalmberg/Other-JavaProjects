package com.austin.chess.logic.piece;

import java.awt.Point;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.austin.chess.logic.board.Board;

public class Knight extends Piece {
	
	private final List<Point> ABSOLUTE_MOVES;
	private final int[] MOVE_INCR = {-2, -1, 1, 2};
	
	public Knight(Board board, Point location, PieceColor color) {
		super(board, location, color, PieceType.KNIGHT);
		
		ABSOLUTE_MOVES = IntStream.of(MOVE_INCR).boxed()
				.flatMap(i -> IntStream.of(MOVE_INCR).mapToObj(j -> new Point(i, j)))
				.filter(point -> (Math.abs(point.x) == 2 || Math.abs(point.y) == 2) && (Math.abs(point.x) != 2 || Math.abs(point.y) != 2))
				.collect(Collectors.toList());
	}
	
	@Override
	protected void updateAttackMoves() {
		attackMoves = ABSOLUTE_MOVES.stream()
				.map(point -> new Point(location.x + point.x, location.y + point.y))
				.filter(board::inBounds)
				.collect(Collectors.toList());
	}

	@Override
	protected void updatePassiveMoves() {}

	@Override
	public void updateValidMoves() {
		validMoves = attackMoves.stream()
				.filter(point -> board.isNullorEnemyAtLocation(color, point))
				.collect(Collectors.toList());
	}
	
	@Override
	public boolean offeringCheck() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String toString() { return color == PieceColor.WHITE ? "N" : "M"; }

}
