package poker.ranks;

import java.util.ArrayList;

import poker.cards.Card;
import poker.cards.Hand;

//high card = 0
//one pair = 1
//two pair = 2
//three of a kind = 3
//straight = 4
//flush = 5
//full house = 6
//four of a kind = 7
//straight flush = 8
//royal flush = 9

public class HandRank {
	private ArrayList<Card> cards;
	private int highCard;
	
	Card card;
	
	public HandRank() {
		cards = new ArrayList<>();
	}
	
	public void get(Hand hand, Hand community) {		
		//combine hand and community into one arraylist
		cards.addAll(hand.getHand());
		cards.addAll(community.getHand());
		
		sort();
	}
	
	private void sort() {
		Card temp;
		//bubble sort byVal hand array
		for (int i = 0; i < cards.size(); i++) {
			for (int j = i + 1; j < cards.size(); j++) {
				if (cards.get(i).getRank() > cards.get(j).getRank()) {
					temp = cards.get(j);
					cards.set(j, cards.get(i));
					cards.set(i, temp);
				}
			}
		}
		
		highCard = highCard(); 
	}
	
	private int kindOrPair() {		
		//four of a kind
		
		//full house
		
		//three of a kind
		
		//two pair
		
		// one pair
	}
	
	private boolean straight() {
		int counter = 0;
		
		for (int i = 0; i < cards.size() - 4; i++) {  //determine number of iterations  (i.e. with 5 cards, will loop 1 time...with 7 cards, will loop 3 times)
			for (int j = i; j < cards.size(); j++) {
				if (cards.get(j).getRank() != ) {
					
				}
			}
			
			counter = 0;
		}
	}
	
	private boolean flush() {

	}
	
	private int highCard() {
		return cards.get(cards.size()- 1).getRank();
	}
}
