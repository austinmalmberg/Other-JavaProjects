
public class Main {
	public static void main(String[] args) {
		SquareSpiral ss = new SquareSpiral();
		
		ss.findPoint(7, 49);
		ss.findPoint3(7, 30);
		
//		
//		ss.findPoint(1024716039, 557614022);
//		
//		ss.findPosition(7, 1, 1);
//		ss.findPosition(234653477, 11777272, 289722);
	}
}

class SquareSpiral {
	// corner values
	private final int TOP_RIGHT = 0;
	private final int TOP_LEFT = 1;
	private final int BOT_LEFT = 2;
	private final int BOT_RIGHT = 3;
	
	private int mid_point;
	
	public SquareSpiral() {
		
	}
	
	public void findPoint(int grid, int num) {	
		if(grid < 3 || grid % 2 == 0 || grid > Integer.MAX_VALUE || num > Integer.MAX_VALUE) {
			System.out.println("Input must be an odd integer greater than 3.");
			return;
		}
		
		mid_point = (grid / 2) + 1;
		
		int x = 1;
		int y = 1;
		
		int corner = 0;
		int corner_num = 3;
		
		int offset = 1;  // every four corners increases the offset by one from the mid_point
		
		// find corner values until the corner value is greater than the number
		int step = 2;
		int counter = 0;
		while(num > corner_num) {
			corner++;
			counter++;
			
			if(corner > 3) {
				corner = 0;
				step += 2;
				offset++;
			}
			
			corner_num += step;
		}
		
		// get position of the corner then add or subtract the difference to get the final coordinate
		switch(corner) {
		case TOP_RIGHT:
			x = mid_point + offset;
			y = (mid_point - offset) + (corner_num - num);
			break;
		case TOP_LEFT:
			x = (mid_point - offset) + (corner_num - num);
			y = mid_point - offset;
			break;
		case BOT_LEFT:
			x = mid_point - offset;
			y = (mid_point + offset) - (corner_num - num);
			break;
		case BOT_RIGHT:
			x = (mid_point + offset) - (corner_num - num);
			y = mid_point + offset;
			break;
		}
		
		System.out.printf("%d found at (%d, %d) after %d iterations.%n", num, x, y, counter);
	}
	
	public void findPoint3(int grid, int num) {
		
		int mid_point = (grid / 2) + 1;
		
		int x = mid_point;
		int y = mid_point;
		
		int val = 1;
		int br_val = 1;
		int tl_val = 1;
		
		int offset = 0;
		
		// find the closest square
		for(int i = 1; i <= grid; i++) {
			val = i * i;
			
			if(Math.abs(val - num) < Math.abs((i+1)*(i+1) - num) + 1) {
				if(i % 2 == 0) tl_val = val + 1;
				else br_val = val;
				
				break;
			}
		}
		
		System.out.println(val);
		
		
		
		
		
		
		
		
//		for(int i = 1; i * i <= num; i++) {
//			val = i * i;
//			
//			if(i % 2 == 0) {
//				tl_val = val + 1;
//			} else {
//				br_val = val;
//			}
//			
//			
//		}
//		
//		System.out.printf("tl_val: %d, br_val: %d    (%d, %d)%n", tl_val, br_val, num, num);
	}
	
	public void findPosition(int grid, int x, int y) {
		
	}
}
