
public class Main {
	public static void main(String[] args) {
		new WordBalance("STEAD");
		new WordBalance("CONSUBSTANTIATION");
		new WordBalance("WRONGHEADED");
		new WordBalance("UNINTELLIGIBILITY");
		new WordBalance("SUPERGLUE");
	}
}

class WordBalance {
	String word;
	int balanceWeight = 0;
	
	public WordBalance(String word) {
		this.word = word.trim().toUpperCase();
		
		if(!isEligible()) System.out.println("String must only contain letters.");
		
		display(findBalance());
	}
	
	private boolean isEligible() {
		if(word.length() == 0) return false;  // test for empty string
		
		for(int i = 0; i < word.length(); i++) {
			if((int)word.charAt(i) < 65 || (int)word.charAt(i) > 90) {  // test that all characters in string are letters
				return false;
			}
		}
		
		return true;
	}
	
	private int findBalance() {		
		for(int i = 0; i < word.length(); i++) {
			String left = word.substring(0, i);
			String right = word.substring(i + 1, word.length());
			
			int lWeight = getWeight(left);
			int rWeight = getWeight(right);
			
			if (lWeight == rWeight) {  // word is balanced.  return balance char index
				balanceWeight = rWeight;
				return i;
			}
			
			if (lWeight > rWeight) break;  // word cannot be balanced
		}
		
		return -1;
	}
	
	private void display(int balancePosition) {
		if(balancePosition == -1) {
			System.out.println("Word cannot be balanced.");
			return;
		}

		String left = word.substring(0, balancePosition);
		char balance = word.charAt(balancePosition);
		String right = word.substring(balancePosition + 1);
		
		System.out.printf("%s %s %s - %d%n", left, balance, right, balanceWeight);
	}
	
	private int getWeight(String s) {
		int weight = 0;
		for(int i = 0; i < s.length(); i++) {
			weight += (i + 1) * ((int)s.charAt(i) - 64);
		}
		return weight;
	}
}
