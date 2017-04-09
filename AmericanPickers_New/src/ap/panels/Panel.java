package ap.panels;


import javax.swing.JPanel;

public abstract class Panel extends JPanel {
	private static final long serialVersionUID = 1L;
	

	PanelManager pm;
	
	public abstract void init();
	public abstract void update();
	public abstract void draw();
	public abstract void mouseClicked(java.awt.Component c);
//	public abstract void mousePressed(MouseEvent m);
//	public abstract void mouseReleased(MouseEvent m);
//	public abstract void mouseEntered(MouseEvent m);
//	public abstract void mouseExited(MouseEvent m);
}
