import helpers.InputHelper;


public class Play {
//	private BoardState board;
//	private PlayerHand playerHand;
	
	InputHelper helper = new InputHelper();
	
	public Play(BoardState board, PlayerHand playerHand) {
//		this.board = board;
//		this.playerHand = playerHand;
		
		boolean endTurn = false;
		do {
			int choice = helper.getInt("\nWhich card would you like to play (enter 0 to end turn)?", 0, playerHand.size()) - 1;
			
			if (choice == -1) {
				endTurn = true;
			} else if (playerHand.view(choice).getMana() <= board.getPlayerMana()) {
				board.changePlayerMana(playerHand.view(choice).getMana());
				board.addToPlayerBoard(playerHand.remove(choice));
				
				board.show();
				playerHand.show();
			} else {
				System.out.println("Not enough mana.");
			}
		} while (!endTurn);
	}
}
