package gui_elements.labels;

import javafx.scene.Group;
import javafx.scene.control.Label;

public class TurtleImageLabel extends DefaultLabel {

	private static final String PROPERTIES_FILENAME = "turtle_image_label.properties";	

	public TurtleImageLabel(Label label, Group root) {
		super(label, root, PROPERTIES_FILENAME);
	}
}
