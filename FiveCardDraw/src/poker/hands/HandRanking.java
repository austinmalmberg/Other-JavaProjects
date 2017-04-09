package poker.hands;

import java.util.ArrayList;

import poker.cards.Card;

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

public class HandRanking {
	private ArrayList<Card> hand;
	private int highCard;
	private Card card = new Card();
	private int rank;
	
	public HandRanking() {}
	
	public void get(ArrayList<Card> hand) {
		this.hand = new ArrayList<Card>(hand);
		
		sort();
		
		System.out.print("You have ");
		
		switch (checkKinds()) {
		case 7:
			rank = 7;
			System.out.println("Four of a Kind!");
			break;
		case 6:
			rank = 6;
			System.out.println("a Full House!");
			break;
		case 3:
			rank = 3;
			System.out.println("Three of a Kind.");
			break;
		case 2:
			rank = 2;
			System.out.println("Two Pair.");
			break;
		case 1:
			rank = 1;
			System.out.println("a pair.");
			break;
		default:
			if (checkStraight() && checkFlush()) {
				if (highCard == 12) {
					rank = 9;
					System.out.println("a ROYAL FLUSH!");
				} else {
					rank = 8;
					System.out.println("a Straight Flush!");
				}
			} else if (checkFlush()) {
				rank = 5;
				System.out.println("a Flush!");
			} else if (checkStraight()) {
				rank = 4;
				System.out.println("a Straight!");
			} else {
				rank = 0;
				System.out.println(card.getRanks(highCard) + " High.");
			}
		}
		System.out.println();
	}
	
	public int get() {
		return rank;
	}
	
	private void sort() {
		Card temp;
		//bubble sort byVal hand array
		for (int i = 0; i < hand.size(); i++) {
			for (int j = i + 1; j < hand.size(); j++) {
				if (hand.get(i).getRank() > hand.get(j).getRank()) {
					temp = hand.get(j);
					hand.set(j, hand.get(i));
					hand.set(i, temp);
				}
			}
		}
		
		highCard = getHighCard(); 
	}
	
	private int checkKinds() {		
		//four of a kind
		if (hand.get(0).getRank() == hand.get(3).getRank() || hand.get(1).getRank() == hand.get(4).getRank()){  //four of a kind
			return 7;
		}
		
		//check three of a kind and full house
		if (hand.get(0).getRank() == hand.get(2).getRank() || hand.get(1).getRank() == hand.get(3).getRank() || hand.get(2).getRank() == hand.get(4).getRank()) {  //three of a kind
			if (hand.get(0).getRank() == hand.get(1).getRank() && hand.get(2).getRank() == hand.get(4).getRank() ||
					hand.get(0).getRank() == hand.get(2).getRank() && hand.get(3).getRank() == hand.get(4).getRank()) {  //full house
				return 6;
			} else {
				return 3;
			}
		}
		
		//check for pairs
		int pairs = 0;
		for (int i = 1; i < hand.size(); i++) {
			if (hand.get(i - 1).getRank() == hand.get(i).getRank()) {
				pairs++;
			}
		}
		
		return pairs;
	}
	
	private boolean checkStraight() {		
		int counter = 1;
		
		for (int i = 1; i < hand.size(); i++) {
			if (hand.get(0).getRank() == (hand.get(i).getRank() - i)) {
				counter++;
			}
		}
		
		if (counter >= 5) {
			return true;
		} else {
			return false;
		}
	}
	
	private boolean checkFlush() {
		int counter = 1;
		
		for (int i = 1; i < hand.size(); i++) {
			if (hand.get(0).getSuit() == hand.get(i).getSuit()) {
				counter++;
			}
		}
		
		if (counter >= 5) {
			return true;
		} else {
			return false;
		}
	}
	
	private int getHighCard() {
		return hand.get(hand.size()- 1).getRank();
	}
}
