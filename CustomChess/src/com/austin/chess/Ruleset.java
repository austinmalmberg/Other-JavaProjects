package com.austin.chess;

public class Ruleset {

	public static final int CLASSICAL = 0;
	
	// pawn rules
	protected boolean enPassant;
	protected boolean pawnsMoveTwoOffStart;	// allow pawns to jump two tiles from their starting position
	
	// king rules
	protected boolean kingMustMoveInCheck;
	protected boolean checkmateWins;
	protected boolean kingCanBeCaptured;
	protected boolean castleAllowed;
	
	public Ruleset(int ruleset) {
		if(ruleset == CLASSICAL) initClassical();
	}
	
	private void initClassical() {
		enPassant = true;
		pawnsMoveTwoOffStart = true;
		
		kingMustMoveInCheck = true;
		checkmateWins = true;
		kingCanBeCaptured = false;
		castleAllowed = true;
	}
}
