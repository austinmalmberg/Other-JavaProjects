package bets;

public class Chips {
	private int chips;
	
	public Chips() {
	}
	
	public Chips(int chips) {
		this.chips = chips;
	}
	
	public void change(int chips) {
		this.chips += chips;
	}
	
	public int get() {
		return this.chips;
	}
	
	public void set(int chips) {
		this.chips = chips;
	}
}
