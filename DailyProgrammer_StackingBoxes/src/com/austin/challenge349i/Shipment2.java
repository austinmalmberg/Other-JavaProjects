package com.austin.challenge349i;

import java.util.List;

public class Shipment2 {

	private int numberOfStacks;
	private List<Integer> boxHeights;
	private int maxHeight;
	
	private boolean evenStacks;
	
	public Shipment2(int numberOfStacks, List<Integer> boxHeights) {
		this.numberOfStacks = numberOfStacks;
		this.boxHeights = boxHeights;
		
		evenStacks = sum(boxHeights) % numberOfStacks == 0;
		maxHeight = sum(boxHeights) / numberOfStacks;
	}
	
	private int sum(List<Integer> collection) {
		return collection.stream().mapToInt(Integer::valueOf).sum();
	}
}
