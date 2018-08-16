package com.austin.chess.ui;

import com.austin.chess.ui.board.ChessBoard;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class GameInterface extends Application  {
	
	private FlowPane root;
	
	private ChessBoard board;
	
	public Parent createContent() {
		initObjects();
		
		root = new FlowPane();
		
		root.getChildren().add(board);
		
		return root;
	}
	
	@Override
	public void start(Stage stage) throws Exception {		
		stage.setScene(new Scene(createContent()));
		stage.setResizable(true);
		stage.sizeToScene();
		stage.show();
		
		stage.setOnCloseRequest(event -> Platform.exit());
	}
	
	private void initObjects() {
		board = new ChessBoard(this);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
