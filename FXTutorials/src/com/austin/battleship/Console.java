package com.austin.battleship;

import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Console extends VBox {
	
	private Text title;
	private Board b;
	
	public Console(String s, boolean displayHUD) {
		title = new Text();
		title.setFont(Font.font(24));
		
		title.setText(s);
		
		b = new Board();
		
		getChildren().addAll(title, b);
	}
}
