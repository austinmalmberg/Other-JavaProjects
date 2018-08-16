package com.austin.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class Controller {
	
	@FXML
	private Text output;
	
	private long n1 = 0;	// store first number
	
	private String operator = "";
	private boolean start = true;
	
	private Model model = new Model();
	
	@FXML
	private void processNumpad(ActionEvent e) {
		if(start) {
			output.setText("");
			start = false;
		}
		
		String value = ((Button) e.getSource()).getText();
		output.setText(output.getText() + value);
	}
	
	@FXML
	private void processOperator(ActionEvent e) {
		String value = ((Button) e.getSource()).getText();
		
		if(!"=".equals(value)) {
			
			if(!operator.isEmpty()) return;
			
			operator = value;
			n1 = Long.parseLong(output.getText());
			output.setText("");
		} else {
			if(operator.isEmpty()) return;
			
			output.setText(String.valueOf(model.calculate(n1, Long.parseLong(output.getText()), operator)));
			operator = "";
			
			start = true;
		}
	}
}
