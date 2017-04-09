
public class ChillwindYeti {
	private String name;
	private int attack;
	private int health;
	private int mana;
	
	public ChillwindYeti() {
		this.name = "Chillwind Yeti";
		this.attack = 4;
		this.health = 5;
		this.mana = 4;
	}
	
	public ChillwindYeti(int attack, int health, int mana) {
		this.attack = attack;
		this.health = health;
		this.mana = mana;
	}
	
	public void changeHealth(int health) {
		this.health -= health;
	}
	
	public int getAttack() {
		return attack;
	}
	public int getHealth() {
		return health;
	}
	public int getMana() {
		return mana;
	}
	
	public String toString() {
		return "(" + mana + ") " + name + " " + attack + "/" + health;
	}
}
