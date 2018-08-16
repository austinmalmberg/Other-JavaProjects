package com.austin.chess.logical.turn;

import java.util.Map;
import java.util.TreeMap;

import com.austin.chess.logical.board.Board;
import com.austin.chess.logical.board.Move;
import com.austin.chess.logical.piece.PieceColor;

public class TurnManager {

	private final PieceColor[] players = PieceColor.values();
	
	private Board board;
	
	private int turnNumber;
	private int playerIndex;
	
	private Map<Integer, Turn> turns;
	private Turn currentTurn;
	
	public TurnManager(Board board) {
		this.board = board;
		
		turnNumber = 1;
		playerIndex = 0;
		
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
		if(++playerIndex >= players.length) {
			playerIndex = 0;
			turnNumber++;
		}
	}
	
	public PieceColor getCurrentPlayer() { return players[playerIndex]; }
	public int getTurnNumber() { return turnNumber; }
}
