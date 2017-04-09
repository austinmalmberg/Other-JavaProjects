package poker;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class InputHelper {
	public InputHelper() {
	}
	
	public int getInt(String prompt, String error, int min, int max) {
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		int i;
		
		do {
			try {
				System.out.print(prompt);
				System.out.flush();
				i = Integer.parseInt(sc.readLine());
				if (i >= min && i <= max) {
					return i;	
				}
			} catch (Exception e) {
				System.out.println(error);
			}
		} while (true);
	}
	
	public String getString(String prompt, String error, int min, int max) {
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		String s;
		
		do {
			try {
				System.out.print(prompt);
				System.out.flush();
				s = sc.readLine();
				if (s.length() >= min && s.length() <= max) {
					return s;	
				}
			} catch (Exception e) {
				System.out.println(error);
			}
		} while (true);
	}
}
