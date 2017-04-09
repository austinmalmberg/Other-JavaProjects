package com.austin.challenge.i243;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * This program *should* take a list of fruits and, by adding up different quantities of fruit and their costs, find all possible combinations
 * to exactly equal the WALLET.
 * 
 * This is done by finding the cost of each fruit in a percentage of the WALLET and adding up these costs until it equals 1 (100%).
 * 
 * @author Austin Malmberg
 *
 */
class FruitBasket {
	private int wallet;
	
	private ArrayList<Fruit> fruits;
	private ArrayList<Combination> combinations;
	
	public FruitBasket(int wallet, ArrayList<Fruit> fruitList) {
		this.wallet = wallet;
		
		fruits = fruitList;
		
		combinations = new ArrayList<>();
		
		getCombos(0);
		
		displayCombinations();
	}
	
	public void getCombos(int index) {
		if(index == fruits.size()) return;
		
		for (int i = 0; i < fruits.size(); i++) {
			System.out.println("New combo...");
			find(new Combination(wallet), i);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void find(Combination c, int index) {
		int i = index; 
		
		if(i > fruits.size() - 1) return;
		
		for(int j = i; j < fruits.size(); j++) {
			System.out.println(c.toString());
			
			Fruit f = fruits.get(j);
			System.out.println(f.toString());
			
			if(f.getMax(c.getRemaining()) > 0)
				c.put(f, f.getMax(c.getRemaining()));	// if money still remains, buy as many of the next fruit as possible
			
			if(c.getTotal() == wallet)
				combinations.add(c);	// add to possible combinations
				
			find(c, ++i);	// move to next element and try to add it to combo
			
			// removes entry if 0 or less.  otherwise, decreases its value
			if(c.get(f) - 1 > 0) {
				c.put(f, c.get(f) - 1);
				System.out.println("subtracting 1 from " + c.get(f));
			} else {
				c.remove(f);
				System.out.println("removing " + c.get(f));
			}
		}
	}
	
	public void displayCombinations() {		
		// arraylist of combos
		combinations.forEach(entry -> {
			
			// print each combo (i.e. 2 bananas(32)  4 apples(45)...)
			entry.forEach((f, i) -> System.out.printf("%d %s  ", i, f.toString()));
			
			System.out.println();
		});
	}
}

@SuppressWarnings("serial")
class Combination extends HashMap<Fruit, Integer> {
	
	private int wallet; 
	
	public Combination(int wallet) {
		super();
		
		this.wallet = wallet;
	}
	
	public int getTotal() {
		return entrySet().stream().mapToInt(e -> e.getKey().getTotalPrice(e.getValue())).sum();
	}
	
	public int getRemaining() {
		return wallet - getTotal();
	}
}

class Fruit {
	private String name;
	private int price;
	private int max;
	
	public Fruit(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	public int getTotalPrice(int quantity) { return price * quantity; }
	
	public int getMax(int change) { return change / price; }
	
	public String toString() { return name + "(" + price + ")"; }
}
