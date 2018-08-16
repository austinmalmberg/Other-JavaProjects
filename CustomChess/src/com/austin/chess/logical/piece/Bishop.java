package com.austin.chess.logical.piece;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.austin.chess.logical.board.Board;

public class Bishop extends Piece {
	
	public Bishop(PieceColor color) {
		super(color, PieceType.BISHOP);
	}
	
	public Bishop(Board board, int r, int c, PieceColor color) {
		super(board, r, c, color, PieceType.BISHOP);
	}
	
	@Override
	protected void updateAttackMoves() {
		attackMoves = new ArrayList<>(board.relatedPoints().getDiagonal(r, c));
		attackMoves.addAll(board.relatedPoints().getInverseDiagonal(r, c));
	}

	@Override
	protected void updatePassiveMoves() {}
	
	@Override
	public void updateValidMoves() {

		List<Point> direct = board.relatedPoints().getDiagonal(r, c);
		List<Point> inverse = board.relatedPoints().getInverseDiagonal(r, c);
		
		validMoves = new ArrayList<>(board.getAttackMoves(color, direct.stream().filter(point -> point.y > c).collect(Collectors.toList())));	// up and right of bishop
		
		
		validMoves.addAll(board.getAttackMoves(color,
				reverse(direct).stream()
					.filter(point -> point.y < c)
					.collect(Collectors.toList())));	// down and left of bishop
		
		validMoves.addAll(board.getAttackMoves(color, inverse.stream().filter(point -> point.y > c).collect(Collectors.toList())));	// up and left of bishop
		
		validMoves.addAll(board.getAttackMoves(color,
				reverse(inverse).stream()
					.filter(point -> point.y < c)
					.collect(Collectors.toList())));	// down and right of bishop
		
	}

	@Override
	public String toString() { return color == PieceColor.WHITE ? "B" : "E"; }
}
