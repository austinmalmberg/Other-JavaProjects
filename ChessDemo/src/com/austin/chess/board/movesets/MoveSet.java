package com.austin.chess.board.movesets;

import com.austin.chess.board.Board;
import com.austin.chess.board.PieceType;
import com.austin.chess.board.objects.Coordinate;
import com.austin.chess.board.objects.Piece;

public class MoveSet {

	private Board board;
	private PieceType p;
	
	public MoveSet(PieceType p, Board board) {
		this.board = board;
	}
	
	public Coordinate[] getValidMoves(Piece p) {
		
		return null;
		
	}
}
