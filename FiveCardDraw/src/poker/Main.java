package poker;

public class Main {

	//bug:
	//In Hand.show(), ranking.get(cards) is sorting ByRef instead of ByVal 
	
	public static void main(String[] args) {
		Game game = new Game();
		game.play();
	}

}
