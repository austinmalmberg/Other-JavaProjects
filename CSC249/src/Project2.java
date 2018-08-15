import java.awt.Dimension;
import java.awt.Insets;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Project2 {

	public static void main(String[] args) {
		UserInterface ui = new UserInterface();
		
		JFrame window = new JFrame("Project 2");
		window.setContentPane(ui);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getRootPane().setDefaultButton(ui.getDefaultButton());
		window.setResizable(false);
		window.pack();
		window.setVisible(true);
	}

}

/**
 * The graphical user interface for the project
 * 
 * @author Austin Malmberg
 *
 */
@SuppressWarnings("serial")
class UserInterface extends JPanel {
	
	public static final int WIDTH = 300;
	public static final int PADDING = 10;
	public static final int PANEL_HEIGHT = 30;
	
	private MyInputPanel investment;
	private MyInputPanel growthRate;
	private MyInputPanel time;
	
	private JPanel pnl_btn;
	private JButton btn_go;
	
	private JPanel pnl_output;
	private JLabel lbl_output;
	
	private InvestmentCalculator calculator;
	
	public UserInterface() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(new EmptyBorder(PADDING, PADDING, PADDING, PADDING));
		
		investment = new MyInputPanel("Investment Amount ($)");
		add(investment);
		
		growthRate = new MyInputPanel("Growth Rate (%)");
		add(growthRate);
		
		time = new MyInputPanel("Time (in years)");
		add(time);
		
		pnl_btn = new JPanel();
		pnl_btn.setPreferredSize(new Dimension(UserInterface.WIDTH, PANEL_HEIGHT));
		
			btn_go = new JButton("Go");
			btn_go.addActionListener(e -> buttonPressed());
			pnl_btn.add(btn_go);
			
		add(pnl_btn);
		
		pnl_output = new JPanel();
		pnl_output.setPreferredSize(new Dimension(UserInterface.WIDTH, PANEL_HEIGHT));
		pnl_output.setBorder(new EmptyBorder(PADDING, PADDING, PADDING, PADDING));

			lbl_output = new JLabel();
			pnl_output.add(lbl_output);
			
		add(pnl_output);
		
		calculator = new InvestmentCalculator();
	}
	
	private void buttonPressed() {
		
		// sets the lbl_output text to the appropriate error message.  If no error message, calculate the investment
		if(investment.getError() != null)
			lbl_output.setText(investment.getError());
		
		else if (growthRate.getError() != null)
			lbl_output.setText(growthRate.getError());
		
		else if (time.getError() != null)
			lbl_output.setText(time.getError());
		
		else {
			
			double result = calculator.calculate(
					investment.getTextAsDouble(),
					growthRate.getTextAsDouble() / 100,
					(int) time.getTextAsDouble());
			
			lbl_output.setText(String.format("Investment in %d years: $%,.2f.", (int) time.getTextAsDouble(), result));
		}
	}
	
	public JButton getDefaultButton() { return btn_go; }
}

/**
 * A class that contains a JLabel and a JTextField for increased code reusability
 * 
 * @author Austin Malmberg
 *
 */
@SuppressWarnings("serial")
class MyInputPanel extends JPanel {
	
	public static final int DEFAULT_COLUMNS = 5;
	
	private String name;
	private JLabel label;
	private JTextField textbox;
	
	public MyInputPanel(String name) {
		this(name, DEFAULT_COLUMNS);
	}
	
	public MyInputPanel(String name, int textboxColumns) {
		this.name = name;
		
		setPreferredSize(new Dimension(UserInterface.WIDTH, UserInterface.PANEL_HEIGHT));
		
		label = new JLabel();
		label.setPreferredSize(new Dimension(150, UserInterface.PANEL_HEIGHT));
		label.setText(name + ":");
		add(label);
		
		textbox = new JTextField(textboxColumns);
		textbox.setMargin(new Insets(0, 6, 0, 6));
		add(textbox);
	}
	
	/**
	 * Tests if the textbox is empty or does not contain a positive number then returns the appropriate
	 * error message.  Otherwise, returns null
	 * 
	 * @return
	 */
	public String getError() {
		if(isEmpty()) return String.format("\"%s\" cannot be empty.", name);
		if(!isPositiveNumber()) return String.format("\"%s\" must be a positive number.", name);
		
		return null;
	}
	
	public boolean isPositiveNumber() {		
		try {
			if(Double.parseDouble(textbox.getText().trim()) < 0) return false;
		} catch(Exception e) {
			return false;
		}
		
		return true;
	}
	
	public boolean isEmpty() { return textbox.getText().trim().length() == 0; }
	
	public void setLabelText(String text) { label.setText(text); }
	
	public String getText() { return textbox.getText(); }
	public double getTextAsDouble() { return Double.parseDouble(textbox.getText().trim()); }
	
	public String getName() { return name; }
	public JLabel getLabel() { return label; }
	public JTextField getTextField() { return textbox; }
}

/**
 * Calculates the growth of an investment given the initial investment amount, the growth rate, and the time
 * 
 * @author Austin Malmberg
 *
 */
class InvestmentCalculator {
	
	private final DecimalFormat df = new DecimalFormat("#.##");
	
	public InvestmentCalculator() {
		df.setRoundingMode(RoundingMode.HALF_UP);
	}
	
	/**
	 * Recursive method for calculating the investment
	 * 
	 * @param investment
	 * @param growth
	 * @param time
	 * @return
	 */
	public double calculate(double investment, double growth, int time) {
		if(time == 0) return round(investment);
		
		return calculate( round(investment * (1+growth)), growth, --time);
	}
	
	/**
	 * Rounds the value to two decimal places
	 * 
	 * @param d
	 * @return
	 */
	private double round(double d) {		
		return Double.valueOf(df.format(d));
	}
}
