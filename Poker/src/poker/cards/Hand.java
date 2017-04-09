package poker.cards;

import java.util.ArrayList;

public class Hand {
	private ArrayList<Card> hand;
	private boolean dealer;
	
	public Hand() {
		hand = new ArrayList<Card>();
	}
	
	public void addCard(Card c) {
		hand.add(c);
	}

	public Card getCard(int i) {
		return hand.get(i);
	}
	
	public ArrayList<Card> getHand() {
		return hand;
	}
	
	public void clear() {
		hand.clear();
	}
}
