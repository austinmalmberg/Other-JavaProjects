package helpers;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InputHelper {
	public int getInt(String prompt, String error, int min, int max) {
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
					System.out.println(error + "\n");
				}
			} catch (Exception e) {
				System.out.println(error + "\n");
			}
		} while (test);
		
		return i; //never called
	}
}
