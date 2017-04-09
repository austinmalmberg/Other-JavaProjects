import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ConnectFour implements Runnable {
	
	private final int CONSECUTIVE_PIECES_TO_WIN = 4;

	private final char BLANK = '-';
	private final char PLAYER_1 = 'X';
	private final char PLAYER_2= 'O';
	
	private final char[] COL_NAMES = {'a', 'b', 'c', 'd', 'e', 'f', 'g'};
	
	private final int COLS = COL_NAMES.length;  // 7
	private final int ROWS = 6;
	
	private char[][] board;
	
	private boolean turn;
	
	private Random rnd;
	
	private Scanner sc;
	
	public ConnectFour() {
		board = new char[ROWS][COLS];
		
		rnd = new Random();
		
		sc = new Scanner(System.in);
	}
	
	public void run() {
		
		initializeBoard();
		
		int earliestWin = (CONSECUTIVE_PIECES_TO_WIN - 1) * 2;
		
		// determine who goes first
		System.out.println("Flipping coin...");
		turn = rnd.nextBoolean();
		
		if(turn) {
			System.out.println("Heads! '" + PLAYER_1 + "' goes first!\n");
		} else {
			System.out.println("Tails! '" + PLAYER_2 + "' goes first!\n");
		}
		
		// GAME LOOP
		for(int i = 0; i < ROWS * COLS; i++) {
			if(turn) {
				placeMove(PLAYER_1, getMove(PLAYER_1));
				if(i >= earliestWin) {  // player cannot win until enough moves are made
					if(isWinner(PLAYER_1)) break;
				}
			} else {
				placeMove(PLAYER_2, getMove(PLAYER_2));
				if(i >= earliestWin) {  // player cannot win until enough moves are made
					if(isWinner(PLAYER_2)) break;  // breaks game loop
				}
			}
			
			turn = turn ? false : true;  // change turns
			
			if(i >= ROWS * COLS - 1) System.out.println("It's a tie!");
		}
		
		sc.close();
	}
	
	private void initializeBoard() {
		
		for(int x = 0; x < ROWS; x++) {
			for(int y = 0; y < COLS; y++) {
				board[x][y] = BLANK;
			}
		}
		
		displayBoard();
	}
	
	private void displayBoard() {
		
		System.out.println();
		
		// print column names
		System.out.print("   ");
		for(int i = 0; i < COL_NAMES.length; i++) {
			System.out.print(COL_NAMES[i] + " ");
		}
		System.out.println();
		
		// print board
		for(int x = 0; x < ROWS; x++) {
			System.out.printf("%2d ", ROWS - x);
			for(int y = 0; y < COLS; y++) {
				System.out.print(board[x][y] + " ");
			}
			System.out.println();
		}
		
		System.out.println();
	}

	private int getMove(char p) {
		
		String input = "";
		
		boolean valid = false;
		
		System.out.println("-----" + p + "'s Move!-----");
		
		while(!valid) {
			System.out.print("Enter column (" + COL_NAMES[0] + "-" + COL_NAMES[COL_NAMES.length - 1] + "): ");
			input = sc.nextLine().trim().toLowerCase();

			
			if(input.matches("[" + COL_NAMES[0] + "-" + COL_NAMES[COL_NAMES.length - 1] + "]{1}")) {  // test that the input is only 1 character between a-g
				if(board[0][(int)input.charAt(0) - 97] == BLANK) {  // test that the column is not full
					valid = true;
				} else {
					System.out.print("That column is full!  ");
				}
			} else {
				System.out.print("Invalid input.  ");
			}
		}
		
		return (int)input.charAt(0) - 97;
	}
	
	private void placeMove(char p, int col) {
		
		for(int i = 0; i < ROWS; i++) {
			if(board[(ROWS - 1) - i][col] == BLANK) {
				board[(ROWS - 1) - i][col] = p;
				break;
			}
		}
		
		displayBoard();
	}
	
	private boolean isWinner(char p) {  // determines if winner
		
		int consecutiveHori;  // consecutive -- marks
		
		int mod_i;  // modified value for testing diagonals
		
		String[] winningArray = new String[CONSECUTIVE_PIECES_TO_WIN];
		
		// test horizontal
		for(int i = 0; i < ROWS; i++) {
			consecutiveHori = 0;
			
			for(int j = 0; j < COLS; j++) {
				if(board[i][j] == p) {
					consecutiveHori++;
					winningArray[consecutiveHori - 1] = Character.toString((char)(j + 97)) + (ROWS - i);
					if(consecutiveHori >= CONSECUTIVE_PIECES_TO_WIN) {
						System.out.println("'" + p + "' wins horizontally! " + Arrays.toString(winningArray));
						return true;
					}
				} else {
					consecutiveHori = 0;
				}
			}
		}
		
		for(int i = 0; i < COLS; i++) {

		// test vertical
			int consecutiveVert;  // consecutive | marks
			consecutiveVert = 0;
			
			for(int j = 0; j < ROWS; j++) {
				if(board[(ROWS - 1) - j][i] == p) {
					consecutiveVert++;
					winningArray[consecutiveVert - 1] = Character.toString((char)(i + 97)) + (j + 1);
					if(consecutiveVert >= CONSECUTIVE_PIECES_TO_WIN) {
						System.out.println("'" + p + "' wins vertically! " + Arrays.toString(winningArray));
						return true;
					}
				} else {
					consecutiveVert = 0;
				}
			}

		// test diagonal from bottom left to top right
			int consecutiveDiag1;  // consecutive / diagonal marks
			mod_i = i + (CONSECUTIVE_PIECES_TO_WIN - 1);  // 3 when i is 0
			
			consecutiveDiag1 = 0;
			
			for(int j = 0; j < COLS; j++) {
				if(mod_i - j < 0) break;  // break inner loop when index gets out of range
				
				if(mod_i - j < ROWS) {
					if(board[mod_i - j][j] == p) {
						consecutiveDiag1++;
						winningArray[consecutiveDiag1 - 1] = Character.toString((char)(j + 97)) + (ROWS - (mod_i - j));
						if(consecutiveDiag1 >= CONSECUTIVE_PIECES_TO_WIN) {
							System.out.println("'" + p + "' wins diagonally! " + Arrays.toString(winningArray));
							return true;
						}
					} else {
						consecutiveDiag1 = 0;
					}
				}
			}
			
		// test diagonal from top left to bottom right
			int consecutiveDiag2;  // consecutive \ diagonal marks
			mod_i = i - (CONSECUTIVE_PIECES_TO_WIN - 1);  // -3 when i is 0
			
			consecutiveDiag2 = 0;
			
			for(int j = 0; j < ROWS; j++) {
				if(mod_i + j > COLS - 1) break;  // breaks inner loop when index exceeds cols
				
				if(mod_i + j >= 0) {
					if(board[j][mod_i + j] == p) {
						consecutiveDiag2++;
						winningArray[consecutiveDiag2 - 1] = Character.toString((char)(mod_i + j + 97)) + (ROWS - j);
						if(consecutiveDiag2 >= CONSECUTIVE_PIECES_TO_WIN) {
							System.out.println("'" + p + "' wins diagonally! " + Arrays.toString(winningArray));
							return true;
						}
					} else {
						consecutiveDiag2 = 0;
					}
				}
			}
		}
		
		return false;
	}
}
