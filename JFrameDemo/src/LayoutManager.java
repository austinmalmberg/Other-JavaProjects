import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;


public class LayoutManager {

	public static final int LOGIN_STATE = 0;
	public static final int INVENTORY_STATE = 1;
	public static final int SOLD_STATE = 2;
	public static final int ADD_ITEM_STATE = 3;
	
	private ArrayList<Layout> states;
	
	private int currentState; 
	
	public LayoutManager() {
		states = new ArrayList<Layout>();
		
		currentState = LOGIN_STATE;
		
		states.add(new LoginPanel(this));
	}
	
	public int getCurrentState() {
		return currentState;
	}
	
	public JPanel getCurrentPanel() {
		return states.get(currentState);
	}
	
	public void setCurrentState(int i) {
		this.currentState = i;
	}
	
	public void mouseClicked(Component c) {
		states.get(currentState).mouseClicked(c);
	}
}
