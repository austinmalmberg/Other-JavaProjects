package com.austin.weekly28.boxesandconveyors.segments;

public class Conveyor extends BeltSegment {
	
	public Conveyor() {
		super(BeltSegment.CONVEYOR_CHAR);
	}

	@Override
	public void convey() {
		
		if(nextSeg != null) nextSeg.boxInQueue = hasBox;
		hasBox = boxInQueue;
		
	}
}
