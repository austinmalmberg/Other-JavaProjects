package com.austin.reactor.components;

import com.austin.reactor.ReactorIdle;
import com.austin.reactor.hud.HUD;

import javafx.scene.layout.VBox;

public class ComponentList extends VBox {

	public static final int WIDTH = HUD.WIDTH;
	public static final int HEIGHT = ReactorIdle.HEIGHT - HUD.HEIGHT;
	
	public ComponentList() {
		setPrefSize(WIDTH, HEIGHT);
		setStyle("-fx-background-color: darkgray");
	}
}
