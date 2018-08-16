import java.awt.Dimension;
import java.awt.Insets;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Project2 {

	public static void main(String[] args) {
		InvestmentGUI gui = new InvestmentGUI();
		
		JFrame window = new JFrame("Investment Calculator");
		window.setContentPane(gui);
		window.pack();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getRootPane().setDefaultButton(gui.getDefaultButton());
		window.setResizable(false);
		window.setVisible(true);
		
		InvestmentCalculator calc = new InvestmentCalculator();
		System.out.println(calc.calculate(10, 0.5, 5));
	}
}

@SuppressWarnings("serial")
class InvestmentGUI extends JPanel {
	
	private InputField principal;
	private InputField growthRate;
	private InputField years;
	
	private JButton btn_go;
	
	private JLabel lbl_output;
	
	private InvestmentCalculator calc;
	
	public InvestmentGUI() {		
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		setPreferredSize(new Dimension(300, 200));
		
		principal = new InputField("Principal");
		add(principal);
		
		growthRate = new InputField("Growth Rate (%)");
		add(growthRate);
		
		years = new InputField("Years");
		add(years);
		
		btn_go = new JButton("Go");
		btn_go.addActionListener(action -> buttonPressed());
		add(btn_go);
		
		lbl_output = new JLabel();
		lbl_output.setPreferredSize(new Dimension(WIDTH, 50));
		add(lbl_output);
	}
	
	public JButton getDefaultButton() { return btn_go; }
	
	private void buttonPressed() {
		double dblPrincipal;
		double dblGrowth;
		int intYears;
		
		if(isDoubleFormat(principal.getFieldText())) {
			dblPrincipal = Double.parseDouble(principal.getFieldText()); 
		} else {
			lbl_output.setText("Principal must be a positive number");
			return;
		}
		
		if(isDoubleFormat(growthRate.getFieldText())) {
			dblGrowth = Double.parseDouble(growthRate.getFieldText()); 
		} else {
			lbl_output.setText("Growth Rate must be a positive number");
			return;
		}
		
		if(isIntegerFormat(years.getFieldText())) {
			intYears = Integer.parseInt(years.getFieldText()); 
		} else {
			lbl_output.setText("Years must be a positive number");
			return;
		}
		
		lbl_output.setText( String.valueOf( calc.calculate(dblPrincipal, dblGrowth, intYears) ) );
	}
	
	private boolean isDoubleFormat(String s) {
		return s.length() > 0 && s.matches("\\d*\\.?\\d*");
	}
	
	private boolean isIntegerFormat(String s) {
		return s.matches("\\d+");
	}
}

@SuppressWarnings("serial")
class InputField extends JPanel {
	
	private JLabel label;
	private JTextField textbox;
	
	public InputField(String text) {
		label = new JLabel(text+":");
		textbox = new JTextField(6);
		
		textbox.setMargin(new Insets(0, 5, 0, 5));
		
		add(label);
		add(textbox);
	}
	
	public void setLabelText(String text) {		
		label.setText(text);
	}
	
	public JLabel getLabel() { return label; }
	public JTextField getTextField() { return textbox; }
	
	public String getFieldText() { return textbox.getText().trim(); }
}

class InvestmentCalculator {
	
	public InvestmentCalculator() { }
	
	public double calculate(double principal, double growthRate, int years) {
		if(years == 0) return round(principal);
		
		return calculate( principal * (1 + growthRate), growthRate, --years);
	}
	
	private double round(double d) {
		return Math.round(d * 100.0) / 100.0;
	}
}