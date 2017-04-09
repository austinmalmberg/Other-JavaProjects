import java.util.Random;


public class Main {
	public static void main(String[] args) {
		
		int numbers = 1000;
		int odds = 175223510;
		
		int iterations;
		int count = 0;
		do {
			iterations = lotterySimulator(odds, numbers);  // assuming you keep the same numbers
			count++;
		} while(iterations > 1);
		
		System.out.printf("With odds of 1 in %,d and by purchasing %,d tickets each drawing, it would take %,d drawings to become the big winner. (%,.2f years!)", odds, numbers, count, (double) count/52);
	}
	
	public static int lotterySimulator(int odds, int nums) {
		
		Random random = new Random();
		
		int winner;
		int count = 0;
		do {
			winner = random.nextInt(odds);
			count++;
		} while(winner >= nums);
		
		if(count == 1) {
			System.out.printf("Winner after 1 iteration. BIG WINNER! BIG WINNER! BIG WINNER!%n");
		} //  else {
//			System.out.printf("Winner after %d iterations.%n", count);
//		}
		
		return count;
	}
}
