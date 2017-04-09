package com.lynda.olivepress.olives;

public class Olive {
	private String name;
	private long color;
	
	public Olive(String name, long color) {
		this.name = name;
		this.color = color;
	}
	
	public String toString() {
		return "name: " + this.name + ": color: " + this.color;
	}
}
