package ap.panels;

import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ap.inventory.Inventory;

public class UserPanel extends Panel {
	private static final long serialVersionUID = 1L;

	// top panel
	JPanel pnl_UserInfo;
		JPanel subpnl_Amounts;
			JLabel lbl_CurrentInvCount;
			JLabel lbl_SoldInvCount;
		JPanel subpnl_Name;
			JLabel lbl_name;
			// implement logout button?
		JPanel subpnl_profits;
			JLabel lbl_profits;
	// main panel
	JPanel pnl_Main;
		JPanel subpnl_left;
		JPanel subpnl_right;
	// nav panel
	JPanel pnl_Nav;
		JButton btn_logout;
		JButton btn_currentInv;
		JButton btn_soldAssets;
		JButton btn_addNew;
	
	Inventory inventory;
	
	public UserPanel(PanelManager pm) {
		this.pm = pm;
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setPreferredSize(new java.awt.Dimension(AmericanPickers.WIDTH, AmericanPickers.HEIGHT));
		setOpaque(true);
		requestFocus();
		setBackground(Color.WHITE);
		
		init();
	}
	
	public void init() {
		// initilize inventory
		inventory = new Inventory();
		
		
		
		// top panel
		pnl_UserInfo = new JPanel();
			subpnl_Amounts = new JPanel();
				lbl_CurrentInvCount = new JLabel(inventory.getCurrentCount());
		
		// add subcomponents to subpanels
		subpnl_Amounts.add(lbl_CurrentInvCount);
		
		// add subpanels to main panels
		pnl_UserInfo.add(subpnl_Amounts);
		
		// add main panels to this
		add(pnl_UserInfo);
	}
	
	public void update() {
		
	}
	
	public void draw() {
	}
	
	@Override
	public void mouseClicked(java.awt.Component c) {
		if(c.equals(this)) {
			System.out.println(inventory.getCurrentCount());
			inventory.addToCurrent();
			lbl_CurrentInvCount.setText(inventory.getCurrentCount());
		}
	}
}
