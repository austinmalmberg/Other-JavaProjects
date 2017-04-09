package table;

import java.util.ArrayList;

import cards.Card;

public class Hand {
	private ArrayList<Card> hand;
	
	public Hand() {
		hand = new ArrayList<Card>();
	}
	
	public Hand(Card c1, Card c2) {
		hand = new ArrayList<Card>();
		
		hand.add(c1);
		hand.add(c2);
		
		System.out.print("\nPlayer has " + getTotal() + ".  ");
		showAll();
	}
	
	public void add(Card card) {
		hand.add(card);
	}
	
	public void clear() {
		hand.clear();
	}
	
	public void showAll() {
		System.out.println(hand.toString());
	}
	
	public void showOne(int index) {
		System.out.println("[" + hand.get(index).toString() + "]");
	}
	
	public Card getCard(int index) {
		return hand.get(index);
	}
	
	public int getRank(int index) {
		return hand.get(index).getRank();
	}
	
	public int getSize() {
		return hand.size();
	}
	
	public int getValue(int index) {
		return findValue(hand.get(index).getRank());
	}
	
	public int getTotal() {
		int temp;
		int total = 0;
		int aceCount = 0;
		
		//add up values from each card
		for (int i = 0; i < hand.size(); i++) {
			temp = findValue(hand.get(i).getRank());
			if (temp == 11) {
				aceCount++;
			}
			total += temp;
		}
		
		//handle aces
		if (total > 21 && aceCount > 0) {
			for (int i = 0; i < aceCount; i++) {
				total -= 10;
				if (total <= 21) {
					return total;
				}
			}
		}

		return total;
	}
	
	private int findValue(int rank) {
		switch (rank) {
		case 0:  //two
		case 1:  //three
		case 2:  //four
		case 3:  //five
		case 4:  //six
		case 5:  //seven
		case 6:  //eight
		case 7:  //nine
			return rank + 2;
		case 8:  //ten
		case 9:  //jack
		case 10:  //queen
		case 11:  //king
			return 10;
		case 12:  //ace
			return 11;
		default:
			System.out.println("This should never be called.");
			return 0;
		}	
	}
}
