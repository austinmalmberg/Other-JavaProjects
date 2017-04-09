
public class Main {

	public static void main(String[] args) {
		int monthNumber = 1;
		
		if (monthNumber >= 1 && monthNumber <= 3) {
			System.out.println("You're in Quarter 1.");
		} else if (monthNumber >= 4 && monthNumber <= 6) {
			System.out.println("You're in Quarter 2.");
		} else {
			System.out.println("You aren't in the first half of the year!");
		}
	}

}
