import java.util.Set;
import java.util.TreeSet;

public class CompareSets {
	
	public <T> Set<T> getUnions(Set<T> set1, Set<T> set2) {
		Set<T> unions = new TreeSet<T>();
		
		for (T item: set1) {
			if (set2.contains(item)) {
				unions.add(item);
			}
		}		
		
		return unions;
	}
	
	public <T> Set<T> getIntersections(Set<T> set1, Set<T> set2) {
		Set<T> intersections = new TreeSet<T>();
		
		for (T item: set1) {
			if (!set2.contains(item)) {
				intersections.add(item);
			}
		}
		
		for (T item: set2) {
			if (!set1.contains(item)) {
				intersections.add(item);
			}
		}
		
		return intersections;
	}
}
