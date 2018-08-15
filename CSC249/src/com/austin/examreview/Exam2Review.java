package com.austin.examreview;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * EXAM WILL BE
 * QuickSort a list and then binary search it
 * 
 * @author Austin Malmberg
 *
 */
public class Exam2Review {

	public static void main(String[] args) {
		
		Search search = new Search();
		Sort sort = new Sort();
		
		Integer[] repeat = {5, 9, 4, 1, 2, 3, 5, 7, 9, 5, 4};
		Integer[] distinct = {10, 80, 30, 90, 40, 50, 70};
		int find = 9;
		
		Integer[] arr = repeat.clone();
		print(arr);		// unsorted
		
		
		
		System.out.println("\n-------ARRAY-------");
		
		sort.quickSort(arr, 0, arr.length-1);
		print(arr);
				
		System.out.printf("Index of %d: %d%n", find, search.binarySearch(arr, 0, arr.length, find));
		
		
		
		System.out.println("\n-------LIST-------");
		
		List<Integer> list = Stream.of(arr).mapToInt(i -> i).boxed().collect(Collectors.toList());
		sort.quickSort(list, 0, list.size()-1);
		print(list);
		
		System.out.printf("Index of %d: %d%n", find, search.binarySearch(list, 0, list.size(), Integer.valueOf(find)));
	}
	
	public static <T> void print(T[] arr) {
		System.out.println(Arrays.toString(arr));
	}
	
	public static <T> void print(List<T> list) {
		System.out.println(list.toString());
	}
}
