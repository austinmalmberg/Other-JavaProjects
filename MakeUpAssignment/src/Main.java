import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;


public class Main {

	public static void main(String[] args) {
		SetData data = new SetData();
		CompareSets comp = new CompareSets();
		
		Set<String> strSet1 = data.getStrSet1();
		Set<String> strSet2 = data.getStrSet2();
		Set<String> strUnions = comp.getUnions(strSet1, strSet2);
		Set<String> strIntersections = comp.getIntersections(strSet1, strSet2);
		
		System.out.println("String 1: " + SetData.STR_1);
		System.out.println("String 2: " + SetData.STR_2);
		// System.out.println("StringSet1: " + strSet1.toString());
		// System.out.println("StringSet2: " + strSet2.toString());
		
		System.out.println("\nThe following words are shared between the above string sets: " + strUnions.toString());
		System.out.println("The following words are NOT shared in the above string sets: " + strIntersections.toString());
		
		System.out.println("\n--------------------------------------");
		
		Set<Integer> intSet1 = data.getIntSet1();
		Set<Integer> intSet2 = data.getIntSet2();
		Set<Integer> intUnions = comp.getUnions(intSet1, intSet2);
		Set<Integer> intIntersections = comp.getIntersections(intSet1, intSet2);
		
		System.out.println("\nIntegerSet1: " + Arrays.toString(SetData.INT_ARR_1));
		System.out.println("IntegerSet2: " + Arrays.toString(SetData.INT_ARR_2));
		
		System.out.println("\nThe following numbers are shared between the above integer sets: " + intUnions.toString());
		System.out.println("The following numbers are NOT shared in the above integer sets: " + intIntersections.toString());
		
		Set<Foo> fooSet1 = data.getFooSet1();
		Set<Foo> fooSet2 = data.getFooSet2();
		
		
	}
}
