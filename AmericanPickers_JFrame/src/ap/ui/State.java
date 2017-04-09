package ap.ui;

import java.awt.event.MouseEvent;

import javax.swing.JPanel;

public abstract class State {

	protected StateManager sm;
	
	public abstract void init();
	public abstract JPanel getPanel();
	
	public abstract void mouseClicked(MouseEvent m);
	public abstract void mouseEntered(MouseEvent m);
	public abstract void mouseExited(MouseEvent m);
	public abstract void mousePressed(MouseEvent m);
	public abstract void mouseReleased(MouseEvent m);
}
