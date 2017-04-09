package com.austin.reactor.menu;

import com.austin.reactor.ReactorIdle;
import com.austin.reactor.hud.HUD;

import javafx.scene.layout.HBox;

public class MenuOptions extends HBox {

	public static final int WIDTH = ReactorIdle.WIDTH - HUD.WIDTH;
	public static final int HEIGHT = HUD.HEIGHT;
	
	public MenuOptions() {
		setPrefSize(WIDTH, HEIGHT);
		setStyle("-fx-background-color: darkgray");
	}
}
