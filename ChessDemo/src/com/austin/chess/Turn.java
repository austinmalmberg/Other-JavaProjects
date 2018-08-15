package com.austin.chess;

import java.util.ArrayList;
import java.util.List;

public class Turn {

	private final int turnNumber;
	private List<Move> moves;
	
	public Turn(int turnNumber) {
		this.turnNumber = turnNumber;
		
		moves = new ArrayList<>();
	}
	
	public void addMove(Move move) {
		moves.add(move);
	}
	
	public int getTurnNumber() { return turnNumber; }
	public List<Move> getMoves() { return moves; }
}
