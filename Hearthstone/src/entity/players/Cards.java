package entity.players;

import java.util.ArrayList;

import entity.Card;

public class Cards {
	private ArrayList<Card> cards;
	private int cardLimit = 10;
	
	public Cards() {
		cards = new ArrayList<Card>();
	}
	public Cards(Card c) {
		cards = new ArrayList<Card>();
		cards.add(c);
	}
	public Cards(ArrayList<Card> cards) {
		this.cards = cards;
	}
	
	public int getCardLimit() { return cardLimit; }
	public void setCardLimit(int i) { cardLimit = i; }
	
	public void add(int i, Card c) {
		if(cards.size() >= cardLimit || i < 0 || i > cards.size()) return;
		cards.add(i, c);
	}
	public void append(Card c) {
		if (cards.size() >= cardLimit) return;
		cards.add(c);
	}
	public Card remove() {
		if (cards.isEmpty()) return null;
		return cards.remove(0);
	}
	
	public void shuffle() {
		if(cards.isEmpty()) return;
		java.util.Collections.shuffle(cards);
	}
	
	public boolean isFull() { return (cards.size() >= cardLimit); }
	public boolean isEmpty() { return cards.isEmpty(); }
	public int size() {	return cards.size(); }
	public Card get(int i) {
		return cards.get(i);
	}
}
