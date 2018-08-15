package com.austin.challenge348;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

// throws OutOfMemoryError

public class TheRabbitProblem {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter inital rabbits (e.g \"males females target_population\"): ");
		String input = sc.nextLine().trim();
		
		
		try {
			int[] arr = Stream.of(input.split("\\s+")).mapToInt(Integer::parseInt).toArray();
			
			RabbitPopulation population = new RabbitPopulation(arr[0], arr[1], arr[2]);		
			population.simulate();
		} catch(NumberFormatException nfe) {
			nfe.printStackTrace();
		}
		
		sc.close();
	}
}

class RabbitPopulation {
	
	private final int STARTING_AGE = 2;
	
	private List<Rabbit> rabbits;
	
	private int target;
	
	public RabbitPopulation(int males, int females, int target) {
		rabbits = new ArrayList<>();
		
		this.target = target;
		
		addRabbits(males, false, STARTING_AGE);
		addRabbits(females, true, STARTING_AGE);
	}
	
	public void simulate() {
		
		int months = 0;
		while(rabbits.size() < target) {			
			// breed			
			int fertiles = (int) rabbits.stream().filter(r -> r.fertile).count();
			addRabbits(5 * fertiles, false);
			addRabbits(9 * fertiles, true);
			
			// age
			rabbits.forEach(Rabbit::age);
			
			// die
			rabbits = rabbits.stream().filter(r -> !r.dead).collect(Collectors.toList());
			
			months++;
			System.out.println("Month: " + months + "   " + rabbits.size());
		}
		
		System.out.println(months);		
	}
	
	private void addRabbits(int i, boolean female) {
		addRabbits(i, female, 0);
	}
	
	private void addRabbits(int i, boolean female, int age) {
//		IntStream.rangeClosed(1, i).forEach(r -> rabbits.add(new Rabbit(female, age)));
		
		rabbits.addAll(
				
				IntStream.rangeClosed(1, i).mapToObj(r -> new Rabbit(female, age)).collect(Collectors.toList())
				
				);
	}
	
	
	private class Rabbit {
		
		private final int DEATH_AGE = 96;
		private final int FERTILITY_AGE = 4;
		
		int age;	// measured in months
		boolean female;
		
		boolean newborn;
		boolean fertile;
		
		boolean dead = false;
		
		@SuppressWarnings("unused")
		public Rabbit(boolean female) {
			this.female = female;
			age = 0;
			
			newborn = true;
			fertile = false;
		}
		
		public Rabbit(boolean female, int initial_age) {
			this.female = female;
			age = initial_age;
			
			newborn = initial_age == 0;
			fertile = female && initial_age >= FERTILITY_AGE;
			dead = initial_age >= DEATH_AGE;
		}
		
		public void age() {
			if(dead) return;
			
			if(!newborn)
				age++;
			else
				newborn = false;
			
			if(age >= DEATH_AGE) {
				fertile = false;
				dead = true;
			}
			
			if(!dead && female && !fertile && age >= FERTILITY_AGE) fertile = true;
		}
	}
	
}
