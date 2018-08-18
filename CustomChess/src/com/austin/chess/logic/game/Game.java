package com.austin.chess.logic.game;

import com.austin.chess.logic.piece.PieceColor;
import com.austin.chess.logic.turn.TurnManager;

public class Game {

	private boolean running;
	
	private TurnManager turn;
	
	// implement sidebar with captured pieces
	// implement log
	
	public Game() {		
		running = true;
		
		turn = new TurnManager(PieceColor.values());
	}
	
	public void play() {		
		while(running) {
			
			takeTurn(turn.getCurrentPlayer());
			turn.advanceTurn();
			
		}
	}
	
	private boolean running() {
		// win conditions
			// checkmate
		
		// draw conditions
			// 50 move limit
			// insufficient material
		
		return true;
	}
	
	private void takeTurn(PieceColor color) {
		// board.updateValidMoves(color);
		
		// restrict movement from pieces of different color
		
		// while invalid move
			// get move
			
		// add to turn manager
		// update log
		// add captured piece to sidebar aka graveyard
		
		
//		Point from, to;
//		do{
//			System.out.print(turn.getTurnNumber() + ". " + color.toString() + "'s turn: ");
//			String[] input = sc.nextLine().split("\\s+");
//			from = new Point(Integer.parseInt(input[0].charAt(0)+""), Integer.parseInt(input[0].charAt(1)+""));
//			to = new Point(Integer.parseInt(input[1].charAt(0)+""), Integer.parseInt(input[1].charAt(1)+""));
//		} while(!board.isValidMove(color, from, to));
	}
}
