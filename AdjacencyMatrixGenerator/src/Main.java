import java.awt.Point;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;


public class Main {
	public static void main(String[] args) {
		AdjacencyMatrix s1 = new AdjacencyMatrix("Sample1.txt");
		s1.printGraph();
		s1.generate();
//		new AdjacencyMatrix("Sample2.txt").generate();
//		new AdjacencyMatrix("Sample3.txt").generate();
//		new AdjacencyMatrix("Sample4.txt").generate();
//		new AdjacencyMatrix("Sample5.txt").generate();
	}
}

class AdjacencyMatrix {
	private final int NOT_CONNECTED = 0;
	private final int CONNECTED = 1;
	
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
		}
		
		node_values = sb.toString();
		
		matrix = new byte[nodes.size()][nodes.size()];
	}
	
	public void generate() {
		// search array for char
			// check each direction for adjacent lines
				// follow lines until it meets another char
					// update matrix
		
		for(int i = 0; i < nodes.size(); i++) {
			testDirections(nodes.get(i));
		}
	}
	
	// checks each direction for connectors 
	private void testDirections(Point p) {		
		if(p.x + 1 <= width - 1 && graph[p.x + 1][p.y] == '-') 
			findConnectingNode(new Point(p.x + 1, p.y), RIGHT);
		
		if(p.x + 1 <= width - 1 && p.y + 1 <= height - 1 && graph[p.x + 1][p.y + 1] == '\\') 
			findConnectingNode(new Point(p.x + 1, p.y + 1), DOWN_RIGHT);
		
		if(p.y + 1 <= height - 1 && graph[p.x][p.y + 1] == '|') 
			findConnectingNode(new Point(p.x, p.y + 1), DOWN);
		
		if(p.x >= 0 && p.y + 1 <= height - 1 && graph[p.x - 1][p.y + 1] == '/') 
			findConnectingNode(new Point(p.x - 1, p.y + 1), DOWN_LEFT);
		
		if(p.x - 1 >= 0 && graph[p.x - 1][p.y] == '-') 
			findConnectingNode(new Point(p.x - 1, p.y), LEFT);
		
		if(p.x - 1 >= 0 && p.y - 1>= 0 && graph[p.x - 1][p.y - 1] == '\\') 
			findConnectingNode(new Point(p.x - 1, p.y - 1), UP_LEFT);
		
		if(p.y - 1 >= 0 && graph[p.x][p.y - 1] == '|') 
			findConnectingNode(new Point(p.x, p.y - 1), UP);
		
		if(p.x + 1 <= width - 1 && p.y - 1 >= 0 && graph[p.x + 1][p.y - 1] == '/') 
			findConnectingNode(new Point(p.x + 1, p.y - 1), UP_RIGHT);
		
		
	}
	
	private char findConnectingNode(Point p, int direction) {
		
		while(!Character.isLetter(graph[p.x][p.y]) || graph[p.x][p.y] != '#') {
			if(direction == RIGHT) p.setLocation(p.x + 1, p.y);
			if(direction == DOWN_RIGHT) p.setLocation(p.x + 1, p.y + 1);
			if(direction == DOWN) p.setLocation(p.x, p.y + 1);
			if(direction == DOWN_LEFT) p.setLocation(p.x - 1, p.y + 1);
			if(direction == LEFT) p.setLocation(p.x - 1, p.y);
			if(direction == UP_LEFT) p.setLocation(p.x - 1, p.y - 1);
			if(direction == UP) p.setLocation(p.x, p.y - 1);
			if(direction == UP_RIGHT) p.setLocation(p.x + 1, p.y - 1);
		}
		
		if(graph[p.x][p.y] == '#') testDirections(new Point(p.x, p.y));
		
		return graph[p.x][p.y];
	}
	
	public void printGraph() {
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				System.out.print(graph[x][y]);
			}
			System.out.println();
		}
	}
}
