package poker.cards;
import java.util.ArrayList;
import java.util.Random;


public class Deck {
	
	private ArrayList<Card> cards;
	private Card card = new Card();
	private Random generator = new Random();
	
	public Deck() {  //constructor that compiles the deck;
		cards = new ArrayList<>();
		generator = new Random();
	}
	
	public void shuffle() {
		compile();
		
		System.out.println("Shuffling deck...");
		
		int rnd;
		
		for (int i = cards.size(); i > 0; i--) {
			//takes a card from a random position and adds it to the end of the deck
			
			rnd = generator.nextInt(i);  //get random number between 0 and cards.size()
			cards.add(cards.get(rnd));  //add a duplicate card from the rnd position to the end of the ArrayList
			cards.remove(rnd);  //remove card from position rnd
		}
	}
	
	public void compile() {
		cards.clear();
		
		for (int i = 0; i < card.getSuitsLength(); i++) {
			for (int j = 0; j < card.getRanksLength(); j++) {
				cards.add(new Card(j, i));
			}
		}
	}
	
	public Card draw() {
		return cards.remove(0);
	}
	
	public int count() {
		return cards.size();
	}
	
	public String toString() {
		return cards.toString();
	}
}
