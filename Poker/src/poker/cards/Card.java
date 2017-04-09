package poker.cards;

import java.util.Random;

public class Card {	
	private final String[] ranks= {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
	private final String[] suits = {"Spades", "Hearts", "Clubs", "Diamonds"};
	
	Random rnd;
	
	int rndRank;
	int rndSuit;
	
	public Card() {
		rnd = new Random();
		
		rndRank = rnd.nextInt(ranks.length);
		rndSuit = rnd.nextInt(suits.length);
	}
	
	public int getSuit() {
		return this.rndSuit;
	}
	public int getRank() {
		return this.rndRank;
	}

	public String getRankOf(int i) {
		return ranks[i];
	}
	public String getRank(int i) {
		return ranks[i];
	}
	public String getSuit(int i) {
		return suits[i];
	}
	
	public String toString() {		
		//i.e. Jack of Diamonds
		return ranks[rndRank] + " of " + suits[rndSuit];
	}
}
