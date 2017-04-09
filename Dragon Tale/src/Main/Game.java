package Main;

import javax.swing.JFrame;


public class Game {
	
	// problems:
	// player sprite does not update when walking

	public static void main(String[] args) {
		JFrame window = new JFrame("Dragon Tale");
		window.setContentPane(new GamePanel());
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.pack();
		window.setVisible(true);
	}
	
}
