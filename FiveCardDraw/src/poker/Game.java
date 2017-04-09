package poker;

import helpers.InputHelper;
import poker.bets.Chips;
import poker.cards.Deck;
import poker.cards.Hand;
import poker.hands.HandRanking;

public class Game {
	private Deck deck;
	private Hand hand;
	private Chips chips;
	private HandRanking handRank;
	
	private InputHelper helper;
	
	static final int NUM_CARDS_IN_HAND = 5;
	
	public Game() {
		deck = new Deck();
		deck.shuffle();
		
		hand = new Hand();
		
		chips = new Chips();
		chips.setChipTotal(5000);
		chips.setAnte(100);
		
		handRank = new HandRanking();
		
		helper = new InputHelper();
	}
	
	public void play() {
		//welcome messsage
		
		do {
			//ante up
			if (chips.getChipTotal() < chips.getAnte()) {  //this is in case the chip total is less than the ante
				System.out.println("Ante:  -" + chips.getChipTotal());
				chips.changeChipTotal(-chips.getChipTotal());  //set ante to remaining chip total (deduct remaining chips)
			} else {
				System.out.println("Ante: -" + chips.getAnte());
				chips.changeChipTotal(-chips.getAnte());
			}
			chips.show();
			
			//deal cards
			for (int i = 0; i < NUM_CARDS_IN_HAND; i++) {
				//hand.addCard(deck.draw());
				hand.cards.add(deck.draw());
			}
			hand.show();
			
			//determine rank
			handRank.get(hand.getHand());
			
			//get discards and deal cards
			getDiscards();
			hand.show();
			
			//determine rank
			handRank.get(hand.getHand());
			
			//get payout
			chips.getPayout(handRank.get());
			chips.show();
			
			//reset
			if (hand.getSize() > 0) {
				hand.clear();
			}
			
			//if deck runs out
			if (deck.count() < 15) {
				deck.shuffle();
			}
				
		} while(chips.getChipTotal() > 0);
		
		//lose
		System.out.println("Sorry, you lose.");
	}
	
	public void getDiscards() {
		int digits;
		int arrDiscard[];
		boolean invalidDigits;
		boolean duplicates; 
		int discard;

		do {  //get cards to discard
			invalidDigits = false;
			duplicates = false;
			
			discard = helper.getInt("Which cards would you like to discard (i.e. 12345 to discard your whole hand)?", "Invalid number.", 1, 54321);
			
			digits = Integer.toString(discard).length();
			
			//test all numbers that they're between 1 and 5
			arrDiscard = new int[digits];
			for (int i = digits - 1; i >= 0; i--) {
				arrDiscard[i] = discard % 10;
				discard /= 10;
				if (arrDiscard[i] < 1 || arrDiscard[i] > 5) {
					System.out.println("All digits must be between 1 and " + NUM_CARDS_IN_HAND + ".\n");
					invalidDigits = true;
					break;
				}
			}
			
			if (!invalidDigits) {
				outer:
				for (int i = 0; i < arrDiscard.length; i++) {
					for (int j = i + 1; j < arrDiscard.length; j++) {
						if (arrDiscard[i] == arrDiscard[j]) {
							System.out.println("Input must not contain duplicate values.\n");
							duplicates = true;
							break outer;
						}
					}
				}
			}
		} while (invalidDigits || duplicates);
		
		//replace cards
		for (int i = 0; i < arrDiscard.length; i++) {
			hand.setCard(arrDiscard[i] - 1, deck.draw());
		}
		
		System.out.println();
	}
}
