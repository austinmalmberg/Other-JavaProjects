import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		System.out.println(new Shuffle("apple blackberry cherry dragonfruit grapefruit kumquat mango nectarine persimmon raspberry raspberry").toString());		
		System.out.println(new Shuffle("a e i o u").toString());
		System.out.println(new Shuffle("1 2 3 4 5 6 7 8").toString());
	}
}

class Shuffle {
	private ArrayList<String> list;
	
	public Shuffle(String s) {		
		list = new ArrayList<>(java.util.Arrays.asList(s.split("\\s+")));
		java.util.Collections.shuffle(list);
		
	}
	
	public String toString() {
		return list.toString();
	}
}
