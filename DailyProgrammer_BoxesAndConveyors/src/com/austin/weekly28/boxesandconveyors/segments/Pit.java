package com.austin.weekly28.boxesandconveyors.segments;

public class Pit extends BeltSegment {

	protected boolean occupied;
	
	public Pit(boolean empty) {
		super(empty ? BeltSegment.PIT_EMPTY_CHAR : BeltSegment.BOX_CHAR);
		
		occupied = empty ? false : true;
	}
	
	public void setBox(boolean b) {
		
		if(b && !occupied)
			occupied = true;
		else
			this.hasBox = b;
	}
	
	@Override
	public String toString() {
		return "" + (occupied ? BeltSegment.BOX_CHAR : BeltSegment.PIT_EMPTY_CHAR);
	}

	@Override
	public void convey() {
		
		if(nextSeg != null) nextSeg.boxInQueue = occupied && hasBox && boxInQueue;
		
		if(!hasBox) hasBox = boxInQueue && occupied;
				
		if(!occupied) occupied = boxInQueue;
		
	}

}
