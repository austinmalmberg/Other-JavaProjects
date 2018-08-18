package com.austin.chess.logic.piece;

public enum PieceColor {
	WHITE('w'),
	BLACK('b');
	
	private char designation;
	
	private PieceColor(char designation) {
		this.designation = designation;
	}
	
	public static PieceColor get(char ch) {
		for(PieceColor color : PieceColor.values()) {
			if(color.designation == ch) return color;
		}
		
		return null;
	}
}
