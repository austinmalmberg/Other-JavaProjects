package com.lynda.javatraining;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

import com.lynda.javatraining.olives.*;

public class Main {

	public static void main(String[] args) {
		
		LinkedList<Olive> list = new LinkedList<>();
		
		list.add(new Picholine());
		list.add(new Kalamata());
		
		list.add(1, new Golden());
		
		list.addFirst(new Ligurio());
		
		display(list);
		//System.out.println(list);
		
	}

	static private void display(Collection<Olive> col) {
		System.out.println("List order:  ");
		Iterator<Olive> iterator = col.iterator();
		
		while (iterator.hasNext()) {
			Olive olive = (Olive) iterator.next();
			System.out.println(olive.oliveName.toString());
		}
	}
}
