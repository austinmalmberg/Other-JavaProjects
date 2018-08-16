package com.austin.chess;

import java.awt.Point;

public class Move {
	
	private final String FILES = "abcdefghijklmnopqrstuvwxyz".substring(0, 8);
	
	private String board;		// change to Board
	private final Point from;
	private final Point to;
	
	private final String movingPiece;
	private final String capturedPiece;

	public Move(String board, Point from, Point to, String movingPiece, String capturedPiece) {
		this.board = board;
		this.from = from;
		this.to = to;
		
		this.movingPiece = movingPiece;
		this.capturedPiece = capturedPiece;
	}
	
	public Point from() { return from; }
	public Point to() { return to; }
	
	public String fromNotation() { return "" + FILES.charAt(from.y) + from.x; }
	public String toNotation() { return "" + FILES.charAt(to.y) + to.x; }
	
	public boolean pieceCaptured() { return capturedPiece != null; }
	
	public String movingPiece() { return movingPiece; }
	public String capturedPiece() { return capturedPiece; }
}
