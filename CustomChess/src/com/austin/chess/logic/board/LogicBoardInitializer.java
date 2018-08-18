package com.austin.chess.logic.board;

import java.awt.Point;

import com.austin.chess.logic.piece.Bishop;
import com.austin.chess.logic.piece.King;
import com.austin.chess.logic.piece.Knight;
import com.austin.chess.logic.piece.Pawn;
import com.austin.chess.logic.piece.Piece;
import com.austin.chess.logic.piece.PieceColor;
import com.austin.chess.logic.piece.PieceType;
import com.austin.chess.logic.piece.Queen;
import com.austin.chess.logic.piece.Rook;

public class LogicBoardInitializer {
	
	public static final int CLASSICAL = 0;
	
	private final String[] classic = {
		"Rw Nw Bw Qw Kw Bw Nw Rw",
		"Pw Pw Pw Pw Pw Pw Pw Pw",
		".. .. .. .. .. .. .. ..",
		".. .. .. .. .. .. .. ..",
		".. .. .. .. .. .. .. ..",
		".. .. .. .. .. .. .. ..",
		"Pb Pb Pb Pb Pb Pb Pb Pb",
		"Rb Nb Bb Qb Kb Bb Nb Rb"
	};
	
	private Board board;
	private Piece[][] pieces;
	
	public LogicBoardInitializer(Board board, int state) {
		this.board = board;
		
		if(state == CLASSICAL) load(classic);
	}
	
	public void load(String[] boardState) {
		pieces = new Piece[Board.ROWS][Board.COLUMNS];
		
		for(int r = 0; r < boardState.length; r++) {
			String[] row = boardState[r].split("\\s+");
			for(int c = 0; c < row.length; c++) {
				Point point = new Point(r, c);
				pieces[r][c] = getPiece(row[c], point);
			}
		}
	}
	
	private Piece getPiece(String pieceInfo, Point location) {
		
		PieceType type = PieceType.get(pieceInfo.charAt(0));
		PieceColor color = PieceColor.get(pieceInfo.charAt(1));
		
		if(type == PieceType.ROOK)
			return new Rook(board, location, color);
		if(type == PieceType.KNIGHT)
			return new Knight(board, location, color);
		if(type == PieceType.BISHOP)
			return new Bishop(board, location, color);
		if(type == PieceType.QUEEN)
			return new Queen(board, location, color);
		if(type == PieceType.KING)
			return new King(board, location, color);
		if(type == PieceType.PAWN)
			return new Pawn(board, location, color);
		
		return null;
	}
	
	public Piece[][] getBoard() { return pieces; }
}
