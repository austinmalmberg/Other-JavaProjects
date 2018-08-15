package com.austin.weekly28.boxesandconveyors;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import com.austin.weekly28.boxesandconveyors.segments.BeltSegment;
import com.austin.weekly28.boxesandconveyors.segments.Conveyor;
import com.austin.weekly28.boxesandconveyors.segments.Finish;
import com.austin.weekly28.boxesandconveyors.segments.Pit;

public class BeltManager {

	LinkedList<BeltSegment> belt;
	List<BeltSegment> finish_segments;
	
	public BeltManager() { }
	
	public BeltManager(String[] input) {
		init(input[0], input[1]);
	}
	
	private void init(String boxes, String beltInput) {
		belt = new LinkedList<>();
		finish_segments = new ArrayList<>();
		
		for (int i = 0; i < beltInput.length(); i++) {
			BeltSegment t = null;
			char ch = beltInput.charAt(i);
			
			if(ch == BeltSegment.CONVEYOR_CHAR) t = new Conveyor();
			if(ch == BeltSegment.PIT_EMPTY_CHAR) t = new Pit(true);
			if(ch == BeltSegment.BOX_CHAR) t = new Pit(false);
			if(ch == BeltSegment.FINISH_CHAR) {
				t = new Finish();
				finish_segments.add(t);
			}
			
			if(i < boxes.length() && boxes.charAt(i) == BeltSegment.BOX_CHAR) {
				t.setBox(true);
			}
			
			if(!belt.isEmpty()) belt.getLast().setNextSeg(t);
			belt.offer(t);
		}
	}
	
	public void run() {
		execute(true);
	}
	
	public void run_ResultOnly() {
		execute(false);
	}
	
	private void execute(boolean showOutput) {
		
		int steps = 0;
		
		String begin = "";
		boolean repeat = false;
		
		while(finish_segments.stream().allMatch(seg -> !seg.hasBox())) {
			if(showOutput) printBelt();
			
			repeat = begin.equals(showBoxes());
			if(repeat) {
				System.out.println("Repetitive cycle.  Breaking...");
				break;
			} else
				begin = showBoxes();
			
			belt.stream().forEach(seg -> seg.convey());
			
			steps++;
		}
		
		printBelt();
		System.out.println(steps);
	}
	
	public void set(String[] input) {
		init(input[0], input[1]);
	}
	
	private void printBelt() {
		System.out.println(showBoxes());
		System.out.println(showBelt());
		System.out.println();
	}
	
	private String showBoxes() {
		return belt.stream().map(seg -> (seg.hasBox() ? BeltSegment.BOX_CHAR : " ") + " ").collect(Collectors.joining());
	}
	
	private String showBelt() {
		return belt.stream().map(seg -> seg.toString() + " ").collect(Collectors.joining());
	}
}
