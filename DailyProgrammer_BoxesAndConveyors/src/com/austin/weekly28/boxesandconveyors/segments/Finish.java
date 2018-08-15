package com.austin.weekly28.boxesandconveyors.segments;

public class Finish extends BeltSegment {
	
	public Finish() {
		super(BeltSegment.FINISH_CHAR);
	}

	@Override
	public void convey() {
		
		if(nextSeg != null) nextSeg.boxInQueue = hasBox;
		hasBox = boxInQueue;
		
	}
}
