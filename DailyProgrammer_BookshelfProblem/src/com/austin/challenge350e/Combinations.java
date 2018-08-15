package com.austin.challenge350e;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Combinations {
	
	public Combinations() { }
	
	
	public <E> List<List<E>> find(List<E> list) {
		return find(list, new ArrayList<E>());
	}
	private <E> List<List<E>> find(List<E> combos, List<E> list) {
		for(int i = 0; i < list.size(); i++) {
			
		}
		return null;
	}
	
	public List<List<Integer>> combo1(List<Integer> in, List<Integer> list) {
		Queue<Integer> li = new ArrayDeque<>();
		
		/*
		 * {1,2,3,4}
		 * 
		 * 1
		 * 1,2  1,3  1,4
		 * 1,2,3  1,2,4
		 * 1,2,3,4			last index
		 * 
		 * 2
		 * 2,3 2,4
		 * 2,3,4 			last index
		 * 
		 * 3
		 * 3,4				last index
		 * 
		 * 4
		 * 
		 */
		
		/* Takes INTS = {1,2,3}
		 * 
		 * Put INTS in stack
		 * Add stack to LIST
		 * pop out 
		 * 
		 */
		
	}
}
