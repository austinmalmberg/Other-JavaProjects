package com.austin.chess.logic.board;

import java.awt.Point;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class RelatedPoints {
	
	private Board board;
	
	private final List<List<Point>> ranks;		// rows
	private final List<List<Point>> files;		// files
	
	private final Map<Integer, List<Point>> diagonals;			// like /
	private final Map<Integer, List<Point>> inverseDiagonals;		// like \

	public RelatedPoints(Board board) {		
		this.board = board;
		
		// rows
		ranks = IntStream.range(0, Board.ROWS).boxed()
				.map(r -> IntStream.range(0, Board.COLUMNS)
						.mapToObj(c -> new Point(r, c))
						.filter(board::inBounds)
						.collect(Collectors.toList()))
				.collect(Collectors.toList());
		
		// columns
		files = IntStream.range(0, Board.COLUMNS).boxed()
				.map(c -> IntStream.range(0, Board.ROWS)
						.mapToObj(r -> new Point(r, c))
						.filter(board::inBounds)
						.collect(Collectors.toList()))
				.collect(Collectors.toList());
		
		diagonals = new HashMap<>();
		inverseDiagonals = new HashMap<>();
		
		for(int key = 0; key < Board.ROWS; key++) {
			diagonals.put(key, diagonalAsStream(new Point(key, 0)).collect(Collectors.toList()));
			inverseDiagonals.put(key, inverseDiagonalAsStream(new Point(key, Board.COLUMNS-1)).collect(Collectors.toList()));
			
			if(key > 0) {
				diagonals.put(-key, diagonalAsStream(new Point(Board.ROWS - key, Board.COLUMNS-1)).collect(Collectors.toList()));
				inverseDiagonals.put(-key, inverseDiagonalAsStream(new Point(Board.ROWS-1 - key, 0)).collect(Collectors.toList()));
			}
		}
	}
	
	public Stream<Point> allPointsOnBoardAsStream() {
		return IntStream.range(0, Board.ROWS).boxed()
				.flatMap(r -> IntStream.range(0, Board.COLUMNS).mapToObj(c -> new Point(r, c)).filter(board::inBounds));
	}
	
	public List<Point> getSurroundingPoints(int max) {
		int min = -max;
		
		return IntStream.range(min, max+1).boxed()
		.flatMap(r -> IntStream.range(min, max+1)
				.mapToObj(c -> new Point(r, c)))
				.filter(point -> board.inBounds(point) && (point.x != 0 || point.y != 0))
		.collect(Collectors.toList()); 
	}
	
	public List<Point> getRank(int r) {
		return ranks.get(r);
	}
	
	public List<Point> getFile(int c) {
		return files.get(c);
	}
	
	public List<Point> getDiagonal(Point location) {
		return diagonals.get(location.x - location.y);
	}
	
	public List<Point> getInverseDiagonal(Point location) {
		return inverseDiagonals.get(location.x-Board.ROWS - location.y);
	}
	
	
	
	// PRIVATE METHODS
	
	private Stream<Point> diagonalAsStream() {
		return IntStream.range(0, Math.max(Board.ROWS, Board.COLUMNS))
				.mapToObj(i -> new Point(i, i));
	}
	
	private Stream<Point> diagonalAsStream(Point location) {
		int r = location.x;
		int c = location.y;
		return diagonalAsStream().map(point -> new Point(r + point.x - c, point.y)).filter(board::inBounds);
	}
	
	private Stream<Point> inverseDiagonalAsStream(Point location) {
		int r = location.x;
		int c = location.y;
		return diagonalAsStream().map(point -> new Point(point.x, c - point.y + r)).filter(board::inBounds);
	}
}
