package cards;

import java.util.ArrayList;

public class Deck {
	// this class will create a randomized deck
	
	static final int NUM_OF_CARDS = 52;
	
	private ArrayList<Card> deck;
	
	public Deck() {
		 deck = new ArrayList<Card>();

		 //assemble deck
		 shuffle();
	}
	
	private void shuffle() {
		deck.clear();
		
		Card card;
		
		System.out.println("Shuffling...");
		//compiles deck
		for (int i = 0; i < NUM_OF_CARDS; i++) {
			do {
				card = new Card();
			} while (duplicate(card));
			deck.add(card);
		}
	}
	
	private boolean duplicate(Card card) {
		
		//cycle through each card in deck
		for(int i = 0; i < deck.size(); i++) {
			//return true if duplicate
			if (deck.get(i).equals(card)) {
				return true;
			}
		}
		return false;
	}
	
	public Card dealCard() {
		return deck.remove(0);
	}
	
	public int getSize() {
		return deck.size();
	}
}
