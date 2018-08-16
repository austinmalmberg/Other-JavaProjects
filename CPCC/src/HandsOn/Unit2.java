package HandsOn;

import java.util.Scanner;

public class Unit2 {
	public static void main(String[] args) {
		Account account = new Account();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter your 7 digit account number: ");
		String test = sc.nextLine();
		System.out.println(account.isValid(test) ? "Welcome..." : "Invalid account number.  Goodbye!");
		
		sc.close();
	}
	

}

class Account {
	
	private final String[] validAccounts = {"5658845", "4520125", "7895122", "8777541", "8451277",
			"1302850", "8080152", "4562555", "5552012", "5050552", "7825877", "1250255", "10052310",
			"6545231", "3852085", "7576651", "7881200", "4581002"};
	
	public Account() { }
	
	public boolean isValid(String test) {
		
		for(String acct : validAccounts) {
			if(test.equals(acct))
				return true;
		}
		
		return false;
	}
}
