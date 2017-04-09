package ap;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * This class contains methods that error check and return specific data.
 * 
 * @author Austin Malmberg
 *
 */
public class InputHelper {
	
	public InputHelper() {}
	
	/**
	 * 
	 * @param prompt The message presented to the user to get the data.
	 * @param min The minimum integer value that can be returned by this method.
	 * @param max The maximum integer value that can be returned by this method.  Set as 0 for no maximum value.
	 * @return An int value.
	 */
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
	
	/**
	 * 
	 * @param prompt The message presented to the user to get the data.
	 * @param min The minimum integer value that can be returned by this method.
	 * @param max The maximum integer value that can be returned by this method.  Set as 0 for no maximum value.
	 * @return A double value.
	 */
	public double getDouble(String prompt, double min, double max) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		double d;
		
		do {
			try {
				System.out.print(prompt);
				System.out.flush();
				d = Double.parseDouble(br.readLine());				
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
				System.out.println("Invalid entry.");
			}
		} while (true);
	}
	
	/**
	 * 
	 * @param prompt The message presented to the user to get the data.
	 * @return A string value.
	 */
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
	
	/**
	 * 
	 * @param prompt The message presented to the user to get the data.
	 * @return A string value in the format mm/dd/yy
	 */
	public String getDate(String prompt) {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		
		while (true) {
			System.out.print(prompt);
			System.out.flush();
			
			try {
				s = br.readLine().trim();
				if (validDate(s)) {
					return s;
				} else {
					System.out.println("Invalid date.");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private boolean validDate(String s) {		
		java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("mm/dd/yy");
		dateFormat.setLenient(false);
		
		try {
			dateFormat.parse(s);
		} catch (java.text.ParseException pe) {
			return false;
		}
		
		return true;
	}
}
