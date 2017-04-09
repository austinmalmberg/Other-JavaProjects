
public class Main {
	public static void main(String[] args) {
		ThreadRacer tr = new ThreadRacer();
		
		Thread r1 = new Thread(tr, "Racer 1");
		Thread r2 = new Thread(tr, "Racer 2");
		Thread r3 = new Thread(tr, "Racer 3");
		Thread r4 = new Thread(tr, "Racer 4");
		
		r1.start();
		r2.start();
		r3.start();
		r4.start();
	}
}

class ThreadRacer implements Runnable {
	
	public final int RACE_LENGTH = 100;
	public String winner;
	
	private void isWinner(int distance) {
		if(winner == null && distance >= RACE_LENGTH) {
			winner = Thread.currentThread().getName();
			System.out.println("The winner is " + winner + "!");
		}
	}
	
	public void run() {
		long start = System.nanoTime();
		
		for(int distance = 1; distance <= RACE_LENGTH; distance++) {
			System.out.println(Thread.currentThread().getName() + " has run " + distance + " meters.");
			isWinner(distance);
		}
		
		long elapsed = (System.nanoTime() - start) / 1000000;
		
		System.out.println(Thread.currentThread().getName() + " completed the race in " + elapsed + "ms.");
	}
}
