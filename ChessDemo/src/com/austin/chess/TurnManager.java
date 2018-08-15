package com.austin.chess;

import java.util.Map;
import java.util.TreeMap;

public class TurnManager {

	private final String[] players = {"white", "black"};
	
	private String board;
	
	private int turnNumber;
	private int playerIndex;
	
	private Map<Integer, Turn> turns;
	private Turn currentTurn;
	
	public TurnManager(String board) {
		this.board = board;
		
		turnNumber = 1;
		playerIndex = 0;
		
		turns = new TreeMap<>();
		currentTurn = new Turn(turnNumber);
	}
	
	public void add(Move move) {
		if(turnNumber != currentTurn.getTurnNumber()) {
			turns.put(currentTurn.getTurnNumber(), currentTurn);
			currentTurn = new Turn(turnNumber);
		}
			
		currentTurn.addMove(move);
	}
	
	public void advanceTurn() {
		if(++playerIndex >= players.length) {
			playerIndex = 0;
			turnNumber++;
		}
	}
	
	public String getCurrentPlayer() { return players[playerIndex]; }
	public int getTurnNumber() { return turnNumber; }
}
