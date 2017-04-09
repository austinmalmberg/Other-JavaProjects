import java.util.TreeSet;

public class SetData {
	
	// data
	public static final String STR_1 = "Alphabetical banter can deter everyone's friend, greg; he's illiterate.";
	public static final String STR_2 = "My friend, greg, is literate; Alphabetical banter can deter anyone.";
	
	public static final int[] INT_ARR_1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	public static final int[] INT_ARR_2 = { 2, 3, 5, 7 };
	
	// sets
	private TreeSet<String> strSet1;
	private TreeSet<String> strSet2;
	
	private TreeSet<Integer> intSet1;
	private TreeSet<Integer> intSet2;
	
	private TreeSet<Foo> fooSet1;
	private TreeSet<Foo> fooSet2;
	
	public SetData() {
		strSet1 = convString2Set(STR_1);
		strSet2 = convString2Set(STR_2);
		
		intSet1 = convInts2Set(INT_ARR_1);
		intSet2 = convInts2Set(INT_ARR_2);
		
		fooSet1 = new TreeSet<Foo>();
//		fooSet1.add(new Foo("Foo", "D"));
//		fooSet1.add(new Foo("Foo", "Seball"));
//		fooSet1.add(new Foo("Foo", "T"));
//		
//		fooSet2 = new TreeSet<Foo>();
//		fooSet2.add(new Foo("Foo", "Bar"));
//		fooSet2.add(new Foo("Foo", "Led"));
//		fooSet2.add(new Foo("Kung", "Foo"));
	}
	
	private TreeSet<String> convString2Set(String str) {
		TreeSet<String> set = new TreeSet<String>();
		String[] strArr = str.split(" ");
		
		for (String word : strArr) {
			set.add(word);
		}
		
		return set;
	}
	
	private TreeSet<Integer> convInts2Set(int[] intArr) {
		TreeSet<Integer> set = new TreeSet<Integer>();
		
		for (Integer num : intArr) {
			set.add(num);
		}
		
		return set;
	}
	
	public TreeSet<String> getStrSet1() { return strSet1; }
	public TreeSet<String> getStrSet2() { return strSet2; }
	
	public TreeSet<Integer> getIntSet1() { return intSet1; }
	public TreeSet<Integer> getIntSet2() { return intSet2; }
	
	public TreeSet<Foo> getFooSet1() { return fooSet1; }
	public TreeSet<Foo> getFooSet2() { return fooSet2; }
}
