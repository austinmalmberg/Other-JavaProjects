
public class Main {

	public static void main(String[] args) {
		int max = 2500;
		
		for (int i = 1; i < max; i++) {
			if (isPrime(i) || multipleOfThreeOrEight(i)) {
				System.out.println(i);
			}
		}
	}
	
	public static boolean isPrime(int i) {
		//checks to see if integer is prime
		if (i % 2 == 0) {
			return false;
		}
		
		//checks odd numbers up to the square root of the integer to see if it's prime
		for (int j = 3; j * j < i; j+=2) {
			if (i%j == 0) {
				return false;
			}
		}
		
		return true;
	}
	
	public static boolean multipleOfThreeOrEight(int i) {
		// checks to see if the integer is divisible by 3 AND 8
		if (i % 3 == 0 && i % 8 == 0) {
			return false;
		}
		
		// checks to see if the integer is divisible by 3 OR 8
		if (i % 3 == 0 || i % 8 == 0) {
			return true;
		}
		
		return false;
	}
}
