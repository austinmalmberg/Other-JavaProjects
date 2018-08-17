package com.austin.chess.logic.turn;

import java.util.Map;
import java.util.TreeMap;

import com.austin.chess.logic.board.Move;
import com.austin.chess.logic.piece.PieceColor;

public class TurnManager {

	private final PieceColor[] players;
	
	private int turnNumber;
	private int currentPlayerIndex;
	
	private Map<Integer, Turn> turns;
	private Turn currentTurn;
	
	public TurnManager(PieceColor[] players) {
		this.players = players;
		
		turnNumber = 1;
		currentPlayerIndex = 0;
		
		turns = new TreeMap<>();
		currentTurn = new Turn(turnNumber);
	}
	
	public void add(Move move) {
		
		// start a new turn if the turn number does not equal the currentTurn's turn number
		if(turnNumber != currentTurn.getTurnNumber()) {
			turns.put(currentTurn.getTurnNumber(), currentTurn);
			currentTurn = new Turn(turnNumber);
		}
			
		currentTurn.addMove(move);
	}
	
	public void advanceTurn() {
		if(++currentPlayerIndex >= players.length) {
			currentPlayerIndex = 0;
			turnNumber++;
		}
	}
	
	public PieceColor getCurrentPlayer() { return players[currentPlayerIndex]; }
	public int getTurnNumber() { return turnNumber; }
}
