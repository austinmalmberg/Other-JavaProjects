package com.austin.chess.logic.game;

import java.util.Scanner;

import com.austin.chess.logic.board.Board;
import com.austin.chess.logic.piece.PieceColor;
import com.austin.chess.logic.piece.PieceType;
import com.austin.chess.logic.ruleset.Ruleset;
import com.austin.chess.logic.turn.TurnManager;

public class Game {

	private Scanner sc;
	
	private boolean running;
	
	private Board board;
	
	private TurnManager turn;
	
	private Graveyard graveyard;	// sidebar
	
	public Game() {
		sc = new Scanner(System.in);
		
		running = true;
		
		board = new Board(null);
		turn = new TurnManager(PieceColor.values());
		
		graveyard = new Graveyard();
	}
	
	public Game(PieceType[][] intialBoardState, Ruleset rules) {
	}
	
	public void play() {
		board.print();
		
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
		board.updateValidMoves(color);		// update valid moves
		
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
