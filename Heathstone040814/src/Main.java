
public class Main {
	
	public static void main (String[] args) {
		Play play;
		BoardState board;
		PlayerHand playerHand;
		
		board = new BoardState(4);
		
		playerHand = new PlayerHand();
		
		board.show();
		playerHand.show();
		
		play = new Play(board, playerHand);
	}
} 
