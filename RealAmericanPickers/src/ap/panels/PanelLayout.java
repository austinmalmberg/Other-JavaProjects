package ap.panels;

import javax.swing.JPanel;

import ap.inventory.Inventory;

@SuppressWarnings("serial")
public abstract class PanelLayout extends JPanel {
	
	Inventory inventory;
	
	public abstract void init();
	public abstract void update();
}
