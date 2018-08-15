/**
 * Description
 * 
 * Given an integer, find the next largest integer using ONLY the digits from the given integer.
 * 
 * @author Austin Malmberg
 *
 */
public class Main {
	public static void main(String[] args) {
		NextLargest nl = new NextLargest();
		System.out.println(nl.findNextLargest(23));
	}
}

class NextLargest {
	
	public NextLargest() { }
	
	public int findNextLargest(int i) {
		char[] arr = String.valueOf(i).toCharArray();
		
		int min = getMin(arr);
		int max = getMax(arr);
		
		// single digit number returns itself
		if(arr.length == 1) return i;
		
		for(int j = 0; j < arr.length; j++) {
			
		}
	}
	
	private int getMin(char[] arr) {
		int min = 9;
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] < min) min = arr[i];
		}
		
		return min;
	}
	
	private int getMax(char[] arr) {
		int max = 0;
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] > max) max = arr[i];
		}
		
		return max;
	}
}
