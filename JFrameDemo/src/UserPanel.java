import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class UserPanel extends JPanel {
	
	private JPanel counts;
	private JLabel currentCount;
	private JLabel soldCount;
	
	private JPanel username;
	
	
	private JPanel profit;

	public UserPanel() {
		setPreferredSize(new Dimension(Frame.WIDTH, Frame.HEIGHT/10));
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		counts = new JPanel();
		counts.setPreferredSize(new Dimension(Frame.WIDTH/4, Frame.HEIGHT));
		counts.setBackground(Color.CYAN);
		
		currentCount = new JLabel("Current Inventory: 4 items");
		
		counts.add(currentCount);
		
		username = new JPanel();
		username.setPreferredSize(new Dimension(Frame.WIDTH/2, Frame.HEIGHT));
		username.setBackground(Color.GREEN);
		
		profit = new JPanel();
		profit.setPreferredSize(new Dimension(Frame.WIDTH/4, Frame.HEIGHT));
		profit.setBackground(Color.RED);
		
		add(counts);
		add(username);
		add(profit);
	}
}
