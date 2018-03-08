package gui_elements.labels.turtle_properties_labels;

import gui_elements.labels.DefaultLabel;
import javafx.scene.Group;
import javafx.scene.control.Label;

public class TurtlePropertiesXPositionLabel extends DefaultLabel {

	private static final String PROPERTIES_FILENAME = "turtle_properties/turtle_properties_x_position_label.properties";	

	public TurtlePropertiesXPositionLabel(Label label, Group root) {
		super(label, root, PROPERTIES_FILENAME);
	}
}
