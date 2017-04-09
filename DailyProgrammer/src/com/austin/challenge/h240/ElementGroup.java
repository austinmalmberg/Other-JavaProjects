package com.austin.challenge.h240;

import java.awt.Point;
import java.util.ArrayList;

/**
 * Stores elements in a group.  ElementGroups can be permutated
 * 
 * @author Austin Malmberg
 *
 */
public class ElementGroup {

	ArrayList<Element> elements;
	Permutations permutations;	// generate all possible combination of element values
	
	public ElementGroup(int[] nums) {
		elements = new ArrayList<>();
		permutations = new Permutations(nums);
	}
	
	public ArrayList<Element> getElements() {
		return elements;
	}
}

class Element {
	
	private Point point;
	private int value;
	
	public Element(Point point, int value) {
		this.point = point;
		this.value = value;
	}
	
	public int getX() { return point.x; }
	public int getY() { return point.y; }
	public int getValue() { return value; }
	
	public void setValue(int value) { this.value = value; }
}
