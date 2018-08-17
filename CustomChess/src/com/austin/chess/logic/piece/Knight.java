package com.austin.chess.logic.piece;

import java.awt.Point;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.austin.chess.logic.board.Board;

public class Knight extends Piece {
	
	private final List<Point> ABSOLUTE_POSITIONS;
	private final int[] MOVE_INCR = {-2, -1, 1, 2};

	public Knight(PieceColor color) {
		super(color, PieceType.KNIGHT);
		
		ABSOLUTE_POSITIONS = IntStream.of(MOVE_INCR).boxed()
				.flatMap(i -> IntStream.of(MOVE_INCR).mapToObj(j -> new Point(i, j)))
				.filter(point -> (Math.abs(point.x) == 2 || Math.abs(point.y) == 2) && (Math.abs(point.x) != 2 || Math.abs(point.y) != 2))
				.collect(Collectors.toList());
	}
	
	public Knight(Board board, int r, int c, PieceColor color) {
		super(board, r, c, color, PieceType.KNIGHT);
		
		ABSOLUTE_POSITIONS = IntStream.of(MOVE_INCR).boxed()
				.flatMap(i -> IntStream.of(MOVE_INCR).mapToObj(j -> new Point(i, j)))
				.filter(point -> (Math.abs(point.x) == 2 || Math.abs(point.y) == 2) && (Math.abs(point.x) != 2 || Math.abs(point.y) != 2))
				.collect(Collectors.toList());
	}
	
	@Override
	protected void updateAttackMoves() {
		attackMoves = ABSOLUTE_POSITIONS.stream()
				.map(point -> new Point(r + point.x, c + point.y))
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
	public String toString() { return color == PieceColor.WHITE ? "N" : "M"; }

}
