package ap.ui;

import java.awt.Dimension;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

public class LoginState extends State {
	
	JPanel loginPanel;

	public LoginState(StateManager sm) {
		this.sm = sm;
		
		init();
	}

	public void init() {
		loginPanel = new JPanel();
		loginPanel.setPreferredSize(new Dimension(UserInterface.WIDTH, UserInterface.HEIGHT));
	}
	
	public JPanel getPanel() {
		return loginPanel;
	}
	
	@Override
	public void mouseClicked(MouseEvent m) {
		
	}

	@Override
	public void mouseEntered(MouseEvent m) {
		
	}

	@Override
	public void mouseExited(MouseEvent m) {
		
	}

	@Override
	public void mousePressed(MouseEvent m) {
		
	}

	@Override
	public void mouseReleased(MouseEvent m) {
		
	}
}
