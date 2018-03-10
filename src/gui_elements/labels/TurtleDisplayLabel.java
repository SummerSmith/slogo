package gui_elements.labels;

import javafx.scene.Group;
import javafx.scene.control.Label;

public class TurtleDisplayLabel extends DefaultLabel {

	private static final String PROPERTIES_FILENAME = "turtle_display_label.properties";	

	public TurtleDisplayLabel(Label label, Group root) {
		super(label, root, PROPERTIES_FILENAME);
	}
}
