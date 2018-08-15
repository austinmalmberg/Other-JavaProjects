import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Well {
	
	private int[][] topography;
	private Tile targetTile;
	
	List<Tile> tilesInWell;
	List<Tile> tilesAtOrBelowWaterLevel;
	
	public Well(int[][] topography, int target) {
		this.topography = topography;
		
		tilesInWell = new ArrayList<>();
		for(int r = 0; r < topography.length; r++) {
			for(int c = 0; c < topography[r].length; c++) {
				
				Tile t = new Tile(r, c, topography[r][c]);
				tilesInWell.add(t);
				
				if(topography[r][c] == target)
					targetTile = t;
			}
		}
		tilesInWell.stream().forEach(t -> t.findNeighbors(tilesInWell));
		
		tilesAtOrBelowWaterLevel = new ArrayList<>();
		tilesAtOrBelowWaterLevel.add(tilesInWell.stream().min(Tile.CompareByHeight()).get());
	}
	
	/**
	 * fills lowest Tile from pool or lowest height
	 */
	private void fillLowestTile() {		
		// get neighboring tiles of current pool with water levels less than or equal to the tile
		// add tiles to the pool
		tilesAtOrBelowWaterLevel.addAll(
				tilesAtOrBelowWaterLevel.stream().flatMap(t -> expandPool(t).stream()).collect(Collectors.toList()));
		
		// get the tiles with the lowest water levels then fill the one with the lowest height
		int lowestWaterLevel = tilesAtOrBelowWaterLevel.stream().mapToInt(t -> t.waterlevel()).min().getAsInt();
		tilesAtOrBelowWaterLevel.stream()
				.filter(t -> t.waterlevel() == lowestWaterLevel)
				.sorted(Tile.CompareByHeight())
				.findFirst().get().fill();
	}
	
	public List<Tile> expandPool(Tile t) {
		List<Tile> l = new ArrayList<>();		
		for(Tile n : t.neighbors()) {
			if(n.waterlevel() <= t.waterlevel() && !tilesAtOrBelowWaterLevel.contains(n)) {
				l.add(n);
				l.addAll(expandPool(n));
			}
		}
		
		return l;
	}
	
	public void displayWaterlevels() {
		System.out.println();
		IntStream.range(0, topography.length)	// number of rows from orig topography map
				.forEach(i -> {
					
					tilesInWell.stream().filter(t -> t.r() == i).forEach(t -> {		// print by original row number
						System.out.printf("%4d ", t.waterlevel());
					});
					System.out.println();
					
				});
	}
	
	public int timeToFill() {
		
		int time = 0;
		while(targetTile.waterlevel() < targetTile.height() + 1) {
			
			fillLowestTile();
			time++;
		}
		
		return time;
	}
}