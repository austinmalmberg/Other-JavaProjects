package poker.players;

import poker.bets.Stack;
import poker.cards.Deck;
import poker.cards.Hand;
import poker.ranks.HandRank;

public abstract class PlayerObject {
	HandRank rank;
	
	protected String name;
	
	protected Stack stack;
	
	protected Hand hand;
	
	protected boolean dealer;
	
	public PlayerObject(String name) {
		rank = new HandRank();
		
		this.name = name;
		
		stack = new Stack();
		
		hand = new Hand();
		
		dealer = false;
	}
	
	public abstract void action();
	
	public void showHand() {
		System.out.println(name + " has " + hand.toString());
	}
	
	public void setStack(int i) {
		stack.setStack(i);
	}
	
	public void changeStack(int i) {
		stack.change(i);
	}
	
	public void showStack() {
		System.out.println(name + " chip total: " + stack.getStack());
	}
	
	public int getStack() {
		return stack.getStack();
	}
	
	public void addCard(Deck d) {
		hand.addCard(d.dealCard());
	}
	
	public void getCard(int i) {
		hand.getCard(i);
	}
	
	public boolean isDealer() {
		return dealer;
	}
	
	public void setDealer(boolean d) {
		dealer = d;
	}
}
