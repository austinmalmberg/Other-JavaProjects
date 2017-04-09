import java.util.Random;

public class Card {
	private int[] cards = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
	
	private int rand;
	private int arrVal;
	
	public int get() {		
		Random rng = new Random();
		
		for (int i = 0; i < cards.length; i++) {
			rand = rng.nextInt(cards.length);  //get random number
			arrVal = cards[rand];
			
			if (notUsed(rand)) {
				cards[rand] = 0;  //change value to 0 to indicate it has been used
				return arrVal;
			}
		}
		return 1000;  //should not be called
	}
	
	private boolean notUsed(int i) {
		if (cards[i] != 0) {
			return true;
		}
		return false;
	}
}
