package poker.cards;


public class Card {
	private int rank;
	private int suit;
	
	private static String ranks[] = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
	private static String suits[] = {"Spades","Hearts","Clubs","Diamonds"};
	
	public Card() {}
	
	public Card(int j, int i) {
		rank = j;
		suit = i;
	}
	
	//getters
	public int getRank() {
		return rank;
	}
	public int getSuit() {
		return suit;
	}
	
	public String getRanks(int i) {
		return ranks[i];
	}
	
	public int getRanksLength() {
		return ranks.length;
	}
	public int getSuitsLength() {
		return suits.length;
	}
	
	public String toString() {
		return ranks[rank] + " of " + suits[suit];
	}
}
