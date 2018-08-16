package com.austin.chess.logical.board;

import java.awt.Point;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class RelatedPoints {
	
	Board board;
	
	private final List<List<Point>> ranks;		// rows
	private final List<List<Point>> files;		// files
	
	private final Map<Integer, List<Point>> diagonals;			// like /
	private final Map<Integer, List<Point>> inverseDiagonals;		// like \

	public RelatedPoints(Board board) {		
		this.board = board;
		
		ranks = IntStream.range(0, board.ROWS).boxed()
				.map(r -> IntStream.range(0, board.COLUMNS)
						.mapToObj(c -> new Point(r, c))
						.filter(board::inBounds)
						.collect(Collectors.toList()))
				.collect(Collectors.toList());
		
		files = IntStream.range(0, board.COLUMNS).boxed()
				.map(c -> IntStream.range(0, board.ROWS)
						.mapToObj(r -> new Point(r, c))
						.filter(board::inBounds)
						.collect(Collectors.toList()))
				.collect(Collectors.toList());
		
		diagonals = new HashMap<>();
		inverseDiagonals = new HashMap<>();
		
		for(int key = 0; key < board.ROWS; key++) {
			diagonals.put(key, diagonalAsStream(key, 0).collect(Collectors.toList()));
			inverseDiagonals.put(key, inverseDiagonalAsStream(key, board.COLUMNS-1).collect(Collectors.toList()));
			
			if(key > 0) {
				diagonals.put(-key, diagonalAsStream(board.ROWS-key, board.COLUMNS-1).collect(Collectors.toList()));
				inverseDiagonals.put(-key, inverseDiagonalAsStream(board.ROWS-1-key, 0).collect(Collectors.toList()));
			}
		}
	}
	
	public Stream<Point> allPointsOnBoardAsStream() {
		return IntStream.range(0, board.ROWS).boxed()
				.flatMap(r -> IntStream.range(0, board.COLUMNS).mapToObj(c -> new Point(r, c)).filter(board::inBounds));
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
	
	public List<Point> getDiagonal(int r, int c) {
		return diagonals.get(r - c);
	}
	
	public List<Point> getInverseDiagonal(int r, int c) {
		return inverseDiagonals.get(r-board.ROWS - c);
	}
	
	
	
	// PRIVATE METHODS
	
	private Stream<Point> diagonalAsStream() {
		return IntStream.range(0, Math.max(board.ROWS, board.COLUMNS))
				.mapToObj(i -> new Point(i, i));
	}
	
	private Stream<Point> diagonalAsStream(int r, int c) {
		return diagonalAsStream().map(point -> new Point(r + point.x - c, point.y)).filter(board::inBounds);
	}
	
	private Stream<Point> inverseDiagonalAsStream(int r, int c) {
		return diagonalAsStream().map(point -> new Point(point.x, c - point.y + r)).filter(board::inBounds);
	}
}
