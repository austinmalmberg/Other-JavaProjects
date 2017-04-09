package ap.panels;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import ap.AmericanPickers;
import ap.inventory.Inventory;

@SuppressWarnings("serial")
public class BottomPanel extends PanelLayout implements ActionListener {
	
	JButton logout;
	JButton viewCurrent;
	JButton viewSold;
	JButton addNew;
	
	MainPanel main;
	
	public BottomPanel(Inventory inventory, MainPanel main) {
		this.inventory = inventory;
		this.main = main;
		
		setPreferredSize(new Dimension(AmericanPickers.WIDTH, AmericanPickers.HEIGHT/10));
		setLayout(new GridLayout(1, 4));
		
		init();
	}

	public void init() {
		// initialize buttons
		logout = new JButton("Logout");
		logout.addActionListener(this);
		
		viewCurrent = new JButton("View Current Inventory");
		viewCurrent.addActionListener(this);
		
		viewSold = new JButton("View Sold");
		viewSold.addActionListener(this);
		
		addNew = new JButton("Add New Item");
		addNew.addActionListener(this);
		
		
		// add buttons to panel
		add(logout);
		add(viewCurrent);
		add(viewSold);
		add(addNew);
	}
	
	public void update() {}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// update main panels based on which button was clicked		
		
		if (e.getSource() == logout) {
			System.exit(0);
		}
		if (e.getSource() == viewCurrent) {
			main.setUI(MainPanel.LIST_INTERFACE);
		}
		if (e.getSource() == viewSold) {
			main.setUI(MainPanel.LIST_INTERFACE);
		}
		if (e.getSource() == addNew) {
			// why is it that the main panel only updates when you call inventory?????
			
			main.setUI(MainPanel.ADD_INTERFACE);
			inventory.addAsset();
		}
		
		
	}
	
}
