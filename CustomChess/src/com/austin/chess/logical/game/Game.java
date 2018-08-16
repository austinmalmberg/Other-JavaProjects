package com.austin.chess.logical.game;

import java.awt.Point;
import java.util.Scanner;

import com.austin.chess.logical.board.Board;
import com.austin.chess.logical.piece.Piece;
import com.austin.chess.logical.piece.PieceColor;

public class Game {

	private Scanner sc;
	
	private boolean running;
	
	private Board board;
	private TurnManager turn;
	
	private Graveyard graveyard;
	
	public Game() {
		sc = new Scanner(System.in);
		
		running = true;
		
		board = new Board();
		turn = new TurnManager();
		
		graveyard = new Graveyard();
	}
	
	public void play() {
		board.print();
		
		while(running) {
			
			// WHITE
			turn.advance();
			takeHalfTurn(turn.currentPlayer());
			board.print();
			
			// BLACK
			turn.advance();
			takeHalfTurn(turn.currentPlayer());
			board.print();
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
	
	private void takeHalfTurn(PieceColor color) {
		board.update(color);		// update relative and valid moves
		
		Point from, to;
		do{
			System.out.print(turn.turnNumber() + ". " + color.toString() + "'s turn: ");
			String[] input = sc.nextLine().split("\\s+");
			from = new Point(Integer.parseInt(input[0].charAt(0)+""), Integer.parseInt(input[0].charAt(1)+""));
			to = new Point(Integer.parseInt(input[1].charAt(0)+""), Integer.parseInt(input[1].charAt(1)+""));
		} while(!board.isValidMove(color, from, to));
		
		Piece captured = board.move(from, to);
		if(captured != null) {
			graveyard.add(captured);
		}
	}
}
