import java.util.ArrayList;

public class HandRank {
	private ArrayList<Card> hand;
	private ArrayList<Card> communityCards;
	
	private int rank;
	
	public HandRank(ArrayList<Card> hand, ArrayList<Card> communityCards) {
		this.hand = new ArrayList<>(hand);
		this.communityCards = new ArrayList<>(communityCards);
		
		rank = 0;
		
		// check flush
		// check straight
		// kinds
	}
	
	public void sort(ArrayList<Card> cards) {
		
	}
	
	public int getRank() {
		return rank;
	}
}
