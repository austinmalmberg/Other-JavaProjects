package com.austin.examreview;

import java.util.List;

public class Sort {

	public Sort() { }
	
	/* LISTS */
	
	public <T extends Comparable<T>> void quickSort(List<T> list, int start, int end) {
		if(start < end) {
			int index = partition(list, start, end);
			quickSort(list, start, index-1);
			quickSort(list, index+1, end);
		}
	}
	
	public <T extends Comparable<T>> int partition(List<T> list, int start, int end) {
		
		T pivot = list.get(end);
		
		int index = start;
		for(int i = start; i < end; i++) {
			if(list.get(i).compareTo(pivot) <= 0) {
				swap(list, i, index);
				index++;
			}
		}
		
		swap(list, index, end);
		return index;
	}
	
	public <T> void swap(List<T> list, int i, int j) {
		if(i != j) {
			T temp = list.get(i);
			list.set(i, list.get(j));
			list.set(j, temp);
		}
	}
	
	/* ARRAYS */
	
	public <T> void bubbleSort(T[] arr) {
		
	}
	
	public <T> void insertionSort(T[] arr) {
		
	}
	
	public <T extends Comparable<T>> void quickSort(T[] arr, int min, int max) {
		if(min < max) {
			int index = partition(arr, min, max);
			quickSort(arr, min, index-1);
			quickSort(arr, index+1, max);
		}
	}
	
	public <T extends Comparable<T>> int partition(T[] arr, int min, int max) {
		
		T pivot = arr[max];
		
		int index = min;
		for(int i = min; i < max; i++) {
			if(arr[i].compareTo(pivot) <= 0) {
				swap(arr, i, index);
				index++;
			}
		}
		
		swap(arr, index, max);
		return index;
	}
	
	/**
	 * Starts at beginning of array and swaps it's position with the smallest arr object.
	 * 
	 * @param arr
	 */
	public <T extends Comparable<T>> void selectionSort(T[] arr) {
		
		int min;
		
		for(int i = 0; i < arr.length-1; i++) {
			
			min = i;
			for(int scan = i+1; scan < arr.length; scan++) {
				
				if(arr[scan].compareTo(arr[min]) < 0)
					min = scan;
			}
			swap(arr, min, i);
		}
	}
	
	private <T> void swap(T[] arr, int i, int j) {		
		if(i != j) {			
			T temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
	}
}
