package com.austin.challenge.h242;

import java.util.ArrayList;

public class Rummikub {
	static GrabBag bag = new GrabBag();
	static ArrayList<Tile> hand = new ArrayList<>();
	
	public static void main(String[] args) {		

		System.out.println(bag);
		
		for(int i = 0; i < 13; i++) {
			try {
				hand.add(bag.getTile());
			} catch(EmptyBagException e) {}
		}
		
		System.out.println(hand);
	}
}
