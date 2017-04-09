package com.austin.reactor;

import com.austin.reactor.components.ComponentList;
import com.austin.reactor.hud.HUD;
import com.austin.reactor.map.TileMap;
import com.austin.reactor.menu.MenuOptions;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ReactorIdle extends Application {

	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	
	private BorderPane root;
	
	private HUD hud;
	private ComponentList components;
	private MenuOptions menu;
	private TileMap map;
	
	private Parent createContent() {
		root = new BorderPane();
		root.setPrefSize(WIDTH, HEIGHT);
		
		hud = new HUD();
		components = new ComponentList();
		menu = new MenuOptions();
		map = new TileMap();
		
		HBox top = new HBox();
		top.getChildren().addAll(hud, menu);
		
		// regions
		
		// upgrades
		
		// research center
		
		root.setTop(top);
		root.setLeft(components);
		root.setRight(map);
		
		return root;
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.setScene(new Scene(createContent()));
		stage.sizeToScene();
		stage.setResizable(false);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
