package com.austin.challenge349i;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Boxes {

	List<Integer> boxes;
	
	public Boxes() {
		this.boxes = new ArrayList<>();
	}
	
	public Boxes(Integer...values) {
		this.boxes = Arrays.asList(values);
	}
	
	public Boxes(List<Integer> boxes) {
		this.boxes = boxes;
	}
	
	public void add(List<Integer> list) {
		
	}
	
	public int sum() {
		return boxes.stream().mapToInt(Integer::valueOf).sum();
	}
}
