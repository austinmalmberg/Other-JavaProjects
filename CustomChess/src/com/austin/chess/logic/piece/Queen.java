package com.austin.chess.logic.piece;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.austin.chess.logic.board.Board;

public class Queen extends Piece {
	
	public Queen(Board board, Point location, PieceColor color) {
		super(board, location, color, PieceType.QUEEN);
	}
	
	@Override
	protected void updateAttackMoves() {
		// straights
		attackMoves = new ArrayList<>(board.relatedPoints().getRank(location.x));
		attackMoves.addAll(board.relatedPoints().getFile(location.y));
		
		// diagonals
		attackMoves.addAll(board.relatedPoints().getDiagonal(location));
		attackMoves.addAll(board.relatedPoints().getInverseDiagonal(location));
	}

	@Override
	protected void updatePassiveMoves() {}

	@Override
	public void updateValidMoves() {
		
		List<Point> rank = board.relatedPoints().getRank(location.x);
		List<Point> file = board.relatedPoints().getFile(location.y);
		
		validMoves = new ArrayList<>(board.getAttackMoves(color, rank.stream().filter(point -> point.x > location.y).collect(Collectors.toList())));	// horizontal moves right of queen
		
		validMoves.addAll(board.getAttackMoves(color,
				reverse(rank).stream()
					.filter(point -> point.x < location.y)
					.collect(Collectors.toList())));	// horizontal moves left of queen
		
		validMoves.addAll(board.getAttackMoves(color, file.stream().filter(point -> point.x > location.x).collect(Collectors.toList())));	// vertical moves above queen
		
		validMoves.addAll(board.getAttackMoves(color,
				reverse(file).stream()
					.filter(point -> point.x < location.x)
					.collect(Collectors.toList())));	// vertical moves below queen
		
		
		List<Point> direct = board.relatedPoints().getDiagonal(location);
		List<Point> inverse = board.relatedPoints().getInverseDiagonal(location);
		
		validMoves.addAll(board.getAttackMoves(color, direct.stream().filter(point -> point.y > location.y).collect(Collectors.toList())));	// up and right of queen
		
		
		validMoves.addAll(board.getAttackMoves(color,
				reverse(direct).stream()
					.filter(point -> point.y < location.y)
					.collect(Collectors.toList())));	// down and left of queen
		
		validMoves.addAll(board.getAttackMoves(color, inverse.stream().filter(point -> point.y > location.y).collect(Collectors.toList())));	// up and left of queen
		
		validMoves.addAll(board.getAttackMoves(color,
				reverse(inverse).stream()
					.filter(point -> point.y < location.y)
					.collect(Collectors.toList())));	// down and right of queen
		
	}
	
	@Override
	public boolean offeringCheck() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String toString() { return color == PieceColor.WHITE ? "Q" : "O"; }
}
