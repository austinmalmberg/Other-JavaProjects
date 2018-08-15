package com.austin.challenge348;

import java.util.Arrays;

public class TheRabbitProblem_v2 {

	public static void main(String[] args) {
		
		long target = 15000000000L;
		
		long[] starting_males = {0, 0, 2};
		long[] starting_females = {0, 0, 4};
		
		Month month = new Month(1, starting_males, starting_females);
		while(month.population_sum() < target) {
			month = new Month(month.getMonth()+1, month.getMales(), month.getFemales());
		}
		
		System.out.println("Month: " + month.getMonth() + "    Died: " + month.getDead());
	}

}

class Month {
	
	private final int MAX_AGE = 96;
	private final int MATURITY = 4;
	
	private int month;
	private long[] males;
	private long[] females;
	
	public Month(int month, long[] males, long[] females) {
		this.month = month;
		
		this.males = new long[males.length+1];
		this.females = new long[females.length+1];
		
		System.arraycopy(males, 0, this.males, 1, males.length);
		System.arraycopy(females, 0, this.females, 1, males.length); 
		
		long mature_females = Arrays.stream(females).limit(MAX_AGE).skip(MATURITY).sum();
		this.males[0] = mature_females * 5;
		this.females[0] = mature_females * 9;
		
		System.out.printf("%d: %,d%n", getMonth(), population_sum());
	}
	
	public long population_sum() {
		return Arrays.stream(males).sum() + Arrays.stream(females).sum();
	}
	
	public int getMonth() { return month; }
	public long getDead() { return Arrays.stream(males).skip(MAX_AGE).sum() + Arrays.stream(females).skip(MAX_AGE).sum(); }
	public long[] getMales() { return males; }
	public long[] getFemales() { return females; }
}
