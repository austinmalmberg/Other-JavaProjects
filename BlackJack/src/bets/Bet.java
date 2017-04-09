package bets;

public class Bet {	
	private int bet;
//	private int initialBet;
	private boolean doubleDown;
	
	public Bet() {
		bet = 0;
//		initialBet = 0;
		doubleDown = false;
	}
	
	public int getBet() {
		return this.bet;
	}
	
	public void setBet(int bet) {
		this.bet = bet;
	}
	
//	public void setInitialBet(int initialBet) {
//		this.initialBet = initialBet;
//	}
	
//	public int getInitialBet() {
//		return this.initialBet;
//	}
	
	public void change(int bet) {
		this.bet += bet;
	}
	
	public boolean getDoubleDown() {
		return doubleDown;
	}
	
	public void setDoubleDown(boolean doubleDown) {
		this.doubleDown = doubleDown;
	}
}
