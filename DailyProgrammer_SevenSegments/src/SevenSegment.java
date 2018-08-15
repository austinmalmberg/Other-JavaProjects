import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SevenSegment {
	
	private final String[][] DISPLAY_SEGMENTS = {
			{" _ ",
			 "| |",
			 "|_|"},
			
			{"   ",
			 "  |",
			 "  |"},
			
			{" _ ",
			 " _|",
			 "|_ "},
			
			{" _ ",
			 " _|",
			 " _|"},
			
			{"   ",
			 "|_|",
			 "  |"},
			
			{" _ ",
			 "|_ ",
			 " _|"},
			
			{" _ ",
			 "|_ ",
			 "|_|"},
			
			{" _ ",
			 "  |",
			 "  |"},
			
			{" _ ",
			 "|_|",
			 "|_|"},
			
			{" _ ",
			 "|_|",
			 " _|"}
	};
	
	private List<String[]> segments;
	
	public SevenSegment() {
		segments = new ArrayList<>();
	}
	
	public SevenSegment(String[] input) {
		this();
		
		// divide strings into 3x3 segments
		for(int i = 0; i < input[0].length(); i += 3) {
			segments.add(
					new String[]{
						input[0].substring(i, i+3),
						input[1].substring(i, i+3),
						input[2].substring(i, i+3)});
		}
	}

	private int getInt(String[] seg) throws NumberFormatException {
		for(int i = 0; i < DISPLAY_SEGMENTS.length; i++) {
			if(Arrays.equals(DISPLAY_SEGMENTS[i], seg)) return i;
		}
		
		throw new NumberFormatException(Arrays.toString(seg) + " not recognized.");
	}
	
	public String toString() {
		StringBuilder output = new StringBuilder();
		segments.forEach(seg -> output.append(getInt(seg)));
		
		return output.toString();
	}
}
