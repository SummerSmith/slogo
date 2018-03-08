package turtle;

import image_classes.TurtleImageClass;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import parser.TurtleManager;
import windows.TurtleWindow;

public class CreateTurtle {

	private Group myRoot;
	private Turtle myTurtle;
	
	public CreateTurtle(Group root) {
		myRoot = root;
		initialize();
	}
	
	private void initialize() {
		myTurtle = new Turtle();
        TurtleManager.addActiveTurtle(myTurtle);
        new TurtleImageClass(myRoot, myTurtle).getImageView();
	}
	
	public Turtle getTurtle() {
		return myTurtle;
	}
}