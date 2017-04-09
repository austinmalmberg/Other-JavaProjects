package helpers;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InputHelper {
	public int getInt(String prompt, int min, int max) {
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		boolean test = true;
		int i = 0;
		
		do {
			try {
				System.out.print(prompt + "  ");
				System.out.flush();
				i = Integer.parseInt(sc.readLine());
				if (i >= min && i <= max) {
					return i;	
				} else {
					System.out.println("That is not a valid choice.");
				}
			} catch (Exception e) {
				System.out.println("Not a valid option.");
			}
		} while (test);
		
		return i; //never called
	}
}
