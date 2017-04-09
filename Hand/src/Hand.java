
public class Hand {
	Card card = new Card();
	int numCards = 10;
	
	int hand[] = new int[numCards];
	
	public Hand() {
		for (int i = 0; i < hand.length; i++) {
			hand[i] = card.get();
		}
	}
	
	public void show() {
		System.out.print("[");
		for (int i = 0; i < hand.length; i++) {
			System.out.print(hand[i]);
			if (i < hand.length - 1) {
				System.out.print(", ");
			}
		}
		System.out.println("]");
	}
}
