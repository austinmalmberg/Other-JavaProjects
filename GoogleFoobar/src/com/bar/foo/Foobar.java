package com.bar.foo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Foobar {
	public static void main(String[] args) {
		int[] data = {5, 10, 15, 10, 7};
		int n = 1;
		
		System.out.println( Arrays.toString(answer2(data, n)));
	}
	
	// fails tests 4 and 9
	public static int[] answer(int[] data, int n) {
		LinkedHashMap<Integer, Integer> dict = new LinkedHashMap<>();
		ArrayList<Integer> removed = new ArrayList<>();
		
		for(Integer d : data) {
			if(!removed.contains(d)) {
				int newCount = dict.containsKey(d) ? dict.get(d)+1 : 1;
				
				if(newCount <= n) {
					dict.put(d, newCount);
				} else {
					dict.remove(d);
					removed.add(d);
				}
			}
		}
		
		int i = 0;
		int[] output = new int[dict.size()];
		for(Integer k : dict.keySet()) {
			output[i++] = k; 
		}
		
		return output;
	}
	
	public static int[] answer2(int[] data, int n) {
		HashMap<Integer, Integer> dict = new HashMap<>();
		
		for(Integer d : data) {
			dict.put(d, dict.containsKey(d) ? dict.get(d)+1 : 1);
		}
		
		int[] output = new int[0];
		for(Integer d : data) {
			if(dict.get(d) <= n) {
				output = Arrays.copyOf(output, output.length+1);
				output[output.length-1] = d;
			}
		}
		
		return output;
	}
}
