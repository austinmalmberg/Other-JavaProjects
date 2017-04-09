package com.lynda.olivepress.press;
import com.lynda.olivepress.olives.Olive;

public class OlivePress {
	
	public void getOil(Olive[] olives) {
		
		for (Olive olive : olives) {
			olive.crush();
		}
		
	}
}
