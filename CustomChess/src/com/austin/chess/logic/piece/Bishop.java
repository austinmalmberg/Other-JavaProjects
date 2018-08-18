package com.austin.chess.logic.piece;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.austin.chess.logic.board.Board;

public class Bishop extends Piece {
	
	public Bishop(Board board, Point location, PieceColor color) {
		super(board, location, color, PieceType.BISHOP);
	}
	
	@Override
	protected void updateAttackMoves() {
		System.out.println(board.relatedPoints().getDiagonal(location));
		
		attackMoves = new ArrayList<>(board.relatedPoints().getDiagonal(location));
		attackMoves.addAll(board.relatedPoints().getInverseDiagonal(location));
	}

	@Override
	protected void updatePassiveMoves() {}
	
	@Override
	public void updateValidMoves() {

		List<Point> direct = board.relatedPoints().getDiagonal(location);
		List<Point> inverse = board.relatedPoints().getInverseDiagonal(location);
		
		validMoves = new ArrayList<>(board.getAttackMoves(color, direct.stream().filter(point -> point.y > location.y).collect(Collectors.toList())));	// up and right of bishop
		
		
		validMoves.addAll(board.getAttackMoves(color,
				reverse(direct).stream()
					.filter(point -> point.y < location.y)
					.collect(Collectors.toList())));	// down and left of bishop
		
		validMoves.addAll(board.getAttackMoves(color, inverse.stream().filter(point -> point.y > location.y).collect(Collectors.toList())));	// up and left of bishop
		
		validMoves.addAll(board.getAttackMoves(color,
				reverse(inverse).stream()
					.filter(point -> point.y < location.y)
					.collect(Collectors.toList())));	// down and right of bishop
		
	}
	
	@Override
	public boolean offeringCheck() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String toString() { return color == PieceColor.WHITE ? "B" : "E"; }
}
