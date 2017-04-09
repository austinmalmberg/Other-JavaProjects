package com.austin.particles;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.BlendMode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ParticlesDemo extends Application {

	private static int WIDTH = 600;
	private static int HEIGHT = 600; 
	
	private GraphicsContext g;
	
	private List<Particle> p1 = new ArrayList<>();
	private List<Particle> p2 = new ArrayList<>();
	
	private Emitter emitter = new FireEmitter();
	
	Random r = new Random();
	
	private Parent createContent() {
		Pane root = new Pane();
		root.setPrefSize(WIDTH, HEIGHT);
		
		Canvas canvas = new Canvas(WIDTH, HEIGHT);
		g = canvas.getGraphicsContext2D();
		
		root.getChildren().add(canvas);
		
		return root;
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setScene(new Scene(createContent()));
		primaryStage.show();
		
		AnimationTimer timer = new AnimationTimer() {
			public void handle(long now) {
				onUpdate();
			}
		};
		timer.start();
	}
	
	private void onUpdate() {
		g.setGlobalAlpha(1.0);
		g.setGlobalBlendMode(BlendMode.SRC_OVER);
		g.setFill(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		
		
		p1.addAll(emitter.emit(300, 300));
		for (Iterator<Particle> it = p1.iterator(); it.hasNext(); ) {
			Particle p = it.next();
			p.update();
			
			if(!p.isAlive()) {
				it.remove();
				continue;
			}
			
			p.render(g);
		}
		
		p2.addAll(emitter.emit(300, 320, 15, 2, 1.2));
		for (Iterator<Particle> it = p2.iterator(); it.hasNext(); ) {
			Particle p = it.next();
			p.update();
			
			if(!p.isAlive()) {
				it.remove();
				continue;
			}
			
			p.render(g);
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
