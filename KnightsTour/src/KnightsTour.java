import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class KnightsTour {

	private Board board;
	
	private List<LinkedList<Tile>> solutions;
	
	public KnightsTour(Board board) {
		this.board = board;
		
		solutions = new ArrayList<>();
		
		navigate();
	}
	
	private void navigate() {
		LinkedList<Tile> workingList = new LinkedList<>();
		workingList.add(board.getKnightTile());
		
		plotTour(board, workingList);
	}
	
	private void plotTour(Board board, LinkedList<Tile> workingList) {
		
		if(workingList.getLast().linkedUnvisitedTiles().isEmpty()) {
			if(board.getUnvisitedTiles().isEmpty())
				solutions.add(workingList);
			
			return;
		}
		
//		System.out.println(workingList.getLast().getPotentialTiles());
		
		for(Tile t : workingList.getLast().getPotentialTiles()) {
			board.setKnightLocation(t.getX(), t.getY());
			workingList.add(board.getKnightTile());
			
			plotTour(board, workingList);
		}
	}
	
	public void printSolutions() {
		solutions.stream().forEach(System.out::println);
	}
	
	public void printSolutionsGraphically() {
		
		int[][] graphic = new int[board.getRows()][board.getColumns()];
		
		solutions.stream().forEach(solution -> {
			
			// populate graphic
			for(int i = 0; i < solution.size(); i++) {
				Tile t = solution.get(i);
				graphic[t.getX()][t.getY()] = i;
			}
			
			// print graphic
			for(int[] row : graphic) {
				for(int i : row) {
					System.out.printf("%3d ", i);
				}
				System.out.println();
			}
			System.out.println();
		});
	}
}
