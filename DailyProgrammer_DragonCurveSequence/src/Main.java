
public class Main {

	public static void main(String[] args) {
		DragonCurve seq = new DragonCurve(8);
		seq.print();
	}
}

class DragonCurve {
	
	DragonCurveNode head;
	DragonCurveNode tail;
	
	int size;
	
	public DragonCurve(int nodes) {
		head = tail = new DragonCurveNode("1");
		size = 1;
		
		for(int i = 1; i < nodes; i++) {
			addNode();
		}
	}
	
	public void addNode() {
		tail.next = tail = new DragonCurveNode(tail, null);
		size++;
	}
	
	public void print() {
		DragonCurveNode curr = head;
		while(curr != null) {
			System.out.println(curr.toString());
			curr = curr.next;
		}
	}
}

class DragonCurveNode {

	String seq;
	DragonCurveNode prev;
	DragonCurveNode next;
	
	public DragonCurveNode(String seq) {
		this.seq = seq;
	}
	
	public DragonCurveNode(DragonCurveNode prev, DragonCurveNode next) {
		this.prev = prev;
		
		seq = generateSequence();
	}
	
	private String generateSequence() {
		StringBuilder sb = new StringBuilder();		
		BinaryToggle toggle = new BinaryToggle();
		
		for(int i = 0; i < prev.seq.length()*2 + 1; i++) {
			if(i % 2 == 0)
				sb.append(toggle.next());
			else
				sb.append(prev.seq.charAt(i / 2));
		}
		
		return sb.toString();
	}
	
	public String toString() { return seq; }
}

class BinaryToggle {
	
	boolean on;
	
	public BinaryToggle() { }
	
	public int next() {
		on = !on;
		return on ? 1 : 0;
	} 
}
