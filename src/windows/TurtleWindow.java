package windows;

import javafx.scene.Group;
import javafx.scene.Scene;
import turtle.Turtle;

public class TurtleWindow implements WindowElements {

	private Turtle turtle;
	private Group root;
	
	public TurtleWindow(Turtle turtle, Group root, Scene scene) {
		this.turtle = turtle(scene);
		this.root = root;
	}
	
}
