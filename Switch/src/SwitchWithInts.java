import java.io.InputStreamReader;
import java.io.BufferedReader;


public class SwitchWithInts {

	public static void main(String[] args) {
		String input = getInput("Enter a number between 1 and 12: ");
		int month = Integer.parseInt(input);
		
		switch (month) {
		case 1:
			System.out.println("The month is January.");
			break;
		case 2:
			System.out.println("The month is February.");
			break;
		case 3:
			System.out.println("The month is March.");
			break;
		default:
			System.out.println("You chose the wrong month!");
			break;
		}
	}

	private static String getInput(String prompt) {
		BufferedReader sc = new BufferedReader(
				new InputStreamReader(System.in));
		
		System.out.print(prompt);
		System.out.flush();
		
		try {
			return sc.readLine();
		} catch (Exception e) {
			return "Error: " + e.getMessage();
		}
	}
}
