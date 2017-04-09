import java.util.HashMap;
import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("How many fractions? ");
		int numFractions = sc.nextInt();
		
		String[] fractions = new String[numFractions - 1];
		
		for(int i = 0; i < fractions.length; i++) {
			fractions[i] = sc.nextLine();
		}
		
		addFractions(fractions);
	}
	
	public static void addFractions(String[] fractions) {
		HashMap<Integer, Integer> fractionMap = new HashMap<>();
		
		for(int i = 0; i < fractions.length; i++) {
			
		}
	}
}
