package com.austin.chess;
import com.austin.chess.board.Board;
import com.austin.chess.board.Log;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ChessDemo extends Application {
	
	public static final int WIDTH = Board.WIDTH + Log.WIDTH;
	public static final int HEIGHT = Board.HEIGHT;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle(getClass().getName());
		stage.setScene(new Scene(createContent()));
		
		stage.sizeToScene();
		stage.setResizable(false);
		stage.show();
	}
	
	public Parent createContent() {
		Pane root = new Pane();
		root.setPrefSize(WIDTH, HEIGHT);
		
		Board board = new Board();
		
		root.getChildren().addAll(board);
		
		return root;
	}
}
