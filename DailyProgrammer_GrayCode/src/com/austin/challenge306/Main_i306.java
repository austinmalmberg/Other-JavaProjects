package com.austin.challenge306;

/**
 * Description
 * 
 * Gray code, so named after discoverer Frank Gray, is a binary numeral system where two successive values differ in only
 * one bit (binary digit). The reflected binary code was originally designed to prevent spurious output from electromechanical
 * switches. Today, Gray code is widely used to facilitate error correction in digital communications such as digital
 * terrestrial television and some cable TV systems.
 * 
 * Gray code differs from regular binary counting sequences in one key way: because sequential values can have only a single bit
 * difference from their predecessor, you wind up with a non-linear progression of base 10 integers (see column 4, "Gray as decimal"):
 * 
 * Decimal	Binary	Gray	Gray as decimal
 * 0		000		000		0
 * 1		001		001		1
 * 2		010		011		3
 * 3		011		010		2
 * 4		100		110		6
 * 5		101		111		7
 * 6		110		101		5
 * 7		111		100		4
 * 
 * The problem with natural binary codes is that physical switches are not ideal: it is very unlikely that physical switches will change
 * states exactly in synchrony. In the transition between the two states shown above, all three switches change state. In the brief period
 * while all are changing, the switches will read some spurious position. The Gray code solves this problem by changing only one switch at
 * a time, so there is never any ambiguity of position.
 * 
 * The Gray code has multiple applications including position encoders, genetic algorithms, error correction codes, Karnaugh map labeling,
 * and digital clocks.
 * 
 * Bonus
 * 
 * Write a program that can construct an n-ary Gray code, so not just binary but, say, ternary (for an arbitrary bit width, in this example 2),
 * where successive values differ by one position (so 0<->2 is OK):
 * 
 * 00
 * 01
 * 02
 * 12
 * 10
 * 11
 * 21
 * 22
 * 20
 * 
 * @author Austin Malmberg
 *
 */
public class Main_i306 {
	public static final int CODE_LENGTH = 4;
	public static final int BASE = 2;
	
	public static void main(String[] args) {
		
		GrayCode gray = new GrayCode(CODE_LENGTH, BASE);
		
		String s;
		
		int i = 0;
		do {
			s = gray.encode(Integer.toBinaryString(i));
			if(s.length() == CODE_LENGTH) System.out.println(i + " = " + addLeadingZeros(Integer.toBinaryString(i)) + " = " + s);
			
			i++;
		} while(s.length() <= CODE_LENGTH);
	}
	
	private static String addLeadingZeros(String s) {
		StringBuilder sb = new StringBuilder();
		sb.append(s);
		
		while(sb.length() < CODE_LENGTH)
			sb.insert(0, '0');
		
		return sb.toString();
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
	
	/**
	 * Returns a string in binary given its gray code
	 * 
	 * @param gray a string in gray code of codeLength
	 * @return a string in binary
	 */
	String decode(String gray) {
		
		boolean bool = true;
		
		int i = 0;
		while(bool) {
			String binary = Integer.toBinaryString(i);
			
			if(gray.equals(encode(binary))) {
				
				bool = false;
				return Integer.toBinaryString(i);
			}
			
			i++;
		}
		
		return null;
	}
	
	/**
	 * Return a string in gray code
	 * 
	 * @param binary a string in binary of codeLength
	 * @return a string in gray code
	 */
	String encode(String binary) {		
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
		return a+b == 1 ? 1 : 0;
	}
}
