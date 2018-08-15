package com.austin.challenge350e;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BookshelfProblem {

	int[] shelves;
	List<Book> books;
	
	public BookshelfProblem(String[] file) {
		shelves = Stream.of(file[0].split("\\s+")).mapToInt(str -> Integer.parseInt(str)).toArray();
		
		books = Stream.of(file).skip(1)					// string in format : 80 A Book
				.map(str -> str.split("\\s+", 2))		// string[] in format : {"80", "A Book"}
				.map(arr -> new Book(Integer.parseInt(arr[0]), arr[1]))			// book
				.collect(Collectors.toList());
		
		System.out.println(books.toString());
	}
	
	public void minimumShelves() {
		if(IntStream.of(shelves).max().getAsInt() < books.stream().mapToInt(book -> book.getWidth()).max().getAsInt())
			System.out.println("Impossible.");
		
		
		
	}
}
