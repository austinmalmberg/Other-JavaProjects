package com.austin;
import com.austin.patterns.Oscillators;

public class Array_ConwaysGameOfLife implements Runnable {
	
	public static final int WAIT_TIME = 700;
	
	public static void main(String[] args) {
		new Array_ConwaysGameOfLife(Oscillators.PULSAR).run();
	}
	
	private boolean[][] board;
	private boolean running;
	
	public Array_ConwaysGameOfLife(boolean[][] board) {		
		this.board = board;
		
		running = true;
	}
	
	public void updateState() {
		boolean[][] nextBoard = new boolean[board.length][board[0].length];
		for(int r = 0; r < nextBoard.length; r++) {
			for(int c = 0; c < nextBoard[r].length; c++) {
				nextBoard[r][c] = getNextNodeState(r, c);
			}
		}
		
		board = nextBoard;
	}
	
	public boolean getNextNodeState(int r, int c) {
		int neighbors = countNeighbors(r, c);
		
		return neighbors == 3 || (board[r][c] && neighbors == 2);
	}
	
	public int countNeighbors(int r, int c) {
		int neighbors = 0;
		
		for(Direction dir : Direction.values()) {			
			if(inBounds(r + dir.r, c + dir.c) && board[r + dir.r][c + dir.c])
				neighbors++;
		}
		
		return neighbors;
	}
	
	public boolean inBounds(int r, int c) {
		if(r < 0 || r >= board.length) return false;
		if(c < 0 || c >= board[r].length) return false;
		
		return true;
	}
	
	@Override
	public void run() {
		
		while(running) {
			printBoard();
			updateState();
			wait(WAIT_TIME);
			
		}
	}
	
	private void printBoard() {
		for(int r = 0; r < board.length; r++) {
			System.out.println(rowAsString(board[r]));
		}
		System.out.println("------------");
	}
	
	private String rowAsString(boolean[] arr) {
		StringBuilder out = new StringBuilder();
		for(boolean b : arr) {
			out.append(String.valueOf(b ? "#" : " ")+" ");
		}
		
		return out.toString();
	}
	
	private void wait(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			// do nothing
		}
	}
}

enum Direction {
	UL(-1, -1),
	L(-1, 0),
	LL(-1, 1),
	U(0, -1),
	D(0, 1),
	UR(1, -1),
	R(1, 0),
	LR(1, 1);
	
	int r, c;
	
	Direction(int r, int c) {
		this.r = r;
		this.c = c;
	}
}
