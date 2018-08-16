package com.austin.chess.logical.turn;

import java.util.ArrayList;
import java.util.List;

import com.austin.chess.logical.board.Move;

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
