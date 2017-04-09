package poker.cards;

import java.util.ArrayList;


public class Hand {
	public ArrayList<Card> cards;
	
	public Hand() {		
		cards = new ArrayList<Card>();
	}
	
	public void addCard(Card card) {
		cards.add(card);
	}
	
	public void removeCard(int i) {
		cards.remove(i);
	}
	
	public void clear() {
		cards.clear();
	}
	
	public ArrayList<Card> getHand() {
		return cards;
	}
	
	public void show() {
		System.out.println(cards.toString());
	}

	public void setCard(int i, Card card) {
		cards.set(i, card);
	}
	
	public Card getCard(int i) {
		return cards.get(i);
	}
	
	public int getSize() {
		return cards.size();
	}
}
