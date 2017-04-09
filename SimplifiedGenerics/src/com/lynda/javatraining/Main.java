package com.lynda.javatraining;
import java.util.ArrayList;

import com.lynda.olivepress.olives.*;

public class Main {

	public static void main(String[] args) throws Exception {
		
		Olive o1 = new Olive("Kalamata", 0x000000);
		Olive o2 = new Olive("Picholine", 0x00FF00);
		Olive o3 = new Olive("Ligurio", 0x000000);
		
		//Olive[] olives = {o1, o2, o3};
		ArrayList<Olive> olives2 = new ArrayList<>();
		olives2.add(o1);
		olives2.add(o2);
		olives2.add(o3);
		
		System.out.println(olives2);
	}

}
