package com.austin.weekly.maze;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import com.austin.weekly.maze.objects.Direction;
import com.austin.weekly.maze.objects.Player;

/**
 * Description
	
	We are going to create a mini game. I'm going post updates with ideas, if you guys have them.
	The goal of the game is to escape a maze and not get eaten by the trolls.
	Phases of the game
	
	Phase 1
	Create your character and make it moveable. You can use this amazing maze (see what I did there?) or create one yourself. If you are going to use ASCII for the game, I suggest you use <>v^ for your character since direction becomes important.
	
	Place the character in a random spot and navigate it to the exit. X marks the exit.
	
	Phase 2
	We have a more powerfull character now. He can push blocks that are in front of him. He can only push blocks into an empty space, not into another block.
	e.g.
	Can push
	
	#   #     
	# > #   ##
	#   #        
	
	Can't push
	
	#   #     
	# > #####
	#   #  
	 
	Phase 3
	Let's add some trolls. Place trolls at random spots and let them navigate to you character. You can avoid the trolls by pushing blocks.
	The trolls should move a block when you move a block, so it is turnbased.
	
	Phase 4
	Generate your own maze.
 * @author mac9812e
 *
 */
public class Main {
	
	public static final String fileName = "maze1.txt";
	
	public static void main(String[] args) throws IOException {
		
		EscapeTheTrolls escape = new EscapeTheTrolls(new File(fileName));
		escape.run();
	}
}

class EscapeTheTrolls {
	private File file;
	
	private Maze map;
	
	private boolean running;
	
	EscapeTheTrolls(File file) {
		this.file = file;
		
		init();
	}
	
	private void init() {		
		map = new Maze(file.toPath());
		
		running = true;
	}
	
	void run() {
		Scanner sc = new Scanner(System.in);
		String input;
		
		map.print();
		
		// game loop
		while(running) {
			prompt();
			input = sc.nextLine().trim();

			if(isValid(input)) {
				map.update(input.charAt(0));
			
				map.print();
				
				if(map.playerEscaped() || map.playerDead())
					running = false;
			}
		}
		
		if(map.playerEscaped()) showWinningMessage();
		if(map.playerDead()) showLosingMessage();
		
		sc.close();
	}

	private boolean isValid(String str) {
		boolean valid = !str.isEmpty() ? Player.DIRECTIONS.contains(str) : false;
		
		if(!valid) System.out.println("Invalid directional input.");
		
		return valid;
	}
	
	private void prompt() {
		System.out.printf("Enter a direction [%s = %s, %s = %s, %s = %s, %s = %s] : ",
				Direction.values()[0], Character.toUpperCase(Player.DIRECTIONS.charAt(0)),
				Direction.values()[1], Character.toUpperCase(Player.DIRECTIONS.charAt(1)),
				Direction.values()[2], Character.toUpperCase(Player.DIRECTIONS.charAt(2)),
				Direction.values()[3], Character.toUpperCase(Player.DIRECTIONS.charAt(3)));
	}
	
	private void showWinningMessage() {
		System.out.println("Congratulations!!! You made it out alive!");
	}
	
	private void showLosingMessage() {
		System.out.println("You lose...");
	}
}
