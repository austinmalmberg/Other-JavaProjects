import java.awt.Point;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Board {

	private int rows;
	private int columns;
	
	private Tile[][] board;
	private Point knightLocation;
	
	public Board(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		board = new Tile[rows][columns];
		
		init();
	}
	
	private void init() {
		// initialize board with empty, unvisited tiles
		for(int x = 0; x < board.length; x++) {
			
			for(int y = 0; y < board[x].length; y++) {
				
				board[x][y] = new Tile(this, x, y);
				
			}
		}
		
		// initialize knight point
		knightLocation = new Point();
	}
	
	public void setKnightLocation(int x, int y) {		
		knightLocation.setLocation(x, y);
		
		board[x][y].setVisited(true);
	}
	
	public Point getKnightLocation() { return knightLocation; }
	public Tile getKnightTile() { return board[knightLocation.x][knightLocation.y]; }
	
	public boolean tileExists(int x, int y) {
		if(x < 0 || x >= rows) return false;
		if(y < 0 || y >= columns) return false;
		
		return true;
	}
	
	public int getRows() { return rows; }
	public int getColumns() { return columns; }
	public Tile getTile(int x, int y) { return board[x][y]; }
	
	public List<Tile> getVisitedTiles() {
		return Stream.of(board)
				.flatMap(row -> Arrays.stream(row))
				.filter(tile -> tile.visited())
				.collect(Collectors.toList());
	}
	
	public List<Tile> getUnvisitedTiles() {
		return Stream.of(board)
				.flatMap(row -> Arrays.stream(row))
				.filter(tile -> !tile.visited())
				.collect(Collectors.toList());
	}
}
