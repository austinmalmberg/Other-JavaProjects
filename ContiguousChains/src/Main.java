	import java.io.*;
	
	public class Main {
		public static void main(String[] args) {
			ContiguousChains c1 = new ContiguousChains("Chains1.txt", 'x');
			c1.countChains();
			c1.printArray();
			
			ContiguousChains c2 = new ContiguousChains("Chains2.txt", 'x');
			c2.countChains();
			c2.printArray();
			
			ContiguousChains c3 = new ContiguousChains("Chains3.txt", 'x');
			c3.countChains();
		}
	}
	
	class ContiguousChains {
		
		private String filename;
		private char chain_link;
		
		private int rows;
		private int cols;
		
		private char[][] arr;
		
		public ContiguousChains(String filename, char chain_link) {
			this.filename = filename;
			this.chain_link = chain_link;
			
			String bounds;
			String line;
			
			try {
				// throws IOException
				BufferedReader br = new BufferedReader(new FileReader(new File(filename)));
				
				bounds = br.readLine();  // get first line (containing array dimensions)
				
				// throws NumberFormatException
				rows = Integer.parseInt(bounds.trim().substring(0, bounds.indexOf(" ")));
				cols = Integer.parseInt(bounds.trim().substring(bounds.indexOf(" ") + 1));
				
				arr = new char[rows][cols];
				
				line = br.readLine();
				int row = 0;
				
				while(line != null) {
	
					for(int i = 0; i < cols; i++) {
						arr[row][i] = line.charAt(i);
					}
					
					line = br.readLine();
					row++;
				}
				
				br.close();
			} catch(IOException ioe) {
				System.out.println("File could not be imported.");
			} catch(NumberFormatException nfe) {
				System.out.println("Bounds could not be retrieved.");
			}
		}
		
			public void countChains() {
				int count = 0;
				
				long start = System.nanoTime(); 
				
				// find x.  follow chain to end
				for(int i = 0; i < rows; i++) {
					for(int j = 0; j < cols; j++) {
						if(arr[i][j] == chain_link) {
							count++;
							findChain(i, j, ((count-1) % 26) + 65);
						}
					}
				}
				
				long elapsed = (System.nanoTime() - start);
				
				System.out.printf("Chains in %s: %d (Completed in %d nanoseconds)%n", filename, count, elapsed);
//				printArray();
		
			}
		
		private void findChain(int r, int c, int letter) {
			arr[r][c] = (char)letter;  // ssign a different letter (A-Z) to the current chain.  adds a few milliseconds, but good for printing out the chains 
			
			// test up
			if(r-1 >= 0 && arr[r-1][c] == chain_link) {
				findChain(r-1, c, letter);
			}
			
			// test left
			if(c-1 >= 0 && arr[r][c-1] == chain_link) {
				findChain(r, c-1, letter);
			}
			
			// test right
			if(c+1 < cols && arr[r][c+1] == chain_link) {
				findChain(r, c+1, letter);
			}
			
			// test down
			if(r+1 < rows && arr[r+1][c] == chain_link) {
				findChain(r+1, c, letter);
			}
		
		}
		
		public void printArray() {		
			for(int i = 0; i < rows; i++) {
				for(int j = 0; j < cols; j++) {
					System.out.print(arr[i][j]);
				}
				System.out.println();
			}
			
			System.out.println();
		}
	}