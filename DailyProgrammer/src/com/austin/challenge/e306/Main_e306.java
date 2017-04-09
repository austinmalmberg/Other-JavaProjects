package com.austin.challenge.e306;

import java.util.LinkedHashMap;
import java.util.Map;

public class Main_e306 {
	public static void main(String[] args) {
		PandigitalRomanNumbers prn = new PandigitalRomanNumbers(3999);

		prn.listPandigitalNumbers();
	}
}

class PandigitalRomanNumbers {
	private int max;
	private RomanNumeralConversion romanNumerals;
	private String uniqueNumerals;
	private String regex;
	
	PandigitalRomanNumbers(int maxInt) {
		max = maxInt;
		
		romanNumerals = new RomanNumeralConversion();
		uniqueNumerals = romanNumerals.getUniqueNumerals();
		regex = getRegex(uniqueNumerals);
	}
	
	void listPandigitalNumbers() {
		Map<String, Integer> pandigitals = new LinkedHashMap<>();
		
		String s;
		for(int i = 1; i <= max; i++) {
			s = convert(i);		
			
			if(isPandigital(s)) {
				pandigitals.put(s, i);
			}
		}
		
		System.out.println(pandigitals.toString());
	}
	
	void listPandigitalNumbers(int max) {
		this.max = max;
		
		listPandigitalNumbers();
	}
	
	private String convert(int num) {
		return romanNumerals.getRomanNumeral(num);
	}
	
	private boolean isPandigital(String s) {
		return s.matches(regex);
	}
	
	private String getRegex(String s) {
		StringBuilder sb = new StringBuilder();
		
		for(char c : s.toCharArray()) {
			sb.append("(?=.*" + c + ")");
		}
		
		sb.append(".{" + s.length() + "}");
		
		return sb.toString();
	}
	
	void setMax(int i) { max = i; }
}
