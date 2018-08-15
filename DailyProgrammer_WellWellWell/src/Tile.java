import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Tile {

	private int r, c;
	
	private int height;
	private List<Tile> neighbors;
	
	private int waterlevel;
	
	public Tile(int r, int c, int height) {
		this.r = r;
		this.c = c;
		this.height = this.waterlevel = height;		// waterlevel starts the same as height
	}
	
	public void findNeighbors(List<Tile> tiles) {
		this.neighbors = tiles.stream()
				.filter(t -> 
					t.r == this.r+Direction.UP.x && t.c == this.c+Direction.UP.y ||
					t.r == this.r+Direction.DOWN.x && t.c == this.c+Direction.DOWN.y ||
					t.r == this.r+Direction.LEFT.x && t.c == this.c+Direction.LEFT.y ||
					t.r == this.r+Direction.RIGHT.x && t.c == this.c+Direction.RIGHT.y)
				.collect(Collectors.toList());
	}
	
	public void fill() { waterlevel++; }
	
	public List<Tile> neighbors() { return neighbors; }
	public int waterlevel() { return waterlevel; }
	public int height() { return height; }
	public int r() { return r; }
	public int c() { return c; }
	
	public static Comparator<Tile> CompareByHeight() {
		return new Comparator<Tile>() {
			@Override
			public int compare(Tile o1, Tile o2) {
				return o1.height() - o2.height();
			}
		};
	}
	
	public static Comparator<Tile> CompareByWaterlevel() {
		return new Comparator<Tile>() {

			@Override
			public int compare(Tile o1, Tile o2) {
				return o1.waterlevel() - o2.waterlevel();
			}
		};
	}
	
	public String toString() {
		return String.format("%d (%d)", height, waterlevel);
	}
}

enum Direction {
	UP(0, -1),
	DOWN(0, 1),
	LEFT(-1, 0),
	RIGHT(1, 0);
	
	int x, y;
	
	Direction(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
