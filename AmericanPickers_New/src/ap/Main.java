package ap;
import javax.swing.JFrame;

import ap.panels.AmericanPickers;


public class Main {

	public static void main(String[] args) {
		JFrame window = new JFrame("American Pickers");
		window.setContentPane(new AmericanPickers());
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.pack();
		window.setResizable(false);
		window.setVisible(true);
	}

}
