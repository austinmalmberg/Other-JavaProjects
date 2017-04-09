public class Main {
	/**
	 * Main method that uses a For loop to call the "encrypt" method for each arg
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Cipher cipher = new Cipher();
		
		if (args.length > 0) {
			System.out.println("Thank you for using the Atbash Cipher!  Non-alphabetic characters will not be encrypted.\n");
		}
		
		for (int i = 0; i < args.length; i++) {
			cipher.encrypt(args[i]);
		}
	}
}