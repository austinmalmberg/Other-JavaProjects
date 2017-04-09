package ap;

import javax.swing.JFrame;

import ap.ui.UserInterface;

public class AmericanPickers {
	public static void main(String[] args) {
		JFrame window = new JFrame("American Pickers");
		window.setContentPane(new UserInterface());
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.pack();
		window.requestFocus();
	}
}
