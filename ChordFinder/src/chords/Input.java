package chords;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Input {
	public String get(String prompt) {
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		boolean test = true;
		String str = null;
		
		do {
			try {
				System.out.print(prompt);
				System.out.flush();
				str = sc.readLine();
				if (!str.equals(null) || !str.equals("")) {
					return str;	
				} else {
					System.out.println("Invalid input.  Try again.");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} while (test);
		
		//not used
		return str;
	}
}
