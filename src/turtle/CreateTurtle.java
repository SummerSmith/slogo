package turtle;

import image_classes.TurtleImageClass;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import parser.TurtleManager;
import windows.TurtleWindow;

public class CreateTurtle {

	private Group myRoot;
	
	public CreateTurtle(Group root) {
		myRoot = root;
		initialize();
	}
	
	private void initialize() {
		Turtle turtle = new Turtle();
        TurtleManager.addActiveTurtle(turtle);
        ImageView imageView = new TurtleImageClass(myRoot).getImageView();
        TurtleWindow.addTurtleToTurtleWIndow(imageView);
        turtle.setImageView(imageView);
	}
}