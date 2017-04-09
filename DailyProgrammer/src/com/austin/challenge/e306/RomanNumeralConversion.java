package com.austin.challenge.e306;

import java.util.LinkedHashMap;
import java.util.Map;

class RomanNumeralConversion {
	
	private Map<String, Integer> map;
	private String uniqueNumerals;
	
	RomanNumeralConversion() {
		map = new LinkedHashMap<>();

		map.put("M", 1000);
		map.put("CM", 900);
		map.put("D", 500);
		map.put("CD", 400);
		map.put("C", 100);
		map.put("XC", 90);
		map.put("L", 50);
		map.put("XL", 40);
		map.put("X", 10);
		map.put("IX", 9);
		map.put("V", 5);
		map.put("IV", 4);
		map.put("I", 1);
		
		uniqueNumerals = findUniqueNumerals();
	}
	
	int getNumber(String s) {
		s = s.toUpperCase();
		
		int num = 0;
		
		for(int i = 0; i < s.length(); i++) {
			
			if(nextIsGreater(s.substring(i))) {
				num -= map.get(s.charAt(i)+"");
			} else {
				num += map.get(s.charAt(i)+"");
			}
		}
		
		return num;
	}
	
	private boolean nextIsGreater(String remaining) {
		
		if(remaining.length() <= 1) return false;
		
		// MDCLXVI
		return uniqueNumerals.indexOf(remaining.charAt(0)) > uniqueNumerals.indexOf(remaining.charAt(1));
	}
	
	String getRomanNumeral(int num) {
		if(num < 1) throw new NumberFormatException("Integer must be positive.");
		if(num > 3999) throw new NumberFormatException("Integer must be between less than 4000.");
		
		StringBuilder roman = new StringBuilder();
		
		do{
		
			for(Map.Entry<String, Integer> e : map.entrySet()) {
				
				if(num / e.getValue() > 0) {
					roman.append(e.getKey());
					num -= e.getValue();
					
					break;
				}
			}
			
		} while(num > 0);
		
		
		return roman.toString();
	}
	
	private String findUniqueNumerals() {
		StringBuilder unique = new StringBuilder();
		
		// loops through entries
		for(Map.Entry<String, Integer> e : map.entrySet()) {
			
			if(e.getKey().length() == 1) {
				// adds letter to unique
				unique.append(e.getKey());
			}
		}
		
		return unique.toString();
	}
	
	String getUniqueNumerals() { return uniqueNumerals; }
}