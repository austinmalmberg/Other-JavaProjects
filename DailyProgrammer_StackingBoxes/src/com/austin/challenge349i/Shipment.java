package com.austin.challenge349i;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Shipment {

	private int maxHeight;
	private ArrayDeque<Integer> boxHeights;
	
	private List<ArrayDeque<Integer>> stacks;
	
	private boolean canBeEqualized;
	
	private Map<Integer, List<List<Integer>>> buildMap; 
	
	public Shipment(int numStacks, List<Integer> boxHeights) {		
		this.maxHeight = boxHeights.stream().mapToInt(Integer::valueOf).sum() / numStacks;
		this.boxHeights = boxHeights.stream().collect(Collectors.toCollection(ArrayDeque::new));
		
		canBeEqualized = boxHeights.stream().mapToInt(Integer::valueOf).sum() % numStacks == 0;
		
		buildMap = new HashMap<>();
//		buildMap(maxHeight, boxHeights);
		
		stacks = new ArrayList<>();
	}
	
	public void equalize(ArrayDeque<Integer> workingStack, ArrayDeque<Integer> remainingBoxes) {
		
//		if( sumOf(workingStack) == maxHeight )
//			equalize( new ArrayDeque<Integer>(), difference( boxHeights, stacksAsArrayDeque() ) );
		
		for(Integer box : remainingBoxes) {
			

		}
		
		System.out.println(buildMap);
	}
	
	private void findMatches(Map<Integer, List<List<Integer>>> buildMap) {
		
		for(Map.Entry<Integer, List<List<Integer>>> e : buildMap.entrySet()) {
			// see if the map contains entries equal to maxHeight - e.getKey()
			
				// combine entries IF
				// both lists combine are in remaining boxes
				// e.getKey contains at least two entries if maxHeight = e.getKey * 2
				
			}
		}
		
	}
	
	public void addToMap(List<Integer> list) {
		int key = sumOf(list);
		
		if(!buildMap.containsKey( key )) {
			List<List<Integer>> temp = new ArrayList<>();
			temp.add(list);
			buildMap.put(key, temp);
		} else {
			buildMap.get(key).add(list);
		}
		
	}
	
	public void printEqualStacks() {
		if(!canBeEqualized) {
			System.out.println("( nothing )");
			return;
		}
		
		equalize(new ArrayDeque<Integer>(), boxHeights);
	}
	
	/**
	 * Returns a new list equivalent to A - B.  This method removes one occurrence from A for each integer of B.
	 * Does not remove anything if an integer exists in B but not A.
	 * 
	 * @param a
	 * @param b
	 * @return
	 */	
	private ArrayDeque<Integer> difference(ArrayDeque<Integer> a, ArrayDeque<Integer> b) {
		
		ArrayDeque<Integer> a1 = new ArrayDeque<Integer>(a);
		for(Integer i : b) {
			a1.remove(i);
		}
		return a1;
	}
	
	private int sumOf(ArrayDeque<Integer> ints) {
		return ints.stream().mapToInt(Integer::valueOf).sum();
	}
	
	private int sumOf(List<Integer> ints) {
		return ints.stream().mapToInt(Integer::valueOf).sum();
	}
	
	private ArrayDeque<Integer> stacksAsArrayDeque() {
		return stacks.stream().flatMap(x -> x.stream()).collect(Collectors.toCollection(ArrayDeque::new));
	}
	
}
