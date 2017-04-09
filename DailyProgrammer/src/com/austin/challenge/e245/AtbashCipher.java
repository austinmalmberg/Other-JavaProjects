package com.austin.challenge.e245;

import java.util.stream.IntStream;

public class AtbashCipher {
	public static void main(String[] args) {
		swap("foobar");
		swap("wizard");
		swap("/r/dailyprogrammer");
		swap("Gsrh rh zm vcznkov lu gsv Zgyzhs Xrksvi");
	}
	
	public static void swap(String s) {
		StringBuilder output = new StringBuilder();
		
		IntStream.rangeClosed(0, s.length() - 1).forEachOrdered(i ->
			output.append(encode(s.charAt(i)))
		);
		
		System.out.println(output.toString());
	}
	
	public static char encode(char c) {
		String cipher = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		if(Character.isUpperCase(c))
			return (char)('Z' - cipher.indexOf(c));
		
		if(Character.isLowerCase(c))
			return (char)('z' - cipher.toLowerCase().indexOf(c));
		
		return c;	// return unaltered char
	};
}
