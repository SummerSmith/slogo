package image_classes;

import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import slogo_team12.TurtlePropertyScreen;
import turtle.Turtle;
import windows.TurtleWindow;

public class TurtleImageClass extends ImageClass {

	private static final String DEFAULT_TURTLE_IMAGE_NAME = "turtle_image1";
	private Turtle myTurtle;
	private ImageView myImageView;

	public TurtleImageClass(Group root, Turtle turtle) {
		super(DEFAULT_TURTLE_IMAGE_NAME, root);
		myTurtle = turtle;
		myImageView = getImageView();
		TurtleWindow.addTurtleToTurtleWindow(myImageView);
		myTurtle.setImageView(myImageView);
		initialize();
	}

	public TurtleImageClass(String image_name, Group root, Turtle turtle) {
		super(image_name, root);
		myTurtle = turtle;
		myImageView = getImageView();
		initialize();
	}

	private void initialize() {
		setTurtlePropertiesOnClick();
	}

	private void setTurtlePropertiesOnClick() {
		// GetDragFeature get_drag_feature = new GetDragFeature(myTurtle, myImageView);
		getImageView().addEventFilter(MouseEvent.MOUSE_PRESSED, e -> {
			if (e.isPrimaryButtonDown() && e.getClickCount() == 2) {
				TurtlePropertyScreen turtle_property_screen = new TurtlePropertyScreen(myTurtle);
				turtle_property_screen.start(new Stage());
			}
		});
	}

	public void changeImageView() {

	}
}