package com.austin.challenge355e;

public class Main {
	
	public static void main(String[] args) {
		
		String[] TBEncrypted = {
			"snitch thepackagehasbeendelivered",
			"bond theredfoxtrotsquietlyatmidnight",
			"train murderontheorientexpress",
			"garden themolessnuckintothegardenlastnight"
		};
		
		String[] TBDecrypted = {
			"cloak klatrgafedvtssdwywcyty",
			"python pjphmfamhrcaifxifvvfmzwqtmyswst",
			"moore rcfpsgfspiecbcc"
		};
		
		AlphabetCipher cipher = new AlphabetCipher();
		
		for(String s : TBEncrypted) {
			String[] msg = s.split("\\s+");
			String secretWord = msg[0];
			String message = msg[1];
			
			System.out.printf("ENCRYPTED MESSAGE: (%s) %s -> %s%n", secretWord, message, cipher.encrypt(secretWord, message));
		}
		
		System.out.println();
		
		for(String s : TBDecrypted) {
			String[] msg = s.split("\\s+");
			String secretWord = msg[0];
			String message = msg[1];
			
			System.out.printf("DECRYPTED MESSAGE: (%s) %s -> %s%n", secretWord, message, cipher.decrypt(secretWord, message));
		}
	}
}
