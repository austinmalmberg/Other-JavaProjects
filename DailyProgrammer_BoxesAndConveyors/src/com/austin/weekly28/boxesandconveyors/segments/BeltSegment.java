package com.austin.weekly28.boxesandconveyors.segments;

public abstract class BeltSegment {
	
	public static final char BOX_CHAR = '#';
	
	public static final char CONVEYOR_CHAR = '>';
	public static final char PIT_EMPTY_CHAR = '_';
	public static final char PIT_FILLED_CHAR = '#';
	public static final char FINISH_CHAR = 'F';
	
	
	protected char beltChar;	
	protected boolean hasBox;
	
	protected boolean boxInQueue;
	
	BeltSegment nextSeg;
	
	BeltSegment(char beltChar) {
		this.beltChar = beltChar;
		
		boxInQueue = false;
	}
	
	public void setBox(boolean b) { this.hasBox = b; }
	public void setNextSeg(BeltSegment bs) { this.nextSeg = bs; }
	public boolean hasBox() { return hasBox; }
	
	public String toString() {
		return "" + beltChar;
	};
	
	public abstract void convey();
}
