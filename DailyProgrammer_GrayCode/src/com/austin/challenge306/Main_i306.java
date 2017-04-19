package com.austin.challenge306;

public class Main_i306 {
	public static void main(String[] args) {
		int codeLength = 11;
		int base = 2;
		
		GrayCode gray = new GrayCode(codeLength, base);
		
		String s;
		
		int i = 0;
		do {
			s = gray.toGray(Integer.toBinaryString(i));
			i++;
			
			if(s.length() == codeLength) System.out.println(i + " = " + s);
		} while(s.length() <= codeLength);
	}
}

class GrayCode {
	private int codeLength;
	
	@SuppressWarnings("unused")
	private int base; // for bonus.  not implemented
	
	GrayCode(int codeLength, int base) {
		this.codeLength = codeLength;
		this.base = base;
	}
	
	String toBinary(String gray) {
		if(isValid(gray)) return null;
		
		gray = addLeadingZeros(gray);
		
		boolean bool = true;
		
		int i = 0;
		while(bool) {
			String binary = Integer.toBinaryString(i);
			
			if(gray.equals(toGray(binary))) {
				
				bool = false;
				return Integer.toBinaryString(i);
			}
			
			i++;
		}
		
		return null;
	}
	
	String toGray(String binary) {
		if(isValid(binary)) return null;
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(binary.charAt(0));
		for(int i = 0; i < binary.length() - 1; i++) {
			sb.append(
				add(
					binary.charAt(i), binary.charAt(i+1)
				)
			);
		}
		
		while(sb.toString().length() < codeLength)
			sb.insert(0, '0');
		
		return sb.toString();
	}
	
	private int add(char a, char b) {
		
		switch(Integer.parseInt(a+"") + Integer.parseInt(b+"")) {
		case 1:
			return 1;
		case 0:
		case 2:
			return 0;
//		default: // a+b = 0 OR 2
//			return 0;
		}
		
		return 2;
	}
	
	private String addLeadingZeros(String s) {
		StringBuilder sb = new StringBuilder();
		sb.append(s);
		
		while(sb.length() < codeLength)
			sb.insert(0, '0');
		
		return sb.toString();
	}
	
	private boolean isValid(String s) {
		if(s.matches("[12]")) return false;
		if(s.length() > codeLength) return false;
		
		return true;
	}
}
