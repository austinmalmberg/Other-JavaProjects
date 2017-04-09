import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;


public class MainPanel extends JPanel {

	public MainPanel() {		
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		setBackground(Color.BLACK);
		
		JPanel left = new JPanel();
		left.setBackground(Color.ORANGE);
		
		JPanel right = new JPanel();
		right.setBackground(Color.WHITE);
		
		add(left);
		add(right);
	}
}
