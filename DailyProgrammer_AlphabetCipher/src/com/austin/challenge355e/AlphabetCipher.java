package com.austin.challenge355e;

public class AlphabetCipher {
	
	private final String alphabet = "abcdefghijklmnopqrstuvwxyz";
	
	private String secretWord;
	
	public AlphabetCipher() {	
	}
	
	public AlphabetCipher(String secretWord) {
		this();
		
		this.secretWord = secretWord;
	}
	
	public void setSecretWord(String secretWord) { this.secretWord = secretWord; }
	
	public String decrypt(String message) {
		if(!isValid(message)) return null;
		
		message = message.toLowerCase();
		
		String ans = "";
		
		/**
		 * i.e.
		 * Secret char --> s = 19
		 * Encrypted char --> l = 12
		 * 
		 * 26-19 + 12 = 19
		 * alphabet[19] = t
		 */
		for(int i = 0, j = 0; i < message.length(); i++, j = i % secretWord.length()) {			
			ans += alphabet.charAt(
					
					(alphabet.length() - alphabet.indexOf( secretWord.charAt(j) ) +
							alphabet.indexOf( message.charAt(i) )) %
					alphabet.length()
					
					);
		}		
		
		return ans;
	}
	
	public String decrypt(String secretWord, String message) {
		this.secretWord = secretWord;
		
		return decrypt(message);
	}
	
	public String encrypt(String message) {
		if(!isValid(message)) return null;
		
		message = message.toLowerCase();
		
		String code = "";
		
		/**
		 * i.e.
		 * Secret char --> s = 18
		 * Unencrypted char --> t = 19
		 * 
		 * 18 + 19 = 37 % 26 = 11
		 * alphabet.charAt(11) = l
		 */
		for(int i = 0, j = 0; i < message.length(); i++, j = i % secretWord.length()) {
			
			code += alphabet.charAt(
					
					(alphabet.indexOf( secretWord.charAt(j) ) +
							alphabet.indexOf( message.charAt(i) )) %
					alphabet.length()
					
					);
		}
		
		return code;
	}
	
	public String encrypt(String secretWord, String message) {
		this.secretWord = secretWord;
		
		return encrypt(message);
	}
	
	private boolean isValid(String message) { return message.matches("[a-zA-Z]++"); }
}
