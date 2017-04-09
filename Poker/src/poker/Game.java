package poker;

import java.util.ArrayList;

import poker.bets.Stack;
import poker.cards.Deck;
import poker.cards.Hand;
import poker.players.*;

public class Game {
	InputHelper helper;
	
	private ArrayList<PlayerObject> players;
	private Player player;
	
	private Hand community;
	
	private Deck deck;
	
	private Stack pot;

	public Game() {
		helper = new InputHelper();
		
		System.out.println("Welcome to Texas Hold'em Poker!");
		
		players = new ArrayList<PlayerObject>();
		player = new Player(helper.getString("Enter your name:  ", "Name must be between 2 and 10 characters", 2, 10));
		
		players.add(player);
		
		getAiPlayers();  //determine number of AI
		
		community = new Hand();
		
		deck = new Deck();
		
		pot = new Stack();
	}
	
	public void play() {
		//find dealer
		assignDealer();
		
		//get blinds
		
		//deal
		
		//betting round
		
		//flop
		
		//bet
		
		//turn
		
		//bet
		
		//river
	}
	
	public void getAiPlayers() {
		int numPlayers;

		numPlayers = helper.getInt("How many AI would you like to play against (1-3)?  ", "Invalid number", 1, 3);
		
		for (int i = 0; i < numPlayers; i++) {
			players.add(new AI("Computer " + (i + 1)));
		}
	}
	
	public void assignDealer() {
		
	}
	
	public void getBlinds() {
		
	}
}
