package com.austin.challenge304;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Description
 * Your task is to design a program to help an accountant to get balances from accounting journals.
 * 
 * User input
 * User input has the following form
 * AAAA BBBB CCC-XX DDD-XX EEE
 * 
 * AAA is the starting account (* means first account of source file), BBB is the ending account(* means last account of source file),
 * CCC-YY is the first period (* means first period of source file), DDD-YY is the last period (* means last period of source file),
 * EEE is output format (values can be TEXT or CSV).
 * 
 * @author Austin Malmberg
 */
public class LittleAccountant {
	public static final String DATE_FORMAT = "MMM-dd";
	public static DateFormat df = new SimpleDateFormat(DATE_FORMAT);
	
	public static int startAccount;
	public static int endAccount;
	public static long startDate;
	public static long endDate;
	
	public static int debits;
	public static int credits;
	
	public static void main(String[] args) {
		df.setLenient(false);
		
		Path journalPath = new File("Journal.txt").toPath();
		Path accountPath = new File("Accounts.txt").toPath();
		
		// initialize lists
		List<List<String>> journalEntries = getStringList_noHeaders(journalPath); // [account, period, debit, credit]
		List<List<String>> accounts = getStringList_noHeaders(accountPath); // [account, label]
		
		// check that accounts balance
		debits = journalEntries.stream().mapToInt(entry -> Integer.parseInt(entry.get(2))).sum();
		credits = journalEntries.stream().mapToInt(entry -> Integer.parseInt(entry.get(3))).sum();

		checkBalances(debits, credits);
		
		Scanner sc = new Scanner(System.in);		
		String[] input;
		
		// prompt and get input
		System.out.println("Enter input [ format= \"STARTING_ACCOUNT_NUMBER  ENDING_ACCOUNT_NUMBER  START_DATE  END_DATE  OUTPUT(TEXT or CSV)\" ] : ");
		input = sc.nextLine().trim().split("[\\s]+");
		
		sc.close();
		
		// validates input before assigning variables
		validate(input);
		
		startAccount = input[0].equals("*") ? journalEntries.stream().mapToInt(entry -> Integer.parseInt(entry.get(0))).min().getAsInt() : Integer.parseInt(input[0]);
		endAccount = input[1].equals("*") ? journalEntries.stream().mapToInt(entry -> Integer.parseInt(entry.get(0))).max().getAsInt() : Integer.parseInt(input[1]);
		
		startDate =	input[2].equals("*") ? journalEntries.stream().mapToLong(entry -> getDate(entry.get(1))).min().getAsLong() : getDate(input[2]);
		endDate = input[3].equals("*") ? journalEntries.stream().mapToLong(entry -> getDate(entry.get(1))).max().getAsLong() : getDate(input[3]);
		
		// filter relevant entries
		// assumes all account numbers are numeric
		List<List<String>> filteredList = journalEntries.stream().filter(entry -> 
					Integer.parseInt(entry.get(0)) >= startAccount &&
					Integer.parseInt(entry.get(0)) <= endAccount &&
					getDate(entry.get(1)) >= startDate &&
					getDate(entry.get(1)) <= endDate)
				.collect(Collectors.toList());
		
		// format and output
		format(input[4].toLowerCase(), accounts, filteredList);		
	}
	
	private static void checkBalances(int debits, int credits) {
		// exit if debits do not equal credits
		if(debits != credits) {
			System.out.println("Accounts not balanced.");
			System.out.println("Debits: " + debits);
			System.out.println("Credits: " + credits);
			System.out.println("Total: " + (debits - credits));		
			
			System.exit(0);
		}
	}

	private static void validate(String[] input) {		
		boolean errorFlag = false;
		
		// check # arguments
		if(input.length != 5) {
			System.out.println("Input must take 5 arguments (separated by spaces).");
			System.exit(0);
		}
		
		// check valid account numbers
		if(!isValidAccount(input[0]) || !isValidAccount(input[1])) {
			System.out.println("ACCOUNT_NUMBERS must be numeric.");
			errorFlag = true;
		}
		
		// check valid date
		if(!isValidDate(input[2]) || !isValidDate(input[3])) {
			System.out.println("DATES must be in \"" + DATE_FORMAT + "\" format.");
			errorFlag = true;
		}
		
		if(!"text".equalsIgnoreCase(input[4]) && !"csv".equalsIgnoreCase(input[4])) {
			System.out.println("Specify \"text\" or \"csv\" for OUTPUT");
			errorFlag = true;
		}
		
		if(errorFlag) System.exit(0);		
	}
	
	private static boolean isValidAccount(String str) {
		
		try {
			
			if(str.equals("*"))
				return true;
			
			Integer.parseInt(str);
				return true;
		} catch (Exception e) {
			System.out.println(str + " is not a valid account number.");
		}
		
		return false;
	}
	
