import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * [2018-02-23] Challenge #352 [Hard] Well, Well, Well
 * https://www.reddit.com/r/dailyprogrammer/comments/7zriir/20180223_challenge_352_hard_well_well_well/
 * 
 * @author Austin Malmberg
 *
 */
public class Main {

	public static void main(String[] args) {
		String[] challenges = {
				"Example1.txt",
				"Challenge1.txt",
				"Challenge2.txt"
		};
		
		for(String fileName : challenges) {
			String[] file = importFile(fileName);
			int[][] topography = asTopographyMap(Arrays.copyOfRange(file, 1, file.length-1));
			int targetTile = Integer.parseInt(file[file.length-1]);
			
			Well well = new Well(topography, targetTile);
			well.displayWaterlevels();
			System.out.println(well.timeToFill() + " seconds");
		}
	}
	
	public static int[][] asTopographyMap(String[] arr) {
		return Stream.of(arr)
				.map(str -> Stream.of(str.split("\\s+"))
						.mapToInt(Integer::parseInt)
						.toArray())
				.toArray(int[][]::new);
	}
	
	public static String[] importFile(String fileName) {
		try {
			return Files.lines(new File(fileName).toPath())
					.map(String::trim)
					.toArray(String[]::new);
		} catch(IOException io) {
			io.printStackTrace();
		}
		
		return null;
	}
}
