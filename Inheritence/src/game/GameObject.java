package game;

public abstract class GameObject {

	// this method must be implemented in any method that extends GameObject
	public abstract void draw();
	
	public static void main(String[] args) {
		
		Player player = new Player();
		player.someMethod();
		// player.draw();
		
		Menu menu = new Menu();
		// menu.draw();
		
		GameObject[] gameObjects = new GameObject[2];
		gameObjects[0] = player;
		gameObjects[1] = menu;
		
		for (int i = 0; i < gameObjects.length; i++) {
			gameObjects[i].draw();
		}
		
		// abstract classes exist to be extended
		// they cannot be instantiated, i.e.
		// GameObject myObject = new GameObject();

	}
}
