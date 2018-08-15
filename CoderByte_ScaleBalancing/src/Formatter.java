import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Formatter {

	public Formatter() { }
	
	public int[] stringToIntArray(String s) {
		String[] segments = s.replaceAll("\\[|\\]", "").split(",\\s*");
		int[] out = new int[segments.length];
		
		for(int i = 0; i < segments.length; i++) {
			out[i] = Integer.parseInt(segments[i]);
		}
		
		return out;
	}
	
	public List<Integer> stringToIntList(String s) {
		return IntStream.of(stringToIntArray(s)).boxed().collect(Collectors.toList());
	}
	
	public String intArrayToString(int[] arr) {
		return Arrays.toString(arr);
	}
}
