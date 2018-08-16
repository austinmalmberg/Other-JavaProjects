package sorting;

import java.util.Arrays;

public class SortingTrace {

	public static void main(String[] args) {
		
		Integer[] data1 = {90, 8, 70, 56, 123, 235, 9, 1, 653};
		
		selectionSort(data1);
		System.out.println(Arrays.toString(data1));
		
		Integer[] data2 = {90, 8, 70, 56, 123, 235, 9, 1, 653};
		
		insertionSort(data2);
		System.out.println(Arrays.toString(data2));
		
		Integer[] data3 = {90, 8, 70, 56, 123, 235, 9, 1, 653};
		
		bubbleSort(data3);
		System.out.println(Arrays.toString(data3));
	}
	
	public static <T extends Comparable<? super T>> void selectionSort(T[] data) {
		
		int min;
		T temp;
		
		for(int index = 0; index < data.length-1; index++) {
			
			min = index;
			for(int scan = index+1; scan < data.length; scan++) {
				
				if(data[scan].compareTo(data[min]) < 0)
					min = scan;
			}
			
			temp = data[min];
			data[min] = data[index];
			data[index] = temp;

		}
	}
	
	public static <T extends Comparable<? super T>> void insertionSort(T[] data) {
		
		for(int index = 1; index < data.length; index++) {
			T key = data[index];
			int position = index;
			
			while(position > 0 && data[position-1].compareTo(key) > 0) {
				data[position] = data[position-1];
				position--;
			}
			data[position] = key;
		}
	}
	
	public static <T extends Comparable<? super T>> void bubbleSort(T[] data) {
		
		int position, scan;
		T temp;
		
		
		for(position = data.length -1; position >= 0; position--) {
			
			for(scan = 0; scan <= position - 1; scan++) {
				
				if(data[scan].compareTo(data[scan+1]) > 0) {
					temp = data[scan];
					data[scan] = data[scan+1];
					data[scan+1] = temp;
				}
			}
		}
	}
}
