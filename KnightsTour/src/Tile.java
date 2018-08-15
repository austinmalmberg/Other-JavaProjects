import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Tile {

	private Board board;
	private int x;
	private int y;
	
	private boolean visited;
	private List<Point> linkedPoints;
	
	public Tile(Board board, int x, int y) {
		this.board = board;
		this.x = x;
		this.y = y;
		
		visited = false;
		linkedPoints = new ArrayList<>();
		
		linkedPoints = Stream.of(Direction.values())
				.map(d -> new Point(x + d.getX(), y + d.getY()))
				.filter(p -> board.tileExists(p.x, p.y))
				.collect(Collectors.toList());
		
//		for(Direction d: Direction.values()) {
//			int dx = x + d.getX();
//			int dy = y + d.getY();
//			
//			if(board.tileExists(dx, dy)) {
//				linkedPoints.add(new Point(dx, dy));
//			}
//		}
	}
	
	public List<Tile> linkedTiles() {
		return linkedPoints.stream()
				.filter(p -> board.tileExists(p.x, p.y))
				.map(p -> board.getTile(p.x, p.y))
				.collect(Collectors.toList());
	}
	
	public List<Tile> linkedUnvisitedTiles() {
		return linkedPoints.stream()
				.map(p -> board.getTile(p.x, p.y))
				.filter(t -> !t.visited)
				.collect(Collectors.toList());
	}
	
	/** 
	 * 
	 * @return a list of linked tiles that have the fewest onward moves.  Otherwise return null.
	 */
	public List<Tile> getPotentialTiles() {
		
		// Warnsdorf's Rule
		try {
			int min = linkedUnvisitedTiles().stream()
					.mapToInt(t -> t.linkedUnvisitedTiles().size())
					.min().getAsInt();
			
			return linkedUnvisitedTiles().stream()
				.filter(t -> t.linkedUnvisitedTiles().size() == min)
				.collect(Collectors.toList());
		} catch(NoSuchElementException e) {
			return null;
		}
	}
	
	public int getX() { return x; }
	public int getY() { return y; }
	public boolean visited() { return visited; }
	
	public void setVisited(boolean v) {
		visited = v;
	}
	
	@Override
	public String toString() {
		return String.format("(x= %d, y= %d) visited=%s", x, y, visited);
	}
}
