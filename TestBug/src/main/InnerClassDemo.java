package main;

public class InnerClassDemo {
	
	public int i1 = 1;
	private int i2 = 2;

	public void doSomething() {
		Thread t = new Thread(new Runnable() {
			public static void run() {
				i1 = i2;
			}
		});
		t.start();
	}
}
