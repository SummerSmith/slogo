package image_classes;

import javafx.scene.Group;

public class TurtleImageClass extends ImageClass {

	private static final String DEFAULT_TURTLE_IMAGE_NAME = "turtle_image1";
	
	public TurtleImageClass(Group root) {
		super(DEFAULT_TURTLE_IMAGE_NAME, root);
	}
	
	public TurtleImageClass(String image_name, Group root) {
		super(image_name, root);
	}
}
