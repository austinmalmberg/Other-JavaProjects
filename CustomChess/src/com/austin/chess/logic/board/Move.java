package com.austin.chess.logic.board;

import java.awt.Point;

public class Move {
	
	private final String FILES = "abcdefghijklmnopqrstuvwxyz".substring(0, 8);
	
	private final Point from;
	private final Point to;
	
	private final String movingPiece;
	private final String capturedPiece;
	
	private final boolean check;
	private final boolean checkmate;

	public Move(Point from, Point to, String movingPiece, String capturedPiece, boolean check, boolean checkmate) {
		this.from = from;
		this.to = to;
		
		this.movingPiece = movingPiece;
		this.capturedPiece = capturedPiece;
		
		this.check = check;
		this.checkmate = checkmate;
	}
	
	public Point from() { return from; }
	public Point to() { return to; }
	
	public String fromNotation() { return "" + FILES.charAt(from.y) + from.x; }
	public String toNotation() { return "" + FILES.charAt(to.y) + to.x; } 
	
	public String movingPiece() { return movingPiece; }
	public String capturedPiece() { return capturedPiece; }
	
	public boolean pieceCaptured() { return capturedPiece != null; }
	public boolean inCheck() { return check; }
	public boolean checkMate() { return checkmate; }
}
