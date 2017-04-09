package com.austin.challenge.h240;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public class KenKenSolver {
	static final int DIMENSIONS = 6;
	
	static ArrayList<Integer[]> combinations = new ArrayList<>();
	static ArrayList<ElementGroup> groups = new ArrayList<>();
	
	public static void main(String[] args) {
		// get parameters
			// create new ElementGroup for each parameter
				// add ElementGroup to combinations
		
		IntStream.rangeClosed(0, combinations.size()).forEach(i -> test(i));
	}
	
	public static void test(int i) {
		boolean solution = false;
		int[][] board = new int[DIMENSIONS][DIMENSIONS];

		for(ElementGroup eg : groups) {
			for(Element e : eg.getElements()) {
				board[e.getX()][e.getY()] = e.getValue();
			}
		}
		
		if(!validBoardstate(board)) return;
		
		if(solution) {
			printSolution(i);
			System.exit(0);
		}
	}
	
	private static boolean validBoardstate(int[][] board) {
		boolean valid = false;
		
		IntStream.rangeClosed(0, DIMENSIONS - 1).forEach(j -> {
			Integer[] vert = new Integer[DIMENSIONS];
			Integer[] horz = new Integer[DIMENSIONS];
			
			IntStream.rangeClosed(0, DIMENSIONS - 1).forEach(i -> {
				vert[i] = board[i][j];	// get columns
				horz[i] = board[j][i];	// get rows
			});
			
			if(Arrays.asList(vert).contains(vert)) {
//				valid = true;
			}
		});
		
		return true;
	}

	private static boolean validHorizontal(int[][] board) {
		return false;
	}

	public static void printSolution(int i) {
		
	}
}
