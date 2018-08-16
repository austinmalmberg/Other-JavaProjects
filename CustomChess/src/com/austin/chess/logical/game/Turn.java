package com.austin.chess.logical.game;

import java.awt.Point;

import com.austin.chess.logical.board.Board;
import com.austin.chess.logical.piece.Piece;
import com.austin.chess.logical.piece.PieceColor;
import com.austin.chess.logical.piece.PieceType;

public class Turn {
	
	private Board board;
	private final PieceColor turnColor;
	private final int turn;
	
	private Piece movingPiece;
	private Piece capturedPiece;
	
	private Point from;
	private Point to;
	
	public Turn(Board board, PieceColor turnColor, int turn) {
		this.board = board;
		this.turnColor = turnColor;
		this.turn = turn;
	}
	
	public void document(Piece movingPiece, Point from, Point to, Piece capturedPiece) {
		setMovingPiece(movingPiece);
		
		setFrom(from);
		setTo(to);
		
		setCapturedPiece(capturedPiece);
	}
	
	public void setFrom(Point from) { this.from = from; }
	public void setTo(Point to) { this.to = to; }
	
	public void setMovingPiece(Piece piece) { this.movingPiece = piece; }
	public void setCapturedPiece(Piece piece) { this.capturedPiece = piece; }
	
	private char toChar(int i) {
		return FILES.charAt(i);
	}
	
	public String pointNotation(Point point) {
		return toChar(point.y) + "" + point.x; 
	}
	
	public String notation() {
		if(movingPiece.type() == PieceType.PAWN)
			return pawnNotation();
		
		if(movingPiece.type() == PieceType.BISHOP)
			return bishopNotation();
		
		if(movingPiece.type() == PieceType.KNIGHT)
			return knightNotation();
		
		if(movingPiece.type() == PieceType.ROOK)
			return rookNotation();
		
		if(movingPiece.type() == PieceType.QUEEN)
			return queenNotation();
		
		if(movingPiece.type() == PieceType.KING)
			return kingNotation();
		
		return null; 
	}
	
	private String pawnNotation() {
		if(capturedPiece != null) {
			return toChar(from.y) + "x" + pointNotation(to);
		}
		
		return pointNotation(to);
	}
	
	private String bishopNotation() {
		if(board.countFriendlyPiecesOfSameType(movingPiece) > 1) {
			movingPiece.toString() + 
		}
	}
	
	private String knightNotation() {
		
	}
	
	private String rookNotation() {
		
	}
	
	private String queenNotation() {
		
	}
	
	private String kingNotation() {
		
	}
}
