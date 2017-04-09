
public class Player {
	
	public String name;
	
	private boolean turn;
		
	// categories (entertainment, art, sports, history, science, geography)
	private boolean[] categories;
	
	//
	private int counter;
	private int questionInterval;
	
	
	// statistics
	
	
	public Player(String name) {
		this.name = name;
		
		categories = new boolean[6];  // all categories set to false by default
		
		counter = 0;
		questionInterval = 3;
	}
	
	public boolean getTurn() { return turn; }
	public void  setTurn(boolean b) { turn = b; }
	
	public boolean[] getCategories() { return categories; }
	public void setCategory(int i, boolean b) { categories[i] = b; }
	
	public boolean counterFull() {
		counter++;
		if (counter == questionInterval) {
			counter = 0;
			return true;
		}
		return false;
	}
	
	public boolean wins() {
		for (int i = 0; i < categories.length; i++) {
			if (!categories[i]) {  // if any category is false, return false
				return false;
			}
		}
		return true;
	}
}
