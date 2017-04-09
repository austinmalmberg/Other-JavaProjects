package entity;

public abstract class GameObject extends _MapObject {
	
	// defaults
	public int dAttack;
	public int dHealth;
	public int dArmor;
	
	// currents
	public int attack;
	public int health;
	public int armor;
	
	// maximums
	public int mAttack;
	public int mHealth;
	public int mArmor;
	
	public abstract void gameStart();
	public abstract void startTurn();
	public abstract void cardPlayed(int i);
	public abstract void onAttack();
	public abstract void onDamage(int damage);
	public abstract void onDeath();
	public abstract void endTurn();
	public abstract void gameEnd();
}
