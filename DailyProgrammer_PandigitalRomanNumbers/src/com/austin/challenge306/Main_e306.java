package com.austin.challenge306;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Description
 * 
 * 1474 is a pandigital in Roman numerals (MCDLXXIV). It uses each of the symbols I, V, X, L, C, and M at least once.
 * Your challenge today is to find the small handful of pandigital Roman numbers up to 2000.
 * 
 * Output Description
 * 
 * A list of numbers. Example:
 * 1 (I), 2 (II), 3 (III), 8 (VIII) (Examples only, these are not pandigital Roman numbers)
 * 
 * Challenge Input
 * Find all numbers that are pandigital in Roman numerals using each of the symbols I, V, X, L, C, D and M exactly once.
 * 
 * Challenge Input Solution
 * 1444, 1446, 1464, 1466, 1644, 1646, 1664, 1666
 * 
 * @author Austin Malmberg
 *
 */
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
