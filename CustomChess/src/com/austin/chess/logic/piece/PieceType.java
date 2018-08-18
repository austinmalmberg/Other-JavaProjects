package com.austin.chess.logic.piece;

public enum PieceType {
	PAWN('P'),
	KNIGHT('N'),
	BISHOP('B'),
	ROOK('R'),
	QUEEN('Q'),
	KING('K');
	
	char designation;
	
	PieceType(char designation) {
		this.designation = designation;
	}
	
	public static PieceType get(char ch) {
		for(PieceType type : PieceType.values()) {
			if(type.designation == ch) return type;
		}
		
		return null;
	}
}
