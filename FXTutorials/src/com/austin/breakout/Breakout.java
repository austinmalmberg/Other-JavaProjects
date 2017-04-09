package com.austin.breakout;

import java.util.ArrayList;
import java.util.List;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.beans.binding.StringBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Breakout extends Application {
	
	// when two blocks are hit simultaneously, the ball does not change direction because velocity is inverted twice
	// if the ball is moving too fast, it can slip into a block or the bat because it moves too many frames between loop refreshes

	public boolean running;
	
	// dimensions
	public final int WIDTH = 420;
	public final int HEIGHT = 600;
	
	// graphics components
	private Pane root;
	
	private final int BLOCK_SIZE = 30;
	private final int BLOCK_ROWS = 5;
	private final int BLOCK_PADDING = 5;
	List<Block> blocks;
	
	private Bat bat;
	
	private Ball ball;
	
	// hud components
	private final int STARTING_LIVES = 5;
	
	private IntegerProperty score;
	
	private ArrayList<Ball> balls_remaining;
	
	private Text scoreText;
	
	public Breakout() {
		running = true;
		
		root = new Pane();
		
		blocks = new ArrayList<>();
		
		bat = new Bat();
		
		ball = new Ball(WIDTH / 2, HEIGHT / 2, true);
		
		score = new SimpleIntegerProperty();
		
		balls_remaining = new ArrayList<>();
		
		scoreText = new Text();
	}
	
	private void initObjects(){	
		// add blocks
		for(int i = 0; i < BLOCK_ROWS; i++) {
			for(int j = 0; j < 12; j++) {
				Block block = new Block(2 + (BLOCK_PADDING + BLOCK_SIZE) * j,
						30 + (BLOCK_PADDING + BLOCK_SIZE) * i);
				
				blocks.add(block);
				
				root.getChildren().add(block);
			}
		}
		
		initHUD();
		for(Ball b : balls_remaining) {
			root.getChildren().add(b);
		}
		
		// add bat, ball
		root.getChildren().addAll(bat, ball, scoreText);
	}
	
	private void initHUD() {
		for(int i = 0; i < STARTING_LIVES; i++) {
			Ball b = new Ball(WIDTH - 18 - (22 * i), 14, false);
			balls_remaining.add(b);
		}
		
		// set score
		score.set(0);
		scoreText.setTranslateX(5);
		scoreText.setTranslateY(22);
		scoreText.setFont(Font.font(20));
		scoreText.textProperty().bind(new StringBinding() {
			{
				bind(score);
			}
			
			@Override
			protected String computeValue() {
				return "Score: " + score.get();
			}
		});		
	}
	
	private Parent createContent() {
		root.setPrefSize(WIDTH, HEIGHT);
		
		initObjects();
		
		root.setOnMouseMoved(event -> {
			double x = event.getX();
			
			bat.move(x);
		});
		
		return root;
	}
	
	private class Block extends GameObject {
		
		private int life_left;
		private int block_value;
		
		public Block(int x, int y) {
			this.x = x;
			this.y = y;
			
			setPrefSize(BLOCK_SIZE, BLOCK_SIZE);
			
			life_left = 1;
			
			block_value = 100;
			
			bg = new Rectangle(BLOCK_SIZE, BLOCK_SIZE);
			bg.setFill(Color.BEIGE);
			bg.setStroke(Color.BLACK);
			
			setTranslateX(x);
			setTranslateY(y);
			
			getChildren().add(bg);
		}
		
		public void handleObjCollision() {
			score.set(score.get() + block_value);
			
			life_left--;
		}
		
		public void remove() {
			blocks.remove(0);
		}
	}
	
	private class Bat extends GameObject {
		
		private final int BAT_WIDTH = 100;
		private final int BAT_HEIGHT = 20;
		
		private final double HALF_BAT = BAT_WIDTH / 2;
		
		private Line line;
		
		public Bat() {
			x = (WIDTH / 2) - (BAT_WIDTH / 2);
			y = HEIGHT - BAT_HEIGHT;
			
			setPrefSize(BAT_WIDTH, BAT_HEIGHT);
			
			bg = new Rectangle(BAT_WIDTH, BAT_HEIGHT);
			bg.setFill(Color.BLACK);
			
			line = new Line(getTranslateX(), 1, getTranslateX(), BAT_HEIGHT - 1);
			line.setStroke(Color.RED);
			
			setLayoutX(-HALF_BAT);
			
			setTranslateX(x + HALF_BAT);
			setTranslateY(y - 3);
			
			getChildren().addAll(bg, line);
		}
		
		public void move(double x) {
			if(x + HALF_BAT > WIDTH) return;
			if(x - HALF_BAT < 0) return;
			
			setTranslateX(x);
		}
		
		@Override
		public void handleObjCollision() {
			// determines the direction the ball comes off bat
			double diff = ball.getTranslateX() - getTranslateX();
			double fract = diff / (getWidth() / 2);
			
			if(fract > 1.0) fract = 1.0;
			if(fract < -1.0) fract = -1.0;
			
			ball.dx = fract * ball.MAX_DX;
		}
	}
	
	private class Ball extends GameObject {
		
		// vector variables
		private final double START_X = WIDTH / 2;
		private final double START_Y = HEIGHT / 2;
		
		private final double MAX_DX = 3.0;
		private final double MAX_DY = 6.0;
		
		private final double START_DX = 0.0;
		private final double START_DY = 6.0;
		
		private final double VELOCITY_INCREASE = MAX_DY / 20;
		
		private double dx;
		private double dy;
		
		// dimensions
		private final int BALL_RADIUS = 10;
		
		private AnimationTimer animation;
		
		public Ball(int x, int y, boolean animated) {
			this.x = x;
			this.y = y;
				
			bg = new Circle(BALL_RADIUS);
			bg.setFill(Color.BLUE);
			
			setLayoutX(-BALL_RADIUS);
			setLayoutY(-BALL_RADIUS);
			

			if(animated) {
				resetPosition();
				
				animation = new AnimationTimer() {
					@Override
					public void handle(long now) {
						if(!running) stop();
						
						update();
					}
				};
				
				animation.start();
			}
			
			setTranslateX(x);
			setTranslateY(y);
			
			getChildren().add(bg);
			
		}
		
		public void resetPosition() {
			x = START_X;
			y = START_Y;
			
			dx = START_DX;
			dy = START_DY;
		}
		
		private void update() {
			if(x <= BALL_RADIUS) dx = Math.abs(dx);
			if(x >= WIDTH - BALL_RADIUS) dx = -Math.abs(dx);
			
			if(y <= BALL_RADIUS) dy = Math.abs(dy);
			if(y >= HEIGHT + BALL_RADIUS) {	// if ball hits bottom
				
				//remove ball from game and arraylist
				if(balls_remaining.size() > 0) {
					root.getChildren().remove(balls_remaining.remove(balls_remaining.size() - 1));
				} else if(balls_remaining.size() == 0) {
					running = false;
				}
				
				resetPosition();
			}
			
			x += dx;
			y += dy;
			
//			System.out.printf("x: %f, y, %f, dx: %f, dy: %f%n", x, y, dx, dy);
			
			setTranslateX(x);
			setTranslateY(y);
		}

		@Override
		public void handleObjCollision() {
			dy = -dy;
		}
		
		public void handleObjCollision(GameObject o) {
			
			// determine which side is hit and richocette accordingly
			
			
			
		}
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.setScene(new Scene(createContent()));
		stage.sizeToScene();
		stage.setResizable(false);
		stage.show();
		
		// collision detection and game loop
		AnimationTimer timer = new AnimationTimer() {			
			@Override
			public void handle(long now) {
				if(!running) stop();
				
				handleCollisions();
				
				// stop game when all blocks are removed
				if(blocks.size() == 0) running = false;
			}
		};
		
		timer.start();
	}
	
	private void handleCollisions() {		
		for(int i = 0; i < root.getChildren().size(); i++) {
			Node n = root.getChildren().get(i);
			
			// ignore ball and all non-GameObjects
			if(n instanceof Ball || !(n instanceof GameObject)) continue;
			
			GameObject go = (GameObject) n;
			// detect collision between ball and GameObject
			Shape intersection = Shape.intersect(ball.getBackgroundShape(), go.getBackgroundShape());
			if(!intersection.getBoundsInLocal().isEmpty()) {
				System.out.printf("H: %f, W: %f, %s%n", intersection.getBoundsInLocal().getHeight(), intersection.getBoundsInLocal().getWidth(), n.getClass().toString());
				
				ball.handleObjCollision();
				
				go.handleObjCollision();
				
				if(n instanceof Block) {
					((Block) go).remove();
					root.getChildren().remove(go);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
