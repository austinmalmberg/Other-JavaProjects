package com.austin.examreview;

import java.util.List;

public class Search {

	public Search() { }
	
	/* LISTS */
	
	public <T extends Comparable<T>> int binarySearch(List<T> list, int start, int end, T val) {
		// element does not exist within list
		if(start >= end) return -1;		
		
		int mid = start + (end - start) / 2;
		
		if(list.get(mid).compareTo(val) == 0)
			return mid;
		
		// if the search value is less than the value of mid then search from start to mid
		else if(val.compareTo(list.get(mid)) < 0)
			return binarySearch(list, start, mid, val);
		
		return binarySearch(list, mid+1, end, val);
	}
	
	/* ARRAYS */
	
	public <T> int linearSearch(T[] arr, int size, T val) {
		
		for(int i = 0; i < size; i++) {
			
			if(arr[i].equals(val)) return i;
		}
		
		return -1;
	}
	
	public <T extends Comparable<T>> int binarySearch(T[] arr, int start, int end, T val) {
		
		if(start >= end) return -1;
		
		int mid = start + (end - start) / 2;
		
		if(arr[mid].compareTo(val) == 0)
			return mid;
		
		else if(val.compareTo(arr[mid]) < 0)
			return binarySearch(arr, start, mid, val);			
		
		return binarySearch(arr, mid+1, end, val);
	}
}
