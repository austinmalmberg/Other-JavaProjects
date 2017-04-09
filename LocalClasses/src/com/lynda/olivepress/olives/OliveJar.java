package com.lynda.olivepress.olives;
import java.util.ArrayList;

public class OliveJar {
	public ArrayList<Olive> olives;
	
	//runs before all constructors
	{
		System.out.println("Initializing...");
		olives = new ArrayList<>();
		olives.add(new Olive("Golden", 0xDA9100));
	}
	
	//constructor, no args
	public OliveJar() {
		System.out.println("Constructing...");
	}
	
	//constructor, 3 args (int, String, long)
	public OliveJar(int nOlives, String oliveName, long color) {
		for (int i = 0; i <= nOlives; i++) {
			olives.add(new Olive(oliveName, color));
		}
	}
	
	public void addOlive(String oliveName, long color) {
		olives.add(new Olive(oliveName, color));
	}
	
	public void reportOlives() {
		//local inner class
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
	
	//member class
	class Olive {
		
		public static final long BLACK = 0x000000;
		
		public String oliveName;
		public long color = BLACK;
		
		public Olive() {
		}

		public Olive(String oliveName) {
			this.oliveName = oliveName;
		}
		public Olive(String oliveName, long color) {
			this(oliveName);
			this.color = color;
		}
		
		public String toString() {
			return "Name: " + this.oliveName + ": " + "Color: " + this.color;
		}
	}
}
