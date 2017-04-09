package cards;

import java.util.Random;

public class Card {
	private String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
	private String[] suits = {"Spades", "Hearts", "Clubs", "Diamonds"};
	
	private Random rng;
	private int rndRank;
	private int rndSuit;

	public Card() {
		rng = new Random();
		
		//generate card as two int values
		rndRank = rng.nextInt(ranks.length);
		rndSuit = rng.nextInt(suits.length);
	}

	public int getRank() {
		return this.rndRank;
	}
	
	//unused
	public int getSuit() {
		return this.rndSuit;
	}
	
	public String toString() {
		return ranks[rndRank] + " of " + suits[rndSuit];
	}
}
