package HandsOn;

public class Chapter2 {
	public static void main(String[] args) {
		long[] vars = {1, 2, 3, 10000, 100000, 1000000};
		
		for(long v : vars) {
			print(v);
		}
	}
	
	public static long f1(long n) {
		return (long)(Math.pow(n, 2) + 9 * n + 5);
	}
	
	public static long f2(long n) {
		return (long)(5 * Math.pow(n, 2));
	}
	
	public static void print(long n) {
		System.out.printf("%10d%20d%20d%n", n, f1(n), f2(n));
	}
}
