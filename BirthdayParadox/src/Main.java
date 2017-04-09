
public class Main {

	public static void main(String[] args) {
		int people = 5;
		double probability = 1 - (Math.pow(364/365, people));
		
		System.out.println(probability);
	}

	public static long getFactorial(double d) {
		long factorial = 1;
		
		// 5 * 4 * 3 * 2 * 1 = 120
		
		for (int n = 2; n <= d; n++) {
			factorial*=(n);
		}
		
		return factorial;
	}
}
