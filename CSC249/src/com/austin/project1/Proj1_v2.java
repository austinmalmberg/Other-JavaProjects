package com.austin.project1;
import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

public class Proj1_v2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		PrefixExpression_v1 pe = new PrefixExpression_v1();
		
		System.out.print("Enter prefix expression: ");
		String input = sc.nextLine();
		
		System.out.println(pe.getAnswer(input));
	}
	
}

class PrefixExpression_v1 {
	
	private final String operators = "*+";
	
	private Stack<String> ops;
	private Stack<Integer> ints;
	
	public PrefixExpression_v1() {
		ops = new Stack<>();
		ints = new Stack<>();
	}
	
	public String getAnswer(String input) {
		String[] input_arr = input.split("\\s+");
		
		int consecutiveInts = 0;
		for(String token : input_arr) {
			if(token.length() > 1 && !isNumber(token)) {
				System.out.println(token.length() > 1);
				System.out.println(!isNumber(token));
				System.out.println(!operators.contains(token));
				return token + " not recognized.";
			}
			
			if(isNumber(token)) {
				if(getNumber(token) < 0) {
					return "Integer values cannot be less than 0.";
				}
				
				consecutiveInts++;
				ints.push(getNumber(token));
				
				if(consecutiveInts >= 2) {
					String returnVal = calculate(ops, ints);
					if(isNumber(returnVal))
						ints.push(getNumber(returnVal));
					else
						return returnVal;
				}
			} else { // if(operators.contains(token)) {
				
				consecutiveInts = 0;
				ops.push(token);
			}
		}
		
		while(!ops.isEmpty()) {
			String returnVal = calculate(ops, ints);
			if(isNumber(returnVal))
				ints.push(getNumber(returnVal));
			else
				return returnVal;
		}
		
		return String.valueOf(ints.pop());
	}
	
	private boolean isNumber(String str) {
		
		try {
			int i = Integer.parseInt(str);
			return true;
		} catch(NumberFormatException nfe) {
			return false;
		}
	}
	
	private int getNumber(String str) {
		try {
			return Integer.parseInt(str);
		} catch(NumberFormatException nfe)  {
			nfe.printStackTrace();
		}
		
		return 0;	// Because we check that the token is a number before calling this method, 
					// this return statement will never be called
	}
	
	private String calculate(Stack<String> ops, Stack<Integer> ints) {
		
		String operator = null;
		int n1 = 0;
		int n2 = 0;
		
		try {
			operator = ops.pop();
			n2 = ints.pop();
			n1 = ints.pop();
		} catch(EmptyStackException ese) {
			return "Formatting error.  Please check the expression and try again."; 
		}
		
		switch (operator) {
		case "*":
			return String.valueOf(n1 * n2);
		case "+":
			return String.valueOf(n1 + n2);
		default:
			return operator + " not supported.";
		}
	}
	
}
