package com.austin.challenge.i243;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		ArrayList<Fruit> fruits = new ArrayList<>();
		
		fruits.add(new Fruit("banana", 32));
		fruits.add(new Fruit("kiwi", 41));
		fruits.add(new Fruit("mango", 97));
		fruits.add(new Fruit("papaya", 254));
		fruits.add(new Fruit("pineapple", 399));
		
		new FruitBasket(500, fruits);
	}
}
