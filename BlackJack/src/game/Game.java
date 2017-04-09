package game;

import java.util.ArrayList;

import table.Hand;
import cards.Deck;
import bets.Bet;
import bets.Chips;

public class Game {
	private InputHelper input;
	
	private Deck deck;
	
	private Hand playerHand;
	private ArrayList<Hand> hands;
	private Hand houseHand;
	
	private Chips playerChips;
	private Chips houseChips;
	
	private Bet bet;
	
	public Game() {
		input = new InputHelper();
		
		//get deck
		deck = new Deck();
		
		playerHand = new Hand();
		hands = new ArrayList<Hand>();  //in the case that multiple hands are played (splits)
		houseHand = new Hand();
		
		//set chips
		playerChips = new Chips(1000);
		houseChips = new Chips(2000);

		bet = new Bet();
	}
	
	public void play() {		
		//get bet.  min: 20  max: 200 (based on playerChip stack)
		System.out.println("Player chip total:  " + playerChips.get());
		bet.setBet(input.getInt("How much would you like to bet?  ", "Invalid choice.  "
				+ "Must be between 20 and " + playerChips.get() / 5 + ".", 20, playerChips.get() / 5));
		
		do {
			//place bet
			//if player has less chips than the initial bet, set bet equal to the chip amount
			bet.setBet(bet.getBet());
			if (playerChips.get() < bet.getBet()) {
				bet.setBet(playerChips.get());
			}
			playerChips.change(-bet.getBet());
			
			deal();
			
			//if house has BlackJack, win everything
			if (houseHand.getTotal() == 21) {
				houseChips.change(bet.getBet());
				System.out.println("\nDealer has BlackJack.  You lost " + bet.getBet() + " chips.  New chip total:  " + playerChips.get());
			} else {
				playerDecision(playerHand);
				
				if (playerHand.getTotal() <= 21) {
					houseDecision();
				}

				System.out.println("\n--------------------Results--------------------");
				for (int i = 0; i < hands.size(); i++) {
					getWinner(hands.get(i));
				}
			}
			
			//reset hands
			playerHand.clear();
			hands.clear();
			houseHand.clear();
			bet.setDoubleDown(false);
			
			//possibly add new deck to existing when there are less than 30 cards?????
			//get new deck when there are less than 15 cards
			if (deck.getSize() < 10) {
				deck = new Deck();
			}
		} while (playerChips.get() > 0 && houseChips.get() > 0);
		
		if (playerChips.get() <= 0) {
			System.out.println("You lose.  Keep practicing.");
		} else {
			System.out.println("You beat the house! Time to go to Vegas!");
		}
	}
	
	private void deal() {
		System.out.println("\n---New Hand---");
		
		//deal
		playerHand.add(deck.dealCard());
		playerHand.add(deck.dealCard());

		houseHand.add(deck.dealCard());
		houseHand.add(deck.dealCard());
		
		//show cards
		System.out.print("Player has " + playerHand.getTotal() + ".  ");
		playerHand.showAll();
		System.out.print("House shows " + houseHand.getValue(0) + ".  ");
		houseHand.showOne(0);
	}
	
	private void playerDecision(Hand playerHand) {
		int choice;
		int maxChoice;
		String prompt = "";
		
		//player decision
		System.out.print("\n---Player Decision---");
		
		do {
			//generate choices
			prompt = "\n1. Hit  \n2. Stand";
			maxChoice = 2;
			//add double down option if possible
			if (playerChips.get() >= bet.getBet() && playerHand.getSize() == 2) {
				prompt += "\n3. Double Down";
				maxChoice = 3;
			}
			//add split option if possible
			if (playerChips.get() >= bet.getBet() && playerHand.getSize() == 2 && playerHand.getRank(0) == playerHand.getRank(1)) {
				prompt += "\n4. Split";
				maxChoice = 4;
			}
			
			//get choice
			System.out.println(prompt);
			choice = input.getInt("Your choice:  ", "Invalid choice.\n", 1, maxChoice);
			
			switch (choice) {
			case 1:  //hit
				hit("\nPlayer", playerHand);
				break;
			case 2:  //stand
				System.out.println("\nYou chose to stand on " + playerHand.getTotal() + ".");
				break;
			case 3:  //double down
				//double bet amount and hit
				playerChips.change(-bet.getBet());
				bet.setDoubleDown(true);
				//bet.change(bet.getInitialBet());
				hit("\nPlayer", playerHand);
				break;
			case 4:  //split
				playerChips.change(-bet.getBet());
				playerDecision(new Hand(playerHand.getCard(0), deck.dealCard()));
				playerDecision(new Hand(playerHand.getCard(1), deck.dealCard()));
				
				hands.remove(0);
				break;
			default:
				System.out.println("This should never be called.");
				break;
			}
			
			prompt = "";
		} while(playerHand.getTotal() <= 21 && choice == 1);
		
		hands.add(playerHand);
		
		if (playerHand.getTotal() > 21) {
			System.out.println("Player busts!");
		}
	}
	
	private void houseDecision() {
		//dealer stays on 17
		
		System.out.println("\n---House Decision---");
		
		System.out.print("House has " + houseHand.getTotal() + ".  ");
		houseHand.showAll();
		while(houseHand.getTotal() < 17) {
			hit("House", houseHand);
		}
		
		if (houseHand.getTotal() > 21) {
			System.out.println("House busts!");
		}
	}
	
	private void getWinner(Hand playerHand) {
		int xDouble = 4;
		int xWin = 2;
		int xPush = 1;
		
		if (playerHand.getTotal() > 21 || houseHand.getTotal() <= 21 && houseHand.getTotal() > playerHand.getTotal()) {  //if house wins (player busts or house beats dealer without busting)
			houseChips.change(bet.getBet());  //add to house chips
			System.out.println("House wins.  You lost " + bet.getBet() + " chips.  New chip total:  " + playerChips.get());
		} else if (playerHand.getTotal() <= 21 && houseHand.getTotal() <= 21 && houseHand.getTotal() == playerHand.getTotal()) {  //if push (same hand totals without busting)
			playerChips.change(bet.getBet() * xPush);  //get initial chips back
			//houseChips.change(bet.getBet() - bet.getBet());  //get remaining chips
			System.out.println("Push!  You received " + (bet.getBet() * xPush) + " chips.  New chip total:  " + playerChips.get());
		} else {  //player wins
			if (bet.getDoubleDown()) {
				playerChips.change(bet.getBet() * xDouble);  //add to player chips
				houseChips.change(-(bet.getBet() * xDouble));  //sub from house chips
				System.out.println("PLAYER WINS!  You received " + (bet.getBet() * xDouble) + " chips.  New chip total:  " + playerChips.get());
			} else {
				playerChips.change(bet.getBet() * xWin);  //add to player chips
				houseChips.change(-(bet.getBet() * xWin));  //sub from house chips
				System.out.println("PLAYER WINS!  You received " + (bet.getBet() * xWin) + " chips.  New chip total:  " + playerChips.get());
			}

		}

			//split pot
	}
	
	private void hit(String name, Hand hand) {
		hand.add(deck.dealCard());
		
		System.out.print(name + " has " + hand.getTotal() + ".  ");
		hand.showAll();
	}
}
