package com.lynda.javatraining;
import com.lynda.olivepress.olives.OliveJar;

public class Main {

	public static void main(String[] args) {
		
		OliveJar jar = new OliveJar();
		for (int i = 0; i <= 3; i++) {
			jar.addOlive("Kalamata", 0x000000);
		}
		
//		jar.addOlive("Kalamata", 0x000000);
//		jar.addOlive("Kalamata", 0x000000);
//		jar.addOlive("Kalamata", 0x000000);
//		jar.addOlive("Kalamata", 0x000000);
		
		jar.reportOlives();
		
	}

}
