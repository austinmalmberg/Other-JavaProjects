import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Scale {
	
	private final int LEFT_INDEX = 0;
	private final int RIGHT_INDEX = 1;
	
	private int left;	// starting weight on left side
	private List<Integer> addLeft;
	private int sumLeft;
	
	private int right;	// starting weight on right side
	private List<Integer> addRight; 
	private int sumRight;
	
	private Scale() {
		addLeft = new ArrayList<>();
		addRight = new ArrayList<>();
	}
	
	public Scale(int l, int r) {
		this();
		
		left = sumLeft = l;
		right = sumRight = r;
	}
	
	public Scale(int[] arr) throws Exception {
		this();
		
		if(arr.length != 2)
			throw new Exception("Two arguments expected. Received: " + arr.length);
		
		left = sumLeft = arr[LEFT_INDEX];
		right = sumRight = arr[RIGHT_INDEX];
	}
	
	public void addLeft(int i) {
		addLeft.add(i);
		sumLeft += i;
	}
	
	public void addRight(int i) {
		addRight.add(i);
		sumRight += i;
	}
	
	public boolean removeWeightLeft(int i) {
		boolean removed = addLeft.remove(Integer.valueOf(i));
		if(removed) sumLeft -= i;
		
		return removed;
	}
	
	public boolean removeWeightRight(int i) {
		boolean removed = addRight.remove(Integer.valueOf(i));
		if(removed) sumRight -= i;
		
		return removed;
	}
	
	public int[] weightsUsed() {
		int[] out = IntStream.concat(
				addLeft.stream().mapToInt(i -> i), addRight.stream().mapToInt(i -> i))
			.toArray();
		
		Arrays.sort(out);
		
		return out;
	}
	
	public int startingLeft() { return left; }
	public int startingRight() { return right; }
	
	public int sumLeft() { return sumLeft; }
	public int sumRight() { return sumRight; }
	
	public boolean isBalanced() { return sumLeft == sumRight; }
	public int difference() { return Math.abs(sumLeft - sumRight); }
	
	public String toString() {
		return String.format("[%d, %d]", left, right);
	}
}
