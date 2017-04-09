
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class Tree extends HBox {

	private Shape bg;
	
	public Tree(double w, double h, Color c) {		
		bg = new Rectangle(w, h);
		bg.setFill(c);
		
		getChildren().add(bg);
	}
}

class Tile {
	
}
