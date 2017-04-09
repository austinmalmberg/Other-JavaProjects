package com.austin.breakout;

import javafx.scene.layout.StackPane;
import javafx.scene.shape.Shape;

public abstract class GameObject extends StackPane {	
	
	public double x;
	public double y;
	
	Shape bg;
	
	public abstract void handleObjCollision();
	
	public Shape getBackgroundShape() {
		return bg;
	}
}