	private static boolean isValidDate(String str) {
		try {
			
			if(str.equals("*"))
				return true;
			
			df.parse(str).getTime();
				return true;
			
		} catch (Exception e) {
			System.out.println(str + " is not a valid date.");
		}
		
		return false;
	}
	
	private static long getDate(String str) {		
		try {
			
			return df.parse(str).getTime();
			
		} catch (Exception e) {
				e.printStackTrace();
		}
		
		System.out.println("If you can read this, I messed up.");
		return 0;
	}
	
	private static List<List<String>> getStringList_noHeaders(Path filePath) {
		try {
			
			return Files.lines(filePath)
					.skip(1)
					.map(Pattern.compile("[;]+")::split)
					.map(Arrays::asList)
					.collect(Collectors.toList());
		} catch (Exception e) {
			System.out.println("Error converting " + filePath.toString());
			
			System.exit(0);
		}	
		
		return null;
	}
	
	private static void format(String type, List<List<String>> accounts, List<List<String>> filteredList) {
		
		int totalDebits = 0;
		int totalCredits = 0;
		
		List<List<String>> finalList = new ArrayList<List<String>>();
		
		// add headers to list
		String[] headers = {"ACCOUNT", "DESCRIPTION", "DEBIT", "CREDIT", "BALANCE"};
		finalList.add(new ArrayList<String>(Arrays.asList(headers)));
		
		for(List<String> acct : accounts) {
			
			int debits = filteredList.stream()
					.filter(entry -> entry.get(0).equals(acct.get(0))) // get list of journal entries that match the account number
					.mapToInt(n -> Integer.parseInt(n.get(2))).sum();
			totalDebits += debits;
			
			int credits = filteredList.stream()
					.filter(entry -> entry.get(0).equals(acct.get(0)))
					.mapToInt(n -> Integer.parseInt(n.get(3))).sum();
			totalCredits += credits;
			
			// does not add accounts that have no activity (0 credits, 0 debits)
			if(debits != 0 || credits != 0)
				finalList.add(new ArrayList<String>(
						Arrays.asList(acct.get(0), acct.get(1), String.valueOf(debits), String.valueOf(credits), String.valueOf(debits - credits))));
		}
		
		String[] footerTotal = {"TOTAL", "", String.valueOf(totalDebits), String.valueOf(totalCredits), String.valueOf(totalDebits - totalCredits)};
		finalList.add(new ArrayList<String>(Arrays.asList(footerTotal)));
		
		if(type.equals("text")) toText(finalList);
		if(type.equals("csv")) toCSV(finalList);
	}
	
	private static void accountSummary(List<List<String>> finalList) {
		System.out.printf("Total Debits: %d    Total Credits: %d%n", debits, credits);
		System.out.printf("Balance from account %d to %d from period %s to %s%n%n", 
				startAccount, endAccount, df.format(new Date(startDate)).toUpperCase(), df.format(new Date(endDate)).toUpperCase());
		
		System.out.println("Balance: ");
	}
	
	private static void toCSV(List<List<String>> finalList) {
		// display summary information such as credit/debit balances, input returns
		accountSummary(finalList);
		
		finalList.stream().forEach(e -> {
				for(int i = 0 ; i < e.size(); i++)
					System.out.printf("%s;", e.get(i));
				
				System.out.println();
		});
	}
	
	private static void toText(List<List<String>> finalList) {		
		// get width of each column and adds 2
		int[] width = {
				2+ finalList.stream().mapToInt(e -> e.get(0).length()).max().getAsInt(),
				2+ finalList.stream().mapToInt(e -> e.get(1).length()).max().getAsInt(),
				2+ finalList.stream().mapToInt(e -> e.get(2).length()).max().getAsInt(),
				2+ finalList.stream().mapToInt(e -> e.get(3).length()).max().getAsInt(),
				2+ finalList.stream().mapToInt(e -> e.get(4).length()).max().getAsInt()
		};

		// display summary information such as credit/debit balances, input returns
		accountSummary(finalList);
		
		// display main data
		finalList.stream().forEach(lst -> {
			for(int i = 0; i < lst.size(); i++) {
				if(i == 0 || i == 1)  // left justify
					System.out.printf("%-" + width[i] + "s|", lst.get(i));
				else  // right justify
					System.out.printf("%" + width[i] + "s|", lst.get(i));
			}
			System.out.println();
			
			// adds dashes under header row
			if(lst.get(0).equals("ACCOUNT")) {
				int numDashes = width.length;
				for (int i = 0; i < width.length; i++)
					numDashes+= width[i];
				
				System.out.printf("%s%n", new String(new char[numDashes]).replace("\0", "-"));
			}
		});
	}
}


