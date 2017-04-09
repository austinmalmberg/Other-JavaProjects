package com.lynda.javatraining.olives;

import java.util.ArrayList;

public class OliveJar {
	
	public ArrayList<Olive> olives;
	
	{
		System.out.println("Initializng...");
		olives = new ArrayList<>();
		olives.add(new Olive(OliveName.GOLDEN, 0xDA9100));
	}
	
	public OliveJar() {
		System.out.println("Constructor...");
	}
	
	public void addOlive(OliveName oliveName, long color) {
		olives.add(new Olive(oliveName, color));
	}
	
	public void reportOlives() {
		
		class JarLid {
			public void open() {
				System.out.print("Twist, twist, twist...");
				System.out.println("Pop!");
			}
		}
		new JarLid().open();
		
		for (Olive o : olives) {
			System.out.println("It's a " + o.oliveName + " olive!");
		}
		
		//anonymous local class
		new Object() {
			public void close() {
				System.out.println("<closes jar>");
			}
		}.close();
	}
}
