package ap.ui;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;

public class StateManager {

	public static final int LOGIN_STATE = 0;
	public static final int CURRENT_INVENTORY_STATE = 1;
	public static final int SOLD_ITEMS_STATE = 2;
	public static final int ADD_ITEM_STATE = 3;
	
	private ArrayList<State> states;
	private int currentState;
	
	public StateManager() {
		states = new ArrayList<State>();
		
		currentState = LOGIN_STATE;
		
		states.add(new LoginState(this));
	}
	
	public int getState() { return currentState; }
	public void setState(int currentState) { this.currentState = currentState; }
	
	public void init() {
		states.get(currentState).init();
	}
	
	public JPanel getPanel() {
		return states.get(currentState).getPanel();
	}
	
	public void mouseClicked(MouseEvent m) {
		states.get(currentState).mouseClicked(m);
	}
	public void mouseEntered(MouseEvent m) {
		states.get(currentState).mouseEntered(m);
	}
	public void mouseExited(MouseEvent m) {
		states.get(currentState).mouseExited(m);
	}
	public void mousePressed(MouseEvent m) {
		states.get(currentState).mousePressed(m);
	}
	public void mouseReleased(MouseEvent m) {
		states.get(currentState).mouseReleased(m);
	}
}
