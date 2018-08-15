package com.austin.challenge354e;

/**
 * https://www.reddit.com/r/dailyprogrammer/comments/83uvey/20180312_challenge_354_easy_integer_complexity_1/
 * 
 * @author mac9812e
 * @date 3/16/2018
 */
public class IntegerComplexity {
	
	public static void main(String[] args) {
		
		/**
		 * given 100 ->
		 * 
		 * 1 * 100 -> 1 + 100 = 101
		 * 2 * 50  -> 2 + 50  = 52
		 * 4 * 25  -> 4 + 25  = 29
		 * 5 * 20  -> 5 + 20  = 25
		 * 10 * 10 -> 10 + 10 = 20
		 * 
		 * Conclusion, sum is lowest at the sqaure root.
		 *
		 * 
		 * given 100 -> prime factorization = 2*2*5*5
		 * given 456 -> pf = 2*2*2*3*19
		 * given 12345 -> pf = 3*5*823
		 * given 1234567891011 -> pf = 3*7*13 4522226707
		 * 
		 * given 1234567891011 -> pf = 652379 (7*13*67*107) + 1892409 ()
		 */
		
		
		
		long[] input = {
				12,
				456,
				4567,
				12345,
				1234567891011L
		};
		
		for(long l : input) {
			long start = System.currentTimeMillis();
			long[] ans = find(l);
			System.out.printf("%d -> %d -> %d + %d (time %d)%n", l, ans[0] + ans[1], ans[0], ans[1], System.currentTimeMillis() - start);
		}
	}
	
	public static long[] find(long in) {
		
		for(long l = (long) Math.sqrt(in); l > 1; l--) {
			if(in % l == 0) return new long[] {l, in / l};
		}
		
		return new long[] {in, 1};
	}
}
