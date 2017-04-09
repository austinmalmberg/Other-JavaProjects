import java.awt.Point;
import java.math.BigInteger;

import sun.security.util.BigInt;


public class Main {
	public static void main(String[] args) {
		final int DIMENSIONS = 13;
		
		NumberBox n1 = new NumberBox(DIMENSIONS);
		n1.create();
		n1.print();
		
		n1.sumOfDiagonals();
	}
}

class NumberBox {
	private final int LEFT = 0;
	private final int DOWN = 1;
	private final int RIGHT = 2;
	private final int UP = 3;
	
	int[][] box;
	
	int dimensions;
	int x_max;
	int y_max;
	
	int maxNumbers;
	
	boolean endTopRight;
	
	public NumberBox(int d) {
		dimensions = d;
		x_max = y_max = d - 1;
		
		maxNumbers = d * d;
		
		// if the dimensions are odd, last digit will be in the top right corner
		// if the dimensions are even, last digit will be in the bottom left
		endTopRight = d % 2 != 0 ? true : false;
		
		box = new int[dimensions][dimensions];
	}
	
	public void create() {
		int x, y;
		x = endTopRight ? x_max: 0;
		y = endTopRight ? 0 : y_max;
		
		int num = maxNumbers;
		
		int direction = endTopRight ? LEFT : RIGHT;
		
		do {
			box[x][y] = num;
			num--;
			
			if(changeDirection(direction, x, y)) direction++;  // check if next point will intersect another
			if(direction > 3) direction = 0;
			
			switch(direction) {
			case LEFT:
				x--;
				break;
			case DOWN:
				y++;
				break;
			case RIGHT:
				x++;
				break;
			case UP:
				y--;
				break;
			}
		} while(num > 0);
	}
	
	private boolean changeDirection(int direction, int x, int y) {
		switch(direction) {
		case LEFT:
			if(x == 0) return true;
			else if(box[x-1][y] != 0) return true;
			break;
		case DOWN:
			if(y == y_max) return true;
			else if(box[x][y+1] != 0) return true;
			break;
		case RIGHT:
			if(x == x_max) return true;
			else if(box[x+1][y] != 0) return true;
			break;
		case UP:
			if(y == 0) return true;
			else if(box[x][y-1] != 0) return true;
			break;
		}
		
		return false;
	}
	
	public void sumOfDiagonals() {
		int sum = 1;
		
		int j = 2;
		int corners = 0;
		
		for(int i = 3; i <= maxNumbers; i += j) {
			sum += i;
			corners++;
			if(corners >= 4) {
				corners = 0;
				j+=2;
			}
		}
		
		System.out.printf("Sum of diagonals: %,d%n", sum);
	}
	
	public void print() {
		double i = maxNumbers;
		int spaceFormatting = 2;
		while(i > 9) {
			i /= 10;
			spaceFormatting++;
		}
		
		for(int y = 0; y < dimensions; y++) {
			for (int x = 0; x < dimensions; x++) {
				System.out.printf("%" + spaceFormatting + "d", box[x][y]);
			}
			System.out.println();
		}
	}
}
