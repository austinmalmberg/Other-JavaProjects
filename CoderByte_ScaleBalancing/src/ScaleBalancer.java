import java.util.List;

public class ScaleBalancer {

	private final int SCALE_INDEX = 0;
	private final int BAG_INDEX = 1;
	
	private Scale scale;
	private List<Integer> bag;
	
	private Formatter formatter;
	
	private ScaleBalancer() {
		formatter = new Formatter();
	}
	
	public ScaleBalancer(String[] arr) {
		this();
		
		try {
			scale = new Scale(formatter.stringToIntArray(arr[SCALE_INDEX]));
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		bag = formatter.stringToIntList(arr[BAG_INDEX]);
		
		System.out.println(scale.toString());
		System.out.println(bag.toString());
	}
	
	// max of two weights used to balance
	public ScaleBalancer balance() {
		if(!scale.isBalanced())
			testOneWeight();
		
		if(!scale.isBalanced())
			testTwoWeights();
		
		return this;
	}
	
	private void testOneWeight() {
		int diff = scale.difference();
		
		if(bag.contains(diff)) {
			if(scale.sumLeft() < scale.sumRight())
				scale.addLeft(diff);
			else {
				scale.addRight(diff);
			}
		}
	}
	
	private void testTwoWeights() {
		// both weights on one side
			// create a HashMap of all sums
		
		// split weights
	}
	
	public String weightsUsed() {
		return formatter.intArrayToString(scale.weightsUsed()).replaceAll("\\[|\\]|\\s", "");
	}
}
