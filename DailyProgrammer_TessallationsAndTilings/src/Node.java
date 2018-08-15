
public class Node<T> {

	T val;
	T r90;
	T r180;
	T r270;
	
	public Node(T val) {
		this.val = 
			this.r90 = 
			this.r180 =
			this.r270 = val;
	}
	
	public Node(T val, T r90) {
		this.val = this.r180 = val;
		this.r90 = this.r270 = r90;
	}
	
	public Node(T val, T r90, T r180, T r270) {
		this.val = val;
		this.r90 = r90;
		this.r180 = r180;
		this.r270 = r270;
	}
	
	public T rot0() { return val; }	
	public T rot90() { return r90; }
	public T rot180() { return r180; }
	public T rot270() { return r270; }
	public T rot360() { return val; }
}
