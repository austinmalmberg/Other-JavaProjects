package ap.panels;

import java.util.ArrayList;

public class PanelManager {

	public static final int LOGIN_PANEL = 0;
	public static final int USER_PANEL = 1;
	
	public ArrayList<Panel> panels;
	
	private int currentPanel;
	
	public PanelManager() {
		
		panels = new ArrayList<Panel>();
		
		currentPanel = 0;
		
		panels.add(new LoginPanel(this));
		panels.add(new UserPanel(this));
	}
	
	public void setPanel(int panel) {
		this.currentPanel = panel;
		panels.get(currentPanel).init();
	}
	
	public void init() {
		panels.get(currentPanel).init();
	}
	
	public void update() {
		panels.get(currentPanel).update();
	}
	
	public void draw() {
		panels.get(currentPanel).draw();
	}
	
	public javax.swing.JPanel getCurrentPanel() {
		return panels.get(currentPanel);
	}
	
	public void mouseClicked(java.awt.Component c) {
		panels.get(currentPanel).mouseClicked(c);
	}
}
