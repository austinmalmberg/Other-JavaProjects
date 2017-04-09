package com.lynda.javatraining;

import com.lynda.javatraining.olives.OliveJar;
import com.lynda.javatraining.olives.OliveName;

public class EnumClasses {

	public static void main(String[] args) {
		
		OliveJar jar = new OliveJar();
		jar.addOlive(OliveName.KALAMATA, 0x000000);
		jar.addOlive(OliveName.PICHOLINE, 0x000000);
		jar.addOlive(OliveName.LIGURIO, 0x000000);
		jar.reportOlives();
	}

}
