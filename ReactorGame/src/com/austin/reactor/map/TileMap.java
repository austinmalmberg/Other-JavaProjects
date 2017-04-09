package com.austin.reactor.map;

import com.austin.reactor.ReactorIdle;
import com.austin.reactor.components.ComponentList;
import com.austin.reactor.menu.MenuOptions;

import javafx.scene.layout.GridPane;

public class TileMap extends GridPane {

	public static final int WIDTH = ReactorIdle.WIDTH - ComponentList.WIDTH;
	public static final int HEIGHT = ReactorIdle.HEIGHT - MenuOptions.HEIGHT;
	
	public TileMap() {
		setPrefSize(WIDTH, HEIGHT);
	}
}
