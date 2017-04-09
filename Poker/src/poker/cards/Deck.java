package poker.cards;

import java.util.ArrayList;

public class Deck {
	static final int NUM_OF_CARDS = 52;
	
	private ArrayList<Card> deck;
	Card card;

	public Deck() {
		 deck = new ArrayList<>();
		 
		 //assembles random deck
		 shuffle();
	}
	
	public void shuffle() {
		deck.clear();
		
		for (int i = 0; i < NUM_OF_CARDS; i++) {
			do {
				card = new Card();
			} while (isDuplicate());
			deck.add(card);
		}
	}
	
	private boolean isDuplicate() {
		for (Card card : deck) {
			if (card.toString().equals(card.toString())) {
				return true;
			}
		}
		return false;
	}
	
	public Card dealCard() {
		return deck.remove(0);
	}
	
	public int size() {
		return deck.size();
	}
}
