package com.austin.battleship;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class BattleshipDemo extends Application {
	
	public static final int WIDTH = 400;
	public static final int HEIGHT = 900;
	
	public BorderPane root;
	
	public Console player_console;
	public Console computer_console;
	
	public BattleshipDemo() {
		root = new BorderPane();
		
		player_console = new Console("Player", true);
		computer_console = new Console("Computer", false);
	}
	
	private void initObjects() {
		root.setPrefSize(WIDTH, HEIGHT);

	}
	
	private Parent createContent() {
		initObjects();
		
		// add objects to root		
		root.setTop(computer_console);
		root.setBottom(player_console);

		return root;
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.setScene(new Scene(createContent()));
		stage.setResizable(true);
		stage.sizeToScene();
		stage.show();
		
		stage.setOnCloseRequest(e -> Platform.exit());
	}

	public static void main(String[] args) {
		launch(args);
	}
}
