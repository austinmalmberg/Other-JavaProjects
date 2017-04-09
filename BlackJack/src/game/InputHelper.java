package game;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InputHelper {
	
	public int getInt(String prompt, String error, int min, int max) {
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		int i = 0;
		
		do {
			try {
				System.out.print(prompt);
				System.out.flush();
				i = Integer.parseInt(sc.readLine());
				if (i >= min && i <= max) {
					return i;	
				} else {
					System.out.println(error);
				}
			} catch (Exception e) {
				System.out.println(error);
			}
		} while (true);
	}
	
	public String getString(String prompt, String error, int minChars, int maxChars) {
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		String s = "";
		
		do {
			try {
				System.out.print(prompt);
				System.out.flush();
				s = sc.readLine();
				if (!s.isEmpty() && s.trim().length() > minChars && s.trim().length() < maxChars) {
					return s.trim();	
				} else {
					System.out.println(error);
				}
			} catch (Exception e) {
				System.out.println(error);
			}
		} while (true);
	}
}
