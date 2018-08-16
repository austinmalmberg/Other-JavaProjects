package com.austin.chess.logical.game;

import java.util.List;

import com.austin.chess.logical.board.Board;
import com.austin.chess.logical.piece.PieceColor;

public class TurnManager {
	
	private Board board;
	private List<Turn> turns;
	
	private final PieceColor[] colors = PieceColor.values();
	private int turn;		// counts in half turns
	private int fullTurn;
	
	public TurnManager(Board board) {
		this.board = board;
		
		turn = 0;
		fullTurn = 1;
	}
	
	public void advance() {
		turn++;
		
		if(turn >= colors.length) {
			turn = 0;
			fullTurn++;
		}
	}
	
	public Turn currentTurn() {
		return new Turn(board, colors[turn], fullTurn);
	}

	public int turnNumber() { return turn / colors.length + 1; }
}
