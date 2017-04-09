package chords;

import chords.D.D;


public class Main {

	public static void main(String[] args) {		
		Input input = new Input();
		String str;
		char note;
		
		Chord chord = new Chord();
		Tuning tuning = new Tuning();
		Alternatives alts = new Alternatives();
		do {
			str = input.get("Chord:  ");
			note = str.charAt(0);
			
			switch (note) {
			case 'Q': case 'q': case 'X': case 'x':
				break;
			case 'D': case 'd':
				D d = new D();
				if (str.equalsIgnoreCase("dm") || str.equalsIgnoreCase("d minor") || str.equalsIgnoreCase("dminor")) {
					chord.show(tuning.standard, d.minor());
				}
				break;
	
			default:
				System.out.println("Unrecognized chord.");
				break;
			}
		} while (!str.contains("q") || !str.contains("x"));  //doesn't work
	}
}
