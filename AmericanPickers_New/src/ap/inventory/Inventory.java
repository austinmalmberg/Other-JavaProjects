package ap.inventory;

public class Inventory {
	
	private int count;
	
	public Inventory() {
		count = 1;
	}
	
	public String getCurrentCount() {
		return "Current #: " + count;
	}
	
	public void addToCurrent() {
		count++;
	}
}
