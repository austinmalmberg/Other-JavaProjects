package ap.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ap.AmericanPickers;
import ap.inventory.Inventory;

@SuppressWarnings("serial")
public class TopPanel extends PanelLayout {
	
	// top panel
	JPanel currentInventory;
		JLabel currentCount;
		JLabel currentValue;
	JPanel userInfo;
		JLabel username;
	JPanel profits;
	
	public TopPanel(Inventory inventory) {
		this.inventory = inventory;
		
		setPreferredSize(new Dimension(AmericanPickers.WIDTH, AmericanPickers.HEIGHT/10));
		setLayout(new GridLayout(1, 3));
		setBorder(BorderFactory.createLineBorder(Color.GRAY));
		
		init();
	}
	
	public void init() {
		currentInventory = new JPanel();
		currentInventory.setBorder(BorderFactory.createLineBorder(Color.GRAY));
			currentCount = new JLabel("Total Items: " + inventory.getAssetCount());
			currentValue = new JLabel("Total Value: $" + inventory.getTotalAssetValue());
		
		userInfo = new JPanel();
//		userInfo.setBorder(BorderFactory.createLineBorder(Color.GRAY));
			username = new JLabel("Austin Malmberg");
		
		profits = new JPanel();
		profits.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		
		currentInventory.add(currentCount);
		currentInventory.add(currentValue);
		
		userInfo.add(username);
		
		add(currentInventory);
		add(userInfo);
		add(profits);
	}
	
	public void update() {
		currentCount.setText("Total Items: " + inventory.getAssetCount());
		currentValue.setText("Total Value: $" + inventory.getTotalAssetValue());
	}
}
