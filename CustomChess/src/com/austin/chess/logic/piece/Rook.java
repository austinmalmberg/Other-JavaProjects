package com.austin.chess.logic.piece;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.austin.chess.logic.board.Board;

public class Rook extends Piece {
	
	public Rook(Board board, Point location, PieceColor color) {
		super(board, location, color, PieceType.ROOK);
	}
	
	@Override
	protected void updateAttackMoves() {		
		attackMoves = new ArrayList<>(board.relatedPoints().getRank(location.x));
		attackMoves.addAll(board.relatedPoints().getFile(location.y));
	}

	@Override
	protected void updatePassiveMoves() {}
	
	@Override
	public void updateValidMoves() {
		
		List<Point> rank = board.relatedPoints().getRank(location.x);
		List<Point> file = board.relatedPoints().getFile(location.y);
		
		validMoves = new ArrayList<>(board.getAttackMoves(color, rank.stream().filter(point -> point.y > location.y).collect(Collectors.toList())));	// horizontal moves right of rook
		
		validMoves.addAll(board.getAttackMoves(color,
				reverse(rank).stream()
					.filter(point -> point.y < location.y)
					.collect(Collectors.toList())));	// horizontal moves left of rook
		
		validMoves.addAll(board.getAttackMoves(color, file.stream().filter(point -> point.x > location.x).collect(Collectors.toList())));	// vertical moves above rook
		
		validMoves.addAll(board.getAttackMoves(color,
				reverse(file).stream()
					.filter(point -> point.x < location.x)
					.collect(Collectors.toList())));	// vertical moves below rook
	}
	
	@Override
	public boolean offeringCheck() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String toString() { return color == PieceColor.WHITE ? "R" : "H"; }
}
