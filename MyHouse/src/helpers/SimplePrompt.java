package helpers;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SimplePrompt {
	public String getInput(String prompt) {
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print(prompt);
		System.out.flush();
		
		try {
			return sc.readLine();
		} catch (Exception e) {
			return "Error: " + e.getMessage();
		}
	}
}

