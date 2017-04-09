package com.austin.particles;

import java.util.List;

public abstract class Emitter {

	public abstract List<Particle> emit(double x, double y);
	public abstract List<Particle> emit(double x, double y, int numParticles, double radius, double expireTime);
	
}
