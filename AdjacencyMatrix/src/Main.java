import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


public class Main {
	public static void main(String[] args) {
		AdjacencyMatrix s1 = new AdjacencyMatrix("Sample1.txt");
//		new AdjacencyMatrix("Sample2.txt").generate();
//		new AdjacencyMatrix("Sample3.txt").generate();
//		new AdjacencyMatrix("Sample4.txt").generate();
//		new AdjacencyMatrix("Sample5.txt").generate();
	}
}

class AdjacencyMatrix {	
	private char[][] graph;
	private final int width = 30;
	private final int height = 15;
	
	private int lines;
	
	private byte[][] matrix;
	
	private String node_values;	
	private ArrayList<Point> nodes;
	
	private final int RIGHT= 0;
	private final int DOWN_RIGHT = 1;
	private final int DOWN = 2;
	private final int DOWN_LEFT = 3;
	private final int LEFT = 4;
	private final int UP_LEFT = 5;
	private final int UP = 6;
	private final int UP_RIGHT = 7;
	
	public AdjacencyMatrix(String filename) {
		graph = new char[width][height];
		
		nodes = new ArrayList<>();
		
		StringBuilder sb = new StringBuilder();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File(filename)));
			
			lines = Integer.parseInt(br.readLine().trim());
			
			String line = br.readLine();
			int col = 0;
			char c;
			
			while(line != null) {				
				for(int i = 0; i < line.length(); i++) {
					c = line.charAt(i);
					
					graph[i][col] = c;
					
					if(Character.isLetter(c)) {
						nodes.add(new Point(i, col));  // add letter point to list
						sb.append(c);  // get letters in graph
					}
				}
				
				line = br.readLine();
				col++;
			}
			
			br.close();
		} catch (FileNotFoundException e) {
			System.out.printf("Unable to read file \"%s\".", filename);
		} catch (IOException e) {
			System.out.println("Unable to convert file to array.");
		} catch (NumberFormatException e) {
			System.out.println("Parsing exception.");
		}
		
		char[] char_arr = sb.toString().toCharArray();
		Arrays.sort(char_arr);
		
		sb.setLength(0);
		for(char c : char_arr) {
			sb.append(c);
		}
		
		node_values = sb.toString();
		
		matrix = new byte[nodes.size()][nodes.size()];
	}
	
	public void generate() {
		// eval each node, following stems to other node_values or #
	}
}