package windows;

import javafx.scene.Group;
import turtle.Turtle;

public class TurtleWindow implements WindowElements {

	private Turtle turtle;
	private Group root;
	
	public TurtleWindow(Turtle turtle, Group root) {
		this.turtle = turtle;
		this.root = root;
	}
	
}
