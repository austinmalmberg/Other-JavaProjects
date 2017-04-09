import java.awt.Component;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;


public abstract class Layout extends JPanel {

	private static final long serialVersionUID = 1L;
	
	protected LayoutManager lm;
	
	public abstract void mouseClicked(Component c);
}
