package com.austin.challenge.e242;

import java.util.ArrayList;

/**
 * Scientist have discovered a new plant. The fruit of the plant can feed 1 person for a whole week and best of all,
 * the plant never dies. Fruits needs 1 week to grow, so each week you can harvest its fruit. Also the plant gives
 * 1 fruit more than the week before and to get more plants you need to plant a fruit.
 * 
 * Now you need to calculate after how many weeks, you can support a group of x people, given y fruits to start with.
 * 
 * @author Austin Malmberg
 *
 */
public class FunnyPlant {
	static ArrayList<Plant> plants;
	
	public static void main(String[] args) {
		plants = new ArrayList<>();
		
		beginSim(200, 15);
		beginSim(50000, 1);
		beginSim(150000, 250);
	}
	
	public static void beginSim(int people, int startingFruit) {
		plants.clear();
		
		int weeks = 0;
		while (plants.size() < people) {
			weeks++;
			
			growPlants();
			
			int fruit = collectFruit();
			
			addPlants(weeks > 1 ? fruit : startingFruit);
			System.out.printf("Week %d -- Plants: %d  Fruit: %d%n", weeks, plants.size(), fruit);
		}
		
		System.out.printf("%d people sustained off Funny Fruit after %d weeks.%n%n", people, weeks);
	}
	
	public static void addPlants(int additionalPlants) {
		for(int i = 0; i < additionalPlants; i++) {
			plants.add(new Plant());
		}
	}
	
	public static int collectFruit() {
		int fruit = 0;
		
		for(int i = 0; i < plants.size(); i++) {
			fruit += plants.get(i).collectFruit(i);
			
//			System.out.printf("Index: %d -- Fruits: %d%n", i, plants.get(i).collectFruit());
		}
		
		return fruit;
	}
	
	public static void growPlants() {
		for(Plant plant : plants) {
			plant.grow();
		}
	}
}

class Plant {
	
	int fruit;
	
	public Plant() {
		fruit = 0;
	}
	
	public int collectFruit(int i) {
		return fruit;
	}
	
	public void grow() {
		fruit++;
	}
}
