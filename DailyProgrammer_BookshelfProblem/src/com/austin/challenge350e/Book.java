package com.austin.challenge350e;

public class Book {
	
	private int width;
	private String title;
	
	public Book(int width, String title) {
		this.width = width;
		this.title = title;
	}
	
	public int getWidth() { return width; }
	public String getTitle() { return title; }
	
	public String toString() {
		return width + " " + title;
	}
}
