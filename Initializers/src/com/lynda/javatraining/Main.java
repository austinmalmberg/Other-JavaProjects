package com.lynda.javatraining;
import java.util.ArrayList;
import com.lynda.olivepress.olives.*;

public class Main {

	public static void main(String[] args) {
		System.out.println("Starting application...");
		
		ArrayList<Olive> olives = new OliveJar(10, "Kalamata", 0x000000).olives;
		for (Olive o : olives) {
			System.out.println("It's a " + o.oliveName + " olive!");
		}
	}

}
