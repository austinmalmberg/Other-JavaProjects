package ap.panels;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;


public class LoginPanel extends Panel {
	private static final long serialVersionUID = 1L;
	
	
	JLabel loginText;
	
	public LoginPanel(PanelManager pm) {
		this.pm = pm;
		
		setPreferredSize(new java.awt.Dimension(AmericanPickers.WIDTH, AmericanPickers.HEIGHT));
		setOpaque(true);
		setBackground(Color.RED);
		
		init();
	}

	public void init() {
		loginText = new JLabel("Click anywhere to login.", JLabel.CENTER);
		loginText.setFont(new Font("Ariel", Font.PLAIN, 20));
		loginText.setOpaque(false);
		
		add(loginText);
	}
	
	public void update() {
		
	}
	
	public void draw() {

	}
	
	@Override
	public void mouseClicked(java.awt.Component c) {
		if (c.equals(this)) {
			System.out.println("true");
			pm.setPanel(PanelManager.USER_PANEL);
			this.setVisible(false);
		} else {
			System.out.println("false");
		}
		
	}
}
