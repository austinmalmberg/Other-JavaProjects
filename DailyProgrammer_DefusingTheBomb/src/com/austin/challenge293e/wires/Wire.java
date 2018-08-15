package com.austin.challenge293e.wires;

public enum Wire {
	WHITE("white", new White()),
	BLACK("black", new Black()),
	PURPLE("purple", new Purple()),
	RED("red", new Red()),
	GREEN("green", new Green()),
	ORANGE("orange", new Orange());
	
	private String color;
	private WireState state;
	
	Wire(String color, WireState state) {
		this.color = color;
		this.state = state;
	}
	
	public static Wire getWire(String color) {
		for(Wire wire : Wire.values()) {
			if(wire.getColor().equals(color))
				return wire;
		}
		
		return null;
	}
	
	public static WireState getWireState(String color) {
		for(Wire wire : Wire.values()) {
			if(wire.getColor().equals(color))
				return wire.getWireState();
		}
		
		return null;
	}
	
	public String getColor() { return color; }
	public WireState getWireState() { return state; }
}
