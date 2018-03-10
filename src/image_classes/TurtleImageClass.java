package image_classes;

import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import slogo_team12.Display;
import slogo_team12.TurtlePropertyScreen;
import turtle.Turtle;
import windows.TurtleWindow;

public class TurtleImageClass extends ImageClass {

	private static final String DEFAULT_TURTLE_IMAGE_NAME = "turtle_image1";
	private Turtle myTurtle;
	private ImageView myImageView;
	private TurtlePropertyScreen turtle_property_screen;
	
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
		Circle clip = new Circle(myImageView.getFitWidth());
		myImageView.setClip(clip);
		
		initialize();
	}

	private void initialize() {
		setTurtlePropertiesOnClick();
	}

	private void setTurtlePropertiesOnClick() {

//    	GetDragFeature get_drag_feature = new GetDragFeature(myTurtle, myImageView);
		turtle_property_screen = new TurtlePropertyScreen(myTurtle);
		myImageView.addEventFilter(MouseEvent.MOUSE_PRESSED, e -> {
    		if(e.isPrimaryButtonDown()) {
    			if(e.getClickCount() == 2) {
            		turtle_property_screen.start(new Stage());
            	}
            }
        });
	}
	
	public TurtlePropertyScreen getTurtlePropertyScreen() {
		return turtle_property_screen;
	}
}