package entity.players;

public class Mana {
	private int dMana;
	private int mana;
	
	public Mana() {
		dMana = mana = 0;
	}
	
	public void setDefaultMana(int i) {	dMana = i; }
	
	public int getDefaultMana() { return dMana; }
	public int getMana() { return mana; }
	
	public void newTurn() {
		if (dMana < 10) {
			dMana += 1;
		}
		mana = dMana;
	}
	
	public void add(int i) {
		if (mana + i > 10) return;
		mana += i;
	}
	public void use(int i) {
		if (mana - i < 0) return;
		mana -= i;
	}
}
