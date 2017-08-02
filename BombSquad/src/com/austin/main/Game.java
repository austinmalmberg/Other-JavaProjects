package com.austin.main;

import javax.swing.JFrame;

// stop blinking when defused or detonated
// fix clipboard formatting
// mouseover on menustate
// implement wiring
// lose when attempts goes to zero

public class Game {
	public static void main(String[] args) {
		JFrame window = new JFrame("Bomb Squad");
		window.setContentPane(new GamePanel());
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.pack();
		window.setVisible(true);
	}
}
