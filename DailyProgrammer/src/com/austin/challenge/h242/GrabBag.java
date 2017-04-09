package com.austin.challenge.h242;

import java.util.ArrayList;
import java.util.Collections;

public class GrabBag {
	
	ArrayList<Tile> bag;
	
	public GrabBag() {
		bag = new ArrayList<>();
		
		// add tiles to arraylist
		for(Color c : Color.values()) {
			for(Number n : Number.values()) {
				bag.add(new Tile(c, n));
			}
		}
		
		Collections.shuffle(bag);
	}
	
	public Tile getTile() throws EmptyBagException {
		if(bag.isEmpty()) throw new EmptyBagException();
		
		return bag.remove(0);
	}
	
	public Tile getTile(Color c, Number n) throws NoMatchException {
		for(int i = 0; i < bag.size(); i++) {
			if(bag.get(i).equals(c) && bag.get(i).equals(n)) return bag.remove(i);
		}
		
		throw new NoMatchException(new Tile(c, n));
	}
	
	public String toString() {
		return bag.toString();
	}
}

@SuppressWarnings("serial")
class EmptyBagException extends Exception {
	
	public EmptyBagException() {
		System.out.println("There are no more remaining tiles.");
	}
}

@SuppressWarnings("serial")
class NoMatchException extends Exception {
	
	public NoMatchException(Tile t) {
		System.out.println("Grab Bag does not contain a(n) " + t.toString());
	}
}


