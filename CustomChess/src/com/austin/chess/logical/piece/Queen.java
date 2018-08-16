package com.austin.chess.logical.piece;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.austin.chess.logical.board.Board;

public class Queen extends Piece {

	public Queen(PieceColor color) {
		super(color, PieceType.QUEEN);
	}
	
	public Queen(Board board, int r, int c, PieceColor color) {
		super(board, r, c, color, PieceType.QUEEN);
	}
	
	@Override
	protected void updateAttackMoves() {
		// straights
		attackMoves = new ArrayList<>(board.relatedPoints().getRank(r));
		attackMoves.addAll(board.relatedPoints().getFile(c));
		
		// diagonals
		attackMoves.addAll(board.relatedPoints().getDiagonal(r, c));
		attackMoves.addAll(board.relatedPoints().getInverseDiagonal(r, c));
	}

	@Override
	protected void updatePassiveMoves() {}

	@Override
	public void updateValidMoves() {
		
		List<Point> rank = board.relatedPoints().getRank(r);
		List<Point> file = board.relatedPoints().getFile(c);
		
		validMoves = new ArrayList<>(board.getAttackMoves(color, rank.stream().filter(point -> point.x > c).collect(Collectors.toList())));	// horizontal moves right of queen
		
		validMoves.addAll(board.getAttackMoves(color,
				reverse(rank).stream()
					.filter(point -> point.x < c)
					.collect(Collectors.toList())));	// horizontal moves left of queen
		
		validMoves.addAll(board.getAttackMoves(color, file.stream().filter(point -> point.x > r).collect(Collectors.toList())));	// vertical moves above queen
		
		validMoves.addAll(board.getAttackMoves(color,
				reverse(file).stream()
					.filter(point -> point.x < r)
					.collect(Collectors.toList())));	// vertical moves below queen
		
		
		List<Point> direct = board.relatedPoints().getDiagonal(r, c);
		List<Point> inverse = board.relatedPoints().getInverseDiagonal(r, c);
		
		validMoves.addAll(board.getAttackMoves(color, direct.stream().filter(point -> point.y > c).collect(Collectors.toList())));	// up and right of queen
		
		
		validMoves.addAll(board.getAttackMoves(color,
				reverse(direct).stream()
					.filter(point -> point.y < c)
					.collect(Collectors.toList())));	// down and left of queen
		
		validMoves.addAll(board.getAttackMoves(color, inverse.stream().filter(point -> point.y > c).collect(Collectors.toList())));	// up and left of queen
		
		validMoves.addAll(board.getAttackMoves(color,
				reverse(inverse).stream()
					.filter(point -> point.y < c)
					.collect(Collectors.toList())));	// down and right of queen
		
	}

	@Override
	public String toString() { return color == PieceColor.WHITE ? "Q" : "O"; }
}
