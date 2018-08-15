
// https://coderbyte.com/editor/Scale%20Balancing:Java

public class Main {

	public static void main(String[] args) {
		String[] input1 = {"[3, 4]", "[1, 2, 7, 7]"};		// output: "1"
		String[] input2 = {"[13, 4]", "[1, 2, 3, 6, 14]"};	// output: "3,6"
		
		System.out.println(new ScaleBalancer(input1).balance().weightsUsed());
		System.out.println(new ScaleBalancer(input2).balance().weightsUsed());
	}
}
