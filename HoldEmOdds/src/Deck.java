import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	private ArrayList<Card> cards;
	
	public Deck() {
		cards = new ArrayList<>();
		
		compile();
	}
	
	public void compile() {
		for(int r = 0; r < Card.RANKS.length; r++) {
			for (int s = 0; s < Card.SUITS.length; s++) {
				cards.add(new Card(r, s));
			}
		}
	}
	
	public void shuffle() {
		Collections.shuffle(cards);
	}
	
	public Card deal() {
		return cards.remove(0);
	}
	
	public ArrayList<Card> getDeck() {
		return cards;
	}
	
	public String toString() {
		return cards.toString();
	}
}
