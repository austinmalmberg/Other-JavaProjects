package com.austin.chess.logical.board;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.austin.chess.logical.piece.Bishop;
import com.austin.chess.logical.piece.King;
import com.austin.chess.logical.piece.Knight;
import com.austin.chess.logical.piece.Pawn;
import com.austin.chess.logical.piece.Piece;
import com.austin.chess.logical.piece.PieceColor;
import com.austin.chess.logical.piece.Queen;
import com.austin.chess.logical.piece.Rook;

public class Board {
	
	public static final int ROWS = 8;
	public static final int COLUMNS = 8;
	
	Piece[][] board;
	List<Piece> pieces;
	
	RelatedPoints relatedPoints;

	public Board() {
		board = new Piece[ROWS][COLUMNS];
		
		relatedPoints = new RelatedPoints(this);
		
		IntStream.range(0, COLUMNS).forEach(c -> {			
			board[1][c] = new Pawn(this, 1, c, PieceColor.WHITE);
			board[6][c] = new Pawn(this, 6, c, PieceColor.BLACK);
			
			switch(c) {
			case 0: case 7:
				board[0][c] = new Rook(this, 0, c, PieceColor.WHITE);
				board[7][c] = new Rook(this, 7, c, PieceColor.BLACK);
				break;
			case 1: case 6:
				board[0][c] = new Knight(this, 0, c, PieceColor.WHITE);
				board[7][c] = new Knight(this, 7, c, PieceColor.BLACK);
				break;
			case 2: case 5:
				board[0][c] = new Bishop(this, 0, c, PieceColor.WHITE);
				board[7][c] = new Bishop(this, 7, c, PieceColor.BLACK);
				break;
			case 3:
				board[0][c] = new Queen(this, 0, c, PieceColor.WHITE);
				board[7][c] = new Queen(this, 7, c, PieceColor.BLACK);
				break;
			case 4:
				board[0][c] = new King(this, 0, c, PieceColor.WHITE);
				board[7][c] = new King(this, 7, c, PieceColor.BLACK);
				break;
			default:
				// nothing
				break;
			}
		});
		
		// init pieces list
		pieces = relatedPoints.allPointsOnBoardAsStream().map(point -> board[point.x][point.y]).filter(piece -> piece != null).collect(Collectors.toList());
		
		// update initial moves
		pieces.stream().forEach(Piece::updateMoveset);
	}
	
	// METHODS FOR PIECES
	
	public RelatedPoints relatedPoints() {
		return relatedPoints;
	}
	
	public List<Point> getFile(int c) {	// column
		return relatedPoints.getFile(c);
	}
	
	public List<Point> getRank(int r) {	// row
		return relatedPoints.getRank(r);
	}
	
	public boolean tileOccupied(Point p) {
		return board[p.x][p.y] == null;
	}
	
	public boolean isNullorEnemyAtLocation(PieceColor color, Point p) {
		return tileOccupied(p) || isEnemyAtLocation(color, p);
	}
	
	public boolean isEnemyAtLocation(PieceColor color, Point p) {
		return !tileOccupied(p) &&
				(color == PieceColor.WHITE && board[p.x][p.y].color() == PieceColor.BLACK ||
						color == PieceColor.BLACK && board[p.x][p.y].color() == PieceColor.WHITE);
	}
	
	public boolean inBounds(Point p) {
		if(p.x < 0 || p.x >= ROWS) return false;
		if(p.y < 0 || p.y >= COLUMNS) return false;
		
		return true;
	}
	
	public boolean tileAttackedByEnemy(PieceColor friendlyColor, Point p) {
		return pieces.stream().filter(otherPiece -> 
				otherPiece.color() != friendlyColor &&
				otherPiece.validMoves().contains(p))
			.count() > 0;
	}
	
	/**
	 * 
	 * @param color The color of the friendly piece
	 * @param points A list of points
	 * @return A sublist of points with the last point being either null or an enemy
	 */
	public List<Point> getAttackMoves(PieceColor color, List<Point> points) {
		List<Point> attackMoves = new ArrayList<>();
		for(Point p : points) {
			if(tileOccupied(p)) {
				Piece piece = board[p.x][p.y];
				
				if(piece.color() != color)
					attackMoves.add(p);
				
				break;	
			} else {
				attackMoves.add(p);
			}
		}
		
		return attackMoves;
	}
	
	public List<Point> getPassiveMoves(List<Point> points) {
		List<Point> passiveMoves = new ArrayList<>();
		for(Point p : points) {
			if(tileOccupied(p))				
				break;	
			
			passiveMoves.add(p);
		}
		
		return passiveMoves;
	}
	
	// METHODS FOR GAME
	
	public Piece move(Point from, Point to) {
		Piece movingPiece = board[from.x][from.y];
		Piece vacatingPiece = board[to.x][to.y];
		
		if(vacatingPiece != null) {
			pieces.remove(vacatingPiece);
		}
		
		board[from.x][from.y] = null;
		board[to.x][to.y] = movingPiece;
		
		movingPiece.setLocation(to.x, to.y);
		
		movingPiece.updateMoveset();
		movingPiece.updateValidMoves();
		
		return vacatingPiece;
	}
	
	public int countFriendlyPiecesOfSameType(Piece piece) {
		return (int) pieces.stream().filter(p -> piece.color() == p.color() && piece.type() == p.type()).count();
	}
	
//	public Piece move_returnCaptured(PieceColor color, Point from, Point to) {
//		Piece capturedPiece = board[to.x][to.y];
//		if(isValidMove(color, from, to)) {
//			move(from, to);
//			
//			if(capturedPiece == null)
//				return null;
//			
//			return capturedPiece;
//		}
//		
//		// the piece did not move
//		return null;
//	}
	
//	public boolean isValidMove(PieceColor color, Point from, Point to) {
//		boolean valid = tileOccupied(from) && sameColor(color, from) && board[from.x][from.y].attackMoves().contains(to);
//		
//		if(!tileOccupied(from))
//			System.out.println("There isn't a piece there.");
//		if(!sameColor(color, from))
//			System.out.println("You can only move " + color.toString() + " pieces.");
//		
//		return valid;
//	}
	
	public void update(PieceColor color) {
		pieces.stream()
				.filter(piece -> piece.color() == color)
				.forEach(Piece::updateValidMoves);
	}
	
	// PRIVATE
	
	private boolean sameColor(PieceColor color, Point p) {
		return board[p.x][p.y].color() == color; 
	}
	
	// PUBLIC GENERIC
	
	public void print() {
		for(int r = board.length-1; r >= 0; r--) {
			for(int c = 0; c < board[r].length; c++) {
				if(board[r][c] == null)
					System.out.print("_ ");
				else
					System.out.print(board[r][c].toString() + " ");
			}
			System.out.println("   " + (r+1));
		}
		System.out.println("\na b c d e f g h ");
	}
}
