import java.nio.CharBuffer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Tessallation {
		
	private Map<Character, Node<Character>> map;
	
	private int rotation;
	private Character[][] pattern2DArray;
	private Character[][] tessallation;
	
	
	@SuppressWarnings("serial")
	public Tessallation() {
		// initialize map
		map = new HashMap<Character, Node<Character>>() {
			{
				put('#', new Node<>('#'));
				put('-', new Node<>('-', '|'));
				put('|', new Node<>('|', '-'));
				put('+', new Node<>('+'));
				
				put('/', new Node<>('/', '\\'));
				put('\\', new Node<>('\\', '/'));
				
				put('v', new Node<>('v', '<', '^', '>'));
				put('<', new Node<>('<', '^', '>', 'v'));
				put('^', new Node<>('^', '>', 'v', '<'));
				put('>', new Node<>('>', 'v', '<', '^'));
				
//				put('&', new Node<>('&', '8'));
//				put('`', new Node<>('`', '\'', '.', '.'));
//				put('{', new Node<>('{', '~', '}', '~'));
//				put('!', new Node<>('!', '-', 'i', '-'));
//				put(';', new Node<>(';', '~'));
			}
		};
	}
	
	public Tessallation(String[] file) {
		this();
		
		this.rotation = Integer.parseInt(file[0].trim());
		String[] origPattern = Arrays.copyOfRange(file, 2, file.length);
		
		// convert String[] to Character[][]
		this.pattern2DArray = Stream.of(origPattern)
				.map(Tessallation::convertToCharacterArray)
				.toArray(Character[][]::new);
		
		// rotate and combined the arrays
		this.tessallation = combine2DCharacterArrays(
				rotatePattern(pattern2DArray, rotation*0),
				rotatePattern(pattern2DArray, rotation*1),
				rotatePattern(pattern2DArray, rotation*2),
				rotatePattern(pattern2DArray, rotation*3));
	}
	
	/**
	 * Converts String to Character[].
	 * @param s The string to be converted.
	 */
	private static Character[] convertToCharacterArray(String s) {
		return CharBuffer.wrap(s.toCharArray()).chars().mapToObj(ch -> (char) ch).toArray(Character[]::new);
	}
	
	/**
	 * Combines four Character[][] into a single Character[][].  Order is as follows
	 * 
	 * arr0 arr1
	 * arr3 arr2
	 * 
	 * @return
	 */
	private Character[][] combine2DCharacterArrays(Character[][] arr0, Character[][] arr1, Character[][] arr2, Character[][] arr3) {
		
		Character[][] left = Stream.of(arr0, arr3)
				.flatMap(Stream::of)
				.toArray(Character[][]::new);
		
		Character[][] right = Stream.of(arr1, arr2)
				.flatMap(Stream::of)
				.toArray(Character[][]::new);
		
		return IntStream.range(0, arr0.length*2)
				.mapToObj(i -> combineCharacterArrays(left[i], right[i]))
				.toArray(Character[][]::new);
	}
	
	private Character[] combineCharacterArrays(Character[] c0, Character[] c1) {
		return Stream.of(c0, c1).flatMap(Stream::of).toArray(Character[]::new);
	}
	
	private Character[][] rotatePattern(Character[][] tile, int rotation) {
		// make rotation positive (if needed)
		while(rotation < 0)
			rotation += 360;
		rotation %= 360;
		
		// 0 and 360 degrees of rotation does not change array
		if(rotation == 0 || rotation == 360) return tile;
		
		// return array (for now) if rotation is invalid
		if(rotation % 90 != 0) return tile;
		
		final int UBOUND = tile.length;
		final int RBOUND = tile.length;
		
		Character[][] tileRotated;
		
		if(rotation == 90 || rotation == 270)
			tileRotated = new Character[RBOUND][UBOUND];
		else if(rotation == 0 || rotation == 180)
			tileRotated = new Character[UBOUND][RBOUND];
		else
			return tile;
		
		for(int row = 0; row < UBOUND; row++) {
			for(int col = 0; col < RBOUND; col++) {

				switch(rotation) {
				case 90:
					tileRotated[col][UBOUND-1-row] = rotatedCharacter(tile[row][col], 90);
					break;
				case 180:
					tileRotated[UBOUND-1-row][RBOUND-1-col] = rotatedCharacter(tile[row][col], 180);
					break;
				case 270:
					tileRotated[RBOUND-1-col][row] = rotatedCharacter(tile[row][col], 270);
					break;
				default:
					tileRotated[row][col] = rotatedCharacter(tile[row][col], 0);
					break;
				}
			}
		}
		
		return tileRotated;
	}
	
	private Character rotatedCharacter(Character ch, int rotation) {
		if(!map.containsKey(ch)) return ch;
		
		if(rotation == 90) return map.get(ch).rot90();
		else if(rotation == 180) return map.get(ch).rot180();
		else if(rotation == 270) return map.get(ch).rot270();
		
		return ch;
	}
	
	public String[] getTessallation() {
		return Stream.of(tessallation)  // stream of Character[]
				.map(characterArray -> Stream.of(characterArray).map(String::valueOf).collect(Collectors.joining()))
				.toArray(String[]::new);
	}
}
