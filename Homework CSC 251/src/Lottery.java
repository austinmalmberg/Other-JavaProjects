import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lottery {
	public static void main(String [] args) {
		int numNumbers = 5;
		int maxNumber = 50;
		
		int[] winningNumbers = getWinningNumbers(numNumbers, maxNumber);
		System.out.println(Arrays.toString(winningNumbers));
		
		int[] userNumbers = getUserNumbers(winningNumbers.length, maxNumber);
		System.out.println(Arrays.toString(userNumbers));
		
		countWinningNumbers(winningNumbers, userNumbers);
	}
	
	public static void countWinningNumbers(int[] winningNumbers, int[] userNumbers) {
		int count = 0;
		int[] winners = new int[winningNumbers.length];
		
		for (int i = 0; i < userNumbers.length; i++) {
			for (int j = 0; j < winningNumbers.length; j++) {
				if (userNumbers[i] == winningNumbers[j]) {
					winners[count] = userNumbers[i];
					count++;
					break;
				}
			}
		}
		
		if (count == winningNumbers.length) {
			System.out.println("You are the Grand Prize Winner!!!");
		} else {
			System.out.print("You got " + count + " correct numbers.");
			for (int i = 0; i < count; i++) {
				
			}
			System.out.println("]");
		}
	}
	
	public static int[] getWinningNumbers(int arrayLength, int max) {
		Random rnd = new Random();  // create a variable for the Random object
		
		int[] numbers = new int[arrayLength];  // create number array to store 5 numbers
		int rndNumber;
		
		for (int i = 0; i < numbers.length; i++) {  
			do {
				rndNumber = rnd.nextInt(max) + 1;  // continue to get a random number until it's not a duplicate
			} while (isDuplicate(numbers, rndNumber));
			numbers[i] = rndNumber;  // assign number (1 through max) to each index of the array
		}
		
		return numbers;
	}
	
	public static int[] getUserNumbers(int arrayLength, int max) {
		int[] numbers = new int[arrayLength];
		int userNumber;
		
		for (int i = 0; i < numbers.length; i++) {
			do {
				userNumber = getInt("\nEnter number " + (i + 1) + " (must be between 1 and " + max + "):  ", 1, max);
				if (isDuplicate(numbers, userNumber)) {  // if the number is a duplicate, print message
					System.out.println("You already input that number.");
				} else {						// if the number is not a duplicate
					numbers[i] = userNumber;	// assign the number to the array
					break;						// and break out of the do...while loop
				}
			} while (true);
		}
		
		return numbers;
	}
	
	public static boolean isDuplicate(int[] numbers, int n) {
		for (int i = 0; i < numbers.length; i++) {
			if (n == numbers[i]) {  // return true if the number already exists in the array 
				return true;
			}
		}
		
		return false;
	}
	
	public static int getInt(String prompt, int min, int max) {
		Scanner sc = new Scanner(System.in);
		
		int n;
		
		do {			
			System.out.print(prompt);  // prompt for input
			System.out.flush();
			
			try {
				n = Integer.parseInt(sc.nextLine());  // try to get an integer value
				if (n >= min && n <= max) {  // check to see if between min and max
					return n;
				} else {
					System.out.println("Input must be between " + min + " and " + max + ".");
				}
			} catch (Exception e){
				System.out.println("Input is not an integer.");
			}
			
		} while (true);  // infinite loop
	}
}
