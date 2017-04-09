package ap.panels;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ap.AmericanPickers;
import ap.inventory.Inventory;

@SuppressWarnings("serial")
public class MainPanel extends PanelLayout {
	
	public static final int BLANK_INTERFACE = 0;
	public static final int LIST_INTERFACE = 1;
	public static final int ADD_INTERFACE = 2;
	public int currentUI;
	
	// main panel

	// default panel on app start up
	JPanel defaultPanel;
	
	// used while viewing current or sold inventory
	JPanel listPanel;
	ViewPanel viewPanel;
	
	// used while adding items
	JPanel addPanel;
	
	public MainPanel(Inventory inventory) {
		this.inventory = inventory;
		
		setPreferredSize(new Dimension(AmericanPickers.WIDTH, AmericanPickers.HEIGHT));
		setLayout(new CardLayout());
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		init();
	}
	
	public void init() {
		
		defaultPanel = new JPanel();
		defaultPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		defaultPanel.add(new JLabel("Default Panel"));
		
		viewPanel = new ViewPanel(inventory);
		viewPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		
		addPanel = new JPanel();
		addPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		addPanel.add(new JLabel("Add Panel"));
		
		add(defaultPanel);
		add(viewPanel);
		add(addPanel);
		
		setUI(BLANK_INTERFACE);
	}
	
	public void update() {
		
	}
	
	public void setUI(int i) {
		currentUI = i;
		
		defaultPanel.setVisible(false);
		viewPanel.setVisible(false);
		addPanel.setVisible(false);
		
		if(currentUI == BLANK_INTERFACE) {
			defaultPanel.setVisible(true);
		}
		if(currentUI == LIST_INTERFACE) {
			viewPanel.setVisible(true);
		}
		if(currentUI == ADD_INTERFACE) {
			addPanel.setVisible(true);
		}
	}
}
