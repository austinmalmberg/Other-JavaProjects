import java.util.Arrays;

public class SortTrace {

	static final Integer[] ARR = {90, 8, 70, 56, 123, 235, 9, 1, 653}; 
	
	public static void main(String[] args) {
		
		System.out.println("---SELECTION SORT---");
		selectionSort(new Integer[]{5, 3, 9, 5});
		
		System.out.println("---INSERTION SORT---");
		insertionSort(ARR.clone());
		
		System.out.println("---BUBBLE SORT---");
		bubbleSort(ARR.clone());
	}
	
	public static <T extends Comparable<T>> void selectionSort(T[] data) {
		int min;
		T temp;
		
		for(int index = 0; index< data.length-1; index++) {
			
			min = index;
			
			for(int scan = index+1; scan < data.length; scan++) {
				
				if(data[scan].compareTo(data[min]) < 0) {
					min = scan;
				}
			}
			
			printTrace(data, min, index);
			
			// swap
			temp = data[min];
			data[min] = data[index];
			data[index] = temp;
			
		}

		System.out.println(Arrays.toString(data));
	}
	
	public static <T extends Comparable<T>> void insertionSort(T[] data) {
		
		for(int index = 1; index < data.length; index++) {
			
			T key = data[index];
			int position = index;
			
			while (position > 0 && data[position-1].compareTo(key) > 0) {
				
				printTrace(data, position-1, position);
				
				data[position] = data[position-1];
				position--;
			}
			
			printTrace(data, position, index);
			
			data[position] = key;
		}
		
		
		System.out.println(Arrays.toString(data));
	}
	
	public static <T extends Comparable<T>> void bubbleSort(T[] data) {
		int position, scan;
		T temp;
		
		for(position = data.length-1; position >= 0; position--) {
			
			for(scan = 0; scan < position; scan++) {
				
				if(data[scan].compareTo(data[scan+1]) > 0) {
					
					printTrace(data, scan+1, scan);
					
					// swap
					temp = data[scan];
					data[scan] = data[scan+1];
					data[scan+1] = temp;
				}
			}
		}
		
		System.out.println(Arrays.toString(data));
	}
	
	public static <T> void printTrace(T[] data, int index1, int index2) {
		if(index1 == index2) {
			System.out.println("--unchanged");
			return;
		}
		
		System.out.printf("Swapped: %3d <=> %3d    First value: %3d%n", data[index1], data[index2], data[0]);
	}
}
