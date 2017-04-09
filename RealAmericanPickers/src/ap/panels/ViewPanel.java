package ap.panels;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import ap.inventory.Inventory;

@SuppressWarnings("serial")
public class ViewPanel extends PanelLayout {

	JPanel listPanel;
	
	JPanel detailsPanel;
	JLabel description;
	JLabel purchasePrice;
	
	public ViewPanel(Inventory inventory) {
		this.inventory = inventory;
		
		setLayout(new GridLayout(1, 2));
		
		init();
	}
	
	public void init() {
		
		listPanel = new JPanel();
		listPanel.setLayout(new FlowLayout());
		listPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		
		detailsPanel = new JPanel();
		detailsPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		
		add(listPanel);
		add(detailsPanel);
	}

	public void update() {
		
	}
	
}
