package ap.ui;

import java.awt.Dimension;
import java.awt.event.*;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import ap.profiles.ProfileManager;

public class UserInterface extends JPanel implements MouseListener {
	private static final long serialVersionUID = 1L;
	
	public static final int WIDTH = 900;
	public static final int HEIGHT = 600;
	
	ProfileManager pm;
	
	StateManager sm;
	
	public UserInterface() {
		super();
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setFocusable(true);
		requestFocus();
		setVisible(true);
		
		addMouseListener(this);
		
		sm = new StateManager();
		
		init();
	}
	
	public void init() {
		sm.init();
		
		removeAll();
		add(sm.getPanel());
	}

	@Override
	public void mouseClicked(MouseEvent m) {
		sm.mouseClicked(m);
	}

	@Override
	public void mouseEntered(MouseEvent m) {
		sm.mouseEntered(m);
	}

	@Override
	public void mouseExited(MouseEvent m) {
		sm.mouseExited(m);
	}

	@Override
	public void mousePressed(MouseEvent m) {
		sm.mousePressed(m);
	}

	@Override
	public void mouseReleased(MouseEvent m) {
		sm.mouseReleased(m);
	}
}
