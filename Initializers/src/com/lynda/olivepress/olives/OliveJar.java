package com.lynda.olivepress.olives;
import java.util.ArrayList;

public class OliveJar {
	public /**static*/ ArrayList<Olive> olives;
	
	/**static*/ {
		System.out.println("initializing...");
		olives = new ArrayList<>();
		olives.add(new Olive("Golden", 0xDA9100));
		/**
		olives.add(new Olive("Picoline", 0x00FF00));
		olives.add(new Olive("Kalamata", 0x000000));
		*/	
	}
	
	public OliveJar() {
		System.out.println("Constructor...");
	}
	
	public OliveJar(int nOlives, String oliveName, long color) {
		for (int i = 0; i <= nOlives; i++) {
			olives.add(new Olive(oliveName, color));
		}
	}
}
