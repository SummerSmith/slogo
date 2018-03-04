package image_classes;

import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import slogo_team12.TurtlePropertyScreen;

public class TurtleImageClass extends ImageClass {

	private static final String DEFAULT_TURTLE_IMAGE_NAME = "turtle_image1";
	
	public TurtleImageClass(Group root) {
		super(DEFAULT_TURTLE_IMAGE_NAME, root);
		setTurtlePropertiesOnClick();
	}
	
	public TurtleImageClass(String image_name, Group root) {
		super(image_name, root);
		setTurtlePropertiesOnClick();
	}
	
//	private void setTurtlePropertiesOnClick() {
//    	imageView.addEventFilter(MouseEvent.MOUSE_PRESSED, e -> {
//            if(e.isPrimaryButtonDown()) {
//            	TurtlePropertyScreen turtle_property_screen = new TurtlePropertyScreen();
//        		turtle_property_screen.start(new Stage());
//            }
//        });
//	}
}
