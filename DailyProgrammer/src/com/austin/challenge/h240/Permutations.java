package com.austin.challenge.h240;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Permutations {

	ArrayList<Integer[]> permutations;
	
	public Permutations() { }
	
	public Permutations(int[] nums) {
		permutations = new ArrayList<>();
		
		// return every possible combination of numbers in the array
		Set<Integer> s = new HashSet<>();		
		for(int i : nums) {
			s.add(i);
		}
		
		permutate(s, new Stack<Integer>(), s.size());
	}
	
	public Integer[] get(int index) { return permutations.get(index); }
	public ArrayList<Integer[]> getAll() { return permutations; }
	public int getSize() { return permutations.size(); }
	
	private void permutate(Set<Integer> items, Stack<Integer> permutation, int size) {

	    if(permutation.size() == size) {
	        // add permutation to arraylist
	        permutations.add(permutation.toArray(new Integer[0]));
	    }

	    // items available for permutation
	    // duplicate items set to avoid concurrent modification exception
	    Integer[] availableItems = items.toArray(new Integer[0]);
	    for(Integer i : availableItems) {
	        // add current item
	        permutation.push(i);

	        // remove item from available item set
	        items.remove(i);

	        // pass it on for next permutation
	        permutate(items, permutation, size);

	        // pop and put the removed item back
	        items.add(permutation.pop());
	    }
	}
}
