
public class Card {
	public static final String[] RANKS = {"2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K", "A"}; 
	public static final String[] SUITS = {"s", "c", "h", "d"};
	
	private int rank;
	private int suit;
	
	public Card(int rank, int suit) {
		this.rank = rank;
		this.suit = suit;
	}
	
	public int getRank() {
		return rank;
	}
	public int getSuit() {
		return suit;
	}
	
	public String toString() {
		return RANKS[rank] + SUITS[suit];
	}
}
