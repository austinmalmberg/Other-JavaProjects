package entity;

import entity.card.effects.Battlecry;
import entity.card.effects.Deathrattle;

public abstract class Card extends GameObject {
	
	protected String name;
	protected String id;
	protected String text;
	protected String flavorText;
	
	protected String type;
	protected String rarity;
	
	protected boolean isCollectible;
	
	// default stats
	protected int dManaCost;
	
	// current stats
	protected int manaCost;
	
	// card status
	protected boolean playable;
	protected boolean isExhausted;
	protected boolean canAttack;
	protected boolean isAttackable;
	protected boolean isDead;
	
	// card effects
	protected Battlecry battlecry;
	protected Deathrattle deathrattle;
	protected boolean isTaunt;
	protected boolean isCharge;
	protected boolean isDivineShield;
	protected boolean isStealth;
	protected boolean isWindfury;

	public Card() {}
	
	public String getName() { return name; }
	public String getText() { return text; }
	public String getType() { return type; }
	public String getRarity() { return rarity; }
	
	public int getManaCost() { return manaCost; }
	public void setManaCost(int i) { manaCost = i; }
	
	public void setPlayable(boolean b) { playable = b; }
	public void setCanAttack(boolean b) { canAttack = b; }
	public void setExhausted(boolean b) { isExhausted = b; }
	public void setAttackable(boolean b) { isAttackable = b; }
		
	public boolean playable() { return playable; }
	public boolean canAttack() { return canAttack; }
	public boolean isExhausted() { return isExhausted; }
	public boolean isAttackable() { return isAttackable; }
	
	public Battlecry getBattlecry() { return battlecry; }
	public Deathrattle getDeathrattle() { return deathrattle; }
	public boolean getTaunt() { return isTaunt; }
	public boolean getCharge() { return isCharge; }
	public boolean getDivineShield() { return isDivineShield; }
	public boolean getStealth() { return isStealth; }
	public boolean getWindfury() { return isWindfury; }
	
	public boolean isDamaged() {
		if(health < mHealth) {
			return true;
		}
		return false;
	}
	
	public void hit(int damage) {
		if (isDead) return;
		health -= damage;
		if (health <= 0) {
			health = 0;
			isDead = true;
		}
	}
}