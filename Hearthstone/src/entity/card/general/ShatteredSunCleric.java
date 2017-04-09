package entity.card.general;

import entity.Card;
import entity.card.effects.LevelUp;

public class ShatteredSunCleric extends Card {

	public ShatteredSunCleric() {
		super();
		
		name = "Shattered Sun Cleric";
		// id
		text = "Battlecry: Give a friendly minion +1/+1";
		flavorText = "They always have a spare flask oof Sunwell Energy Drink!";
		
		type = "Minion";
		rarity = "Common";
		
		isCollectible = true;
		
		manaCost = dManaCost = 3;
		attack = dAttack = 3;
		health = dHealth = 2;
		
		battlecry = new LevelUp(1, 1);
		deathrattle = null;
		isTaunt = false;
		isCharge = false;
		isDivineShield = false;
	}

	@Override
	public void gameStart() {
		
	}

	@Override
	public void startTurn() {
		
	}

	@Override
	public void cardPlayed(int i) {
		
	}

	@Override
	public void onAttack() {
		
	}
	
	public void onDamage(int damage) {
		
	}

	@Override
	public void onDeath() {
		
	}

	@Override
	public void endTurn() {
		
	}

	@Override
	public void gameEnd() {
		
	}
}
