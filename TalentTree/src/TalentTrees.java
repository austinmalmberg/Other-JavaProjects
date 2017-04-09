import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class TalentTrees extends Application {
	
	public static int WIDTH = 1200;
	public static int HEIGHT = 900;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		stage.setScene(new Scene(createContent()));
		stage.sizeToScene();
		stage.setResizable(false);
		stage.show();
	}
	
	public Parent createContent() {
		HBox root = new HBox();
		root.setPrefSize(WIDTH, HEIGHT);
		
		Tree t1 = new Tree(WIDTH/3, HEIGHT, Color.AQUA);
		Tree t2 = new Tree(WIDTH/3, HEIGHT, Color.CADETBLUE);
		Tree t3 = new Tree(WIDTH/3, HEIGHT, Color.LIGHTBLUE);
		
		root.getChildren().addAll(t1, t2, t3);
		
		return root;
	}

}
