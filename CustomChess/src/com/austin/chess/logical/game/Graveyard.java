package com.austin.chess.logical.game;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.austin.chess.logical.piece.Bishop;
import com.austin.chess.logical.piece.King;
import com.austin.chess.logical.piece.Knight;
import com.austin.chess.logical.piece.Pawn;
import com.austin.chess.logical.piece.Piece;
import com.austin.chess.logical.piece.PieceColor;
import com.austin.chess.logical.piece.PieceType;
import com.austin.chess.logical.piece.Queen;
import com.austin.chess.logical.piece.Rook;

public class Graveyard {

	List<Piece> graveyard;
	
	public Graveyard() {	
		graveyard = new ArrayList<>();
	}
	
	public void add(PieceColor color, PieceType type) {
		switch(type) {
		case BISHOP:
			graveyard.add(new Bishop(color));
			break;
		case KING:
			graveyard.add(new King(color));
			break;
		case KNIGHT:
			graveyard.add(new Knight(color));
			break;
		case PAWN:
			graveyard.add(new Pawn(color));
			break;
		case QUEEN:
			graveyard.add(new Queen(color));
			break;
		case ROOK:
			graveyard.add(new Rook(color));
			break;
		default: case NONE:
			// do nothing
		}
	}
	
	public void add(Piece piece) {
		graveyard.add(piece);
	}
	
	public List<Piece> get(PieceColor color) {
		return graveyard.stream()
				.filter(piece -> piece.color() == color)
				.collect(Collectors.toList());
	}
}
