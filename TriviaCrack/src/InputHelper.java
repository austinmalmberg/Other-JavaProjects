

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InputHelper {
	
	public InputHelper() {}
	
	public int getInt(String prompt, int min, int max) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int i;
		
		do {
			try {
				System.out.print(prompt);
				System.out.flush();
				i = Integer.parseInt(br.readLine());
				if (i >= min && i <= max || max == 0) {
					return i;
				} else {
					System.out.printf("This number should be between %d and %d.%n", min, max);
				}
			} catch (Exception e) {
				System.out.println("Invalid number.");
			}
		} while (true);
	}
	
	public double getDouble(String prompt, double min, double max) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		double d;
		
		do {
			try {
				System.out.print(prompt);
				System.out.flush();
				d = Integer.parseInt(br.readLine());				
				if (d >= min && (d <= max || max == 0.0)) {
					return d;
				} else {
					if (max == 0.0) {
						System.out.printf("This number should be greater than %,.2f.%n", min);
					} else {
						System.out.printf("This number should be between %.2f and %.2f.%n", min, max);
					}
				}
			} catch (Exception e) {
				System.out.println("Invalid number.");
			}
		} while (true);
	}
	
	public String getString(String prompt) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		
		do {
			try {
				System.out.print(prompt);
				System.out.flush();

				s = br.readLine().trim();
				if (!s.isEmpty()) {
					return s;
				} else {
					System.out.println("Input cannot be empty.");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} while (true);
	}
}
