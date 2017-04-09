package com.lynda.calc;
import com.lynda.calc.helpers.*;

public class Calculator2 {
	public static void main(String[] args) {
		String s1 = InputHelper.getInput("Enter a numberic value: ");
		String s2 = InputHelper.getInput("Enter another numberic value: ");
		String op = InputHelper.getInput("Enter 1=Add, 2=Subtract, 3=Multiply, 4=Divide: ");
		
		int opInt = Integer.parseInt(op);
		
		double result = 0;
		switch (opInt) {
		case 1:
			result = MathHelper.addValues(s1, s2);
			break;
		case 2:
			result = MathHelper.subtractValues(s1, s2);
			break;
		case 3:
			result = MathHelper.multiplyValues(s1, s2);
			break;
		case 4:
			result = MathHelper.divideValues(s1, s2);
			break;
		default:
			System.out.println("You've selected a value I don't understand.");
			return;
		}
		
		System.out.println("The answer is " + result);
	}
}