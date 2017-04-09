
import java.awt.Component;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class LoginPanel extends Layout {

	private static final long serialVersionUID = 1L;

	public LoginPanel(LayoutManager lm) {
		this.lm = lm;
		
		JLabel loginText = new JLabel("Click anywhere to continue");
		
		add(loginText);
	}

	@Override
	public void mouseClicked(Component c) {		
		if (c.equals(this)) {
			System.out.println("clicked.");
			JOptionPane.showMessageDialog(null, "You clicked the LoginPanel", "Clicked Title", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
