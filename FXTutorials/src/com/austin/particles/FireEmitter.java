package com.austin.particles;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Point2D;
import javafx.scene.effect.BlendMode;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class FireEmitter extends Emitter {
	private final int numParticles = 5;
	
	private double dx;
	private double dy;
	
	private final double radius = 10;
	private final double expireTime = 6.0;
	
	private Paint color = Color.rgb(190, 20, 26);
	
	private BlendMode blendMode = BlendMode.ADD;
	
	List<Particle> particles;

	public FireEmitter() {
		super();
		
		particles = new ArrayList<>();
	}
	
	public List<Particle> emit(double x, double y) {
		return emit(x, y, numParticles, radius, expireTime);
	}
	
	public List<Particle> emit(double x, double y, int numParticles, double radius, double expireTime) {
		for(int i = 0; i < numParticles; i++) {
			dx = ((Math.random() - 0.5) / 2) * 0.2;
			dy = Math.random() * -.5; 
			
			Particle p = new Particle(x, y, new Point2D(dx, dy), radius, expireTime, color, blendMode);
			particles.add(p);
		}
		
		return particles;
	}

}
