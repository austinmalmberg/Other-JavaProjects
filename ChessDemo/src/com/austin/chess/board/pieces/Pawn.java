package com.austin.chess.board.pieces;

import com.austin.chess.board.Board;
import com.austin.chess.board.PieceType;
import com.austin.chess.board.Player;
import com.austin.chess.board.movesets.MoveSet;
import com.austin.chess.board.objects.Coordinate;
import com.austin.chess.board.objects.Piece;

public class Pawn extends Piece { 

	public Pawn(Board board, Player player, Coordinate pos) {
		super(board, player, pos);
		
		type = PieceType.PAWN;
		moveset = new MoveSet(PieceType.PAWN, board);
	}
}
