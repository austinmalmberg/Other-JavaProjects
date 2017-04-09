package entity.players;

import entity.GameObject;
import entity.hero._Hero;

public class Player extends GameObject {
	public boolean first;
	
	public Mana mana;
	
	private Cards deck;
	private Cards hand;
	
	public _Hero hero;
	
	// public Weapon weapon;
	
	public Player() {
		deck = new Cards(/**/);
		deck.setCardLimit(60);
		
		hand = new Cards(/**/);
		hand.setCardLimit(10);
	}

	@Override
	public void gameStart() {
		mana = new Mana();
	}

	@Override
	public void startTurn() {
		mana.newTurn();
		
		// if hand not full and deck not empty, draw card
		if(!hand.isFull() && !deck.isEmpty()) hand.append(deck.remove());
		
		// beginning of turn effects
	}

	@Override
	public void cardPlayed(int i) {
		//check playable
		if (hand.get(i).playable()) {
			
			// remove mana
			mana.use(hand.get(i).getManaCost());
		}
		// battlecry
		// auras
	}

	@Override
	public void onAttack() {
		// change health
		// attack effect
	}
	
	public void onDamage(int damage) {
		
	}

	@Override
	public void onDeath() {
		// remove card
		// deathrattle effects
	}

	@Override
	public void endTurn() {
		// remove temp effects
		// end of turn effects
	}

	@Override
	public void gameEnd() {
		
	}	
}
