
public class Main {
	public static void main(String[] args) {
	    int wins = 7;
	    int gold = 150;

	    do {
	        gold -= 150;
	        if (wins >= 7) {
	            gold += 150;
	        }
	    } while (gold >= 150);
	    
	    System.out.println("Loop ended.");
	}
}
