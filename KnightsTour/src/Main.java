import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {
		
		Board board = new Board(5, 5);
		board.setKnightLocation(0, 0);
		
		KnightsTour tour = new KnightsTour(board);
		tour.printSolutionsGraphically();
		
//		board.getVisitedTiles().forEach(System.out::println);
		
//		System.out.println(board.getTile(1, 3).linkedUnvisitedTiles());
	}

}
