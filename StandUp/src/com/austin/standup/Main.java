package com.austin.standup;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import com.austin.standup.panels.StandUpPanel;

public class Main {
	public static void main(String[] args) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		JFrame window = new JFrame("Stand Up!");
		window.setContentPane(new StandUpPanel());
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocation(screenSize.width - StandUpPanel.PANEL_WIDTH - 12,
				screenSize.height - StandUpPanel.PANEL_HEIGHT - 60);
		window.pack();
		window.setVisible(true);
	}
}
