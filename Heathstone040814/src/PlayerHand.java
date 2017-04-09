import java.util.ArrayList;


public class PlayerHand {
	private ArrayList<ChillwindYeti> hand = new ArrayList<>();
	
	public PlayerHand() {
		hand.add(new ChillwindYeti());	
		hand.add(new ChillwindYeti());	
		hand.add(new ChillwindYeti());	
		hand.add(new ChillwindYeti());	
	}
	
	public void draw() {
		hand.add(new ChillwindYeti());	
	}
	
	public ChillwindYeti remove(int i) {
		return hand.remove(i);
	}
	
	public ChillwindYeti view(int i) {
		return hand.get(i);
	}
	
	public int size() {
		return hand.size();
	}
	
	public void show() {
		System.out.println("\n" + hand.toString());
	}
	
}
