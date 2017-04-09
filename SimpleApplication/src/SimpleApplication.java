
public class SimpleApplication {
	public static void main(String[] args){
		Welcomer greet = new Welcomer();
		greet.sayHello();
	}
}

class Welcomer {
	private String greeting = "Hello";
	
	void sayHello() {
		System.out.println(greeting);
	}
}