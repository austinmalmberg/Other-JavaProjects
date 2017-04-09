package poker.bets;

public class Chips {
	private int chipTotal;
	private int ante;
	
	public Chips() {
		this.chipTotal = 0;
		this.ante = 0;
	}
	
	public int getChipTotal() {
		return chipTotal;
	}
	public void changeChipTotal(int chipTotal) {
		this.chipTotal += chipTotal;
	}
	public void setChipTotal(int chipTotal) {
		this.chipTotal = chipTotal;
	}
	
	public int getAnte() {
		return ante;
	}
	public void setAnte(int ante) {
		this.ante = ante;
	}
	
	public void getPayout(int rank) {
		int multiplier = 0;
		int winnings = 0;
		
		switch (rank) {
		case 0:  //high card
			multiplier = 0;
			break;
		case 1:  //one pair
			multiplier = 1;
			break;
		case 2:  //two pair
			multiplier = 2;
			break;
		case 3:  //three of a kind
			multiplier = 3;
			break;
		case 4:  //straight
			multiplier = 4;
			break;
		case 5:  //flush
			multiplier = 6;
			break;
		case 6:  //full house
			multiplier = 9;
			break;
		case 7:  //four of a kind
			multiplier = 25;
			break;
		case 8:  //straight flush
			multiplier = 50;
			break;
		case 9:  //royal flush
			multiplier = 250;
			break;
		default:
			System.out.println("Uh oh...");  //will never be called
			break;
		}
		
		winnings = ante * multiplier;
		chipTotal += winnings;
		
		System.out.print("You won " + winnings + " chips");
		if (winnings >= 300) {
			System.out.println("!");
		} else {
			System.out.println(".");
		}
	}
	
	public void show() {
		System.out.println("Chip total:  " + chipTotal + "\n");
	}
}
