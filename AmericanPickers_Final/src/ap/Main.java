package ap;

public class Main {

	public static void main(String[] args) {	
		Thread thread = new Thread(new AmericanPickers());
		thread.setName("Main_Thread");
		thread.start();
	}

}
