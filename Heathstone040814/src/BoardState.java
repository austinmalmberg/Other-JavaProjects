import java.util.ArrayList;


public class BoardState {
	private int playerMana;
	private int maxPlayerMana;
	private ArrayList<ChillwindYeti> playerBoard;
	private ArrayList<ChillwindYeti> oppBoard;
	
	public BoardState() {
	}
	
	public BoardState(int maxPlayerMana) {
		this.maxPlayerMana = maxPlayerMana;
		playerBoard = new ArrayList<>();
		oppBoard = new ArrayList<>();
		
		playerMana = maxPlayerMana;
	}
	
	public void addPlayerMana() {
		maxPlayerMana++;
		playerMana = maxPlayerMana;
	}
	
	public int getPlayerMana() {
		return playerMana;
	}
	
	public void addToPlayerBoard(ChillwindYeti c) {
		playerBoard.add(c);
	}
	
	public void changePlayerMana(int i) {
		playerMana -= i;
	}
	
	public void show() {
		System.out.println("\nOpponent's board: " + oppBoard);
		System.out.println("      Your board: " + playerBoard);
		
		System.out.println("\n       Your mana:  " + playerMana + "/" + maxPlayerMana);
	}
}
