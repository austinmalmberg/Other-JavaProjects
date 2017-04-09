import java.util.Arrays;


public class Main {
	public static void main(String[] args) {
		int unsorted[] = {98, 43, 102, 23, 21, 6, 87, 44};
		sort(unsorted);
	}
	
	public static void sort(int[] unsorted) {
		System.out.println("Array before sorting:  " + Arrays.toString(unsorted));
		
		int temp;
		for (int i = 0; i < unsorted.length; i++) {
			for (int j = 1; j < unsorted.length; j++) {
				if (unsorted[j-1] > unsorted[j]) {
					temp = unsorted[j-1];
					unsorted[j-1] = unsorted[j];
					unsorted[j] = temp;
				}
				System.out.println(Arrays.toString(unsorted));
			}
			
//			if (condition) {
//				
//			}
		}

		System.out.println("Final sorted array:  " + Arrays.toString(unsorted));
	}
}
