package com.wristwatch;

import javax.swing.JFrame;

import com.wristwatch.userinterface.UserInterface;

public class Main {
	
	public static void main(String[] args) {
		
		UserInterface ui = new UserInterface();
		
		JFrame window = new JFrame("My Stopwatch");
		window.setContentPane(ui);
		window.pack();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setVisible(true);
	}
	
	
}
