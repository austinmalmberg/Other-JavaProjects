package com.austin.chess.ui;

import java.util.Map;

import com.austin.chess.logic.board.Board;
import com.austin.chess.logic.piece.PieceType;
import com.austin.chess.ui.board.ChessBoard;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class GameInterface extends Application  {
	
	private FlowPane root;
	
	private Board board;
	private ChessBoard gameBoard;
	
	public Parent createContent() {
		initObjects();
		
		root = new FlowPane();
		
		root.getChildren().add(gameBoard);
		root.getChildren().add(pieces);
		
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
		// load board
		gameBoard = new ChessBoard(board);
		
		// load pieces
		pieces = initPiecesMap();
	}
	
	private Map<PieceType, ImageView> initPiecesMap() {
		
		
		return null;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
