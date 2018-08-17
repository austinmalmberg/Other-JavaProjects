package com.austin.chess.logic.board;

import java.util.stream.IntStream;

import com.austin.chess.logic.piece.PieceType;

public class BoardState {

	public BoardState() {
		
	}
	
	public PieceType[][] classical() {
		PieceType[] row0 = {PieceType.ROOK, PieceType.KNIGHT, PieceType.BISHOP, PieceType.QUEEN, PieceType.KING, PieceType.BISHOP, PieceType.KNIGHT, PieceType.ROOK};
		
		return new PieceType[][] {row0, IntStream.range(0, row0.length).mapToObj(i -> PieceType.PAWN).toArray(PieceType[]::new)};
	}
}
