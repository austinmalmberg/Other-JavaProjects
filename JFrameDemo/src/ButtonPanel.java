import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class ButtonPanel extends JPanel {

	public ButtonPanel() {
		// button panel properties
		setPreferredSize(new Dimension(Frame.WIDTH, Frame.HEIGHT/18));
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		setBackground(Color.CYAN);
		
		// logout label
		JLabel logout = new JLabel("Logout", JLabel.CENTER);
		logout.setPreferredSize(new Dimension(Frame.WIDTH/4, Frame.HEIGHT/10));
		logout.setFont(new Font("Arial", Font.PLAIN, 30));
		logout.setOpaque(true);
		logout.setBackground(Color.RED);
		
		// current inventory label
		JLabel current = new JLabel("View Current", JLabel.CENTER);
		current.setPreferredSize(new Dimension(Frame.WIDTH/4, Frame.HEIGHT/10));
		current.setFont(new Font("Arial", Font.PLAIN, 30));
		current.setOpaque(true);
		current.setBackground(Color.DARK_GRAY);
		
		// sold inventory label
		JLabel sold = new JLabel("View Sold", JLabel.CENTER);
		sold.setPreferredSize(new Dimension(Frame.WIDTH/4, Frame.HEIGHT/10));
		sold.setFont(new Font("Arial", Font.PLAIN, 30));
		sold.setOpaque(true);
		sold.setBackground(Color.BLUE);
		
		// addItem inventory label
		JLabel addItem = new JLabel("Add Item", JLabel.CENTER);
		addItem.setPreferredSize(new Dimension(Frame.WIDTH/4, Frame.HEIGHT/10));
		addItem.setFont(new Font("Arial", Font.PLAIN, 30));
		addItem.setOpaque(true);
		addItem.setBackground(Color.GREEN);
		
		// add labels to panel
		add(logout);
		add(current);
		add(sold);
		add(addItem);
	}
}
