package com.austin.memory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MemoryDemo extends Application {

	private static final int TILE_SIZE = 50;

	private static final int TILES_PER_ROW = 6;
	private static final int NUM_PAIRS = (int) Math.pow(TILES_PER_ROW, 2) / 2;

	// scene dimensions
	private static final int WIDTH = TILE_SIZE * TILES_PER_ROW;
	private static final int HEIGHT = TILE_SIZE * TILES_PER_ROW;

	private Tile selected = null;
	private int click_count = 2;

	private Parent createContent() {
		Pane root = new Pane();
		root.setPrefSize(WIDTH, HEIGHT);

		char c = 'A';
		List<Tile> tiles = new ArrayList<>();

		// add tiles to list
		for(int i = 0; i < NUM_PAIRS; i++) {
			tiles.add(new Tile(String.valueOf(c)));
			tiles.add(new Tile(String.valueOf(c)));
			c++;
		}

		Collections.shuffle(tiles);

		// position tiles
		for (int i = 0; i < tiles.size(); i++) {
			Tile t = tiles.get(i);
			t.setTranslateX(TILE_SIZE * (i % TILES_PER_ROW));
			t.setTranslateY(TILE_SIZE * (i / TILES_PER_ROW));

			// add tiles
			root.getChildren().add(t);
		}

		return root;
	}

	private class Tile extends StackPane {
		private Text text;
		private Rectangle border;

		public Tile(String value) {
			border = new Rectangle(50,50);
			border.setFill(null);
			border.setStroke(Color.BLACK);

			text = new Text();
			text.setText(value);
			text.setFont(Font.font(28));

			setAlignment(Pos.CENTER);

			// add elements to tile
			getChildren().addAll(border, text);

			setOnMouseClicked(this::handleMouseClick);

			close();
		}

		public void handleMouseClick(MouseEvent event) {
			if(isOpen() || click_count == 0) return;

			click_count--;

			if(selected == null) {	// if nothing selected
				selected = this;	// select tile and open
				open(() -> {});
			} else {				// if another tile selected
				open(() -> {		// open this and check for match
					if (!hasSameValue(selected)) {	// close if not match
						selected.close();
						this.close();
					}

					selected = null;
					click_count = 2;
				});
			}
		}

		public void open(Runnable action) {
			FadeTransition ft = new FadeTransition(Duration.seconds(0.5), text);
			ft.setToValue(1);  // make visible
			ft.setOnFinished(e -> action.run());
			ft.play();
		}

		public boolean isOpen() {
			return text.getOpacity()  > 0;
		}

		private boolean hasSameValue(Tile other) {
			return text.getText().equals(other.text.getText());
		}

		public void close() {
			FadeTransition ft = new FadeTransition(Duration.seconds(0.5), text);
			ft.setToValue(0);  // make invisible
			ft.play();
		}
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
