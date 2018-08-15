import java.util.Scanner;

// https://coderbyte.com/information/Correct%20Path

public class Main {
	
	static final char[] DIRECTIONS = {'u', 'd', 'l', 'r'};
	static Matrix test = new Matrix();
	
	public static String CorrectPath(String str) {
		if(str.indexOf('?') >= 0) {
		
			for(char ch: DIRECTIONS) {
				String temp = CorrectPath(str.replaceFirst("\\?", Character.toString(ch)));
				if(test.successful(temp)) return temp;
			}
		}
		
		return str;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println(CorrectPath(s.nextLine()));
	}
}

class Matrix {

	public boolean successful(String path) {
		if(path.indexOf('?') >= 0) return false;
		if(countChars(path, 'd') - countChars(path, 'u') != 4) return false;
		if(countChars(path, 'r') - countChars(path, 'l') != 4) return false;
		
		boolean[][] matrix = new boolean[5][5];
		
		int x = 0;
		int y = 0;
		matrix[x][y] = true;
		
		Direction dir;
		
		for(char ch: path.toCharArray()) {
			dir = Direction.get(ch);
			
			x += dir.x;
			y += dir.y;
			
			// test in bounds
			if(x < 0 || x > matrix.length-1) return false; 
			if(y < 0 || y > matrix[x].length-1) return false; 
			
			if(matrix[x][y]) return false;	// previously visited
			matrix[x][y] = true;
		}
		
		// finished in the bottom left corner
		return x == matrix.length-1 && y == matrix[matrix.length-1].length-1;
	}
	
	private int countChars(String str, char ch) {
		return str.replaceAll("[^"+ch+"]", "").length();
	}
}

enum Direction {
	UP(0, -1), DOWN(0, 1), LEFT(-1, 0), RIGHT(1, 0);
	
	int x, y;
	
	Direction(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	static Direction get(char ch) {
		if(ch == 'u') return UP;
		if(ch == 'd') return DOWN;
		if(ch == 'l') return LEFT;
		if(ch == 'r') return RIGHT;
		
		return null;
	}
}