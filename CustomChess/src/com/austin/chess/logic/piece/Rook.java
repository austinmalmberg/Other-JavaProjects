package com.austin.chess.logic.piece;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.austin.chess.logic.board.Board;

public class Rook extends Piece {

	public Rook(PieceColor color) {
		super(color, PieceType.ROOK);
	}
	
	public Rook(Board board, int r, int c, PieceColor color) {
		super(board, r, c, color, PieceType.ROOK);
	}
	
	@Override
	protected void updateAttackMoves() {
		attackMoves = new ArrayList<>(board.relatedPoints().getRank(r));
		attackMoves.addAll(board.relatedPoints().getFile(c));
	}

	@Override
	protected void updatePassiveMoves() {}
	
	@Override
	public void updateValidMoves() {
		
		List<Point> rank = board.relatedPoints().getRank(r);
		List<Point> file = board.relatedPoints().getFile(c);
		
		validMoves = new ArrayList<>(board.getAttackMoves(color, rank.stream().filter(point -> point.y > c).collect(Collectors.toList())));	// horizontal moves right of rook
		
		validMoves.addAll(board.getAttackMoves(color,
				reverse(rank).stream()
					.filter(point -> point.y < c)
					.collect(Collectors.toList())));	// horizontal moves left of rook
		
		validMoves.addAll(board.getAttackMoves(color, file.stream().filter(point -> point.x > r).collect(Collectors.toList())));	// vertical moves above rook
		
		validMoves.addAll(board.getAttackMoves(color,
				reverse(file).stream()
					.filter(point -> point.x < r)
					.collect(Collectors.toList())));	// vertical moves below rook
	}

	@Override
	public String toString() { return color == PieceColor.WHITE ? "R" : "H"; }
}
