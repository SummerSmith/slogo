package gui_elements.labels.turtle_properties_labels;

import gui_elements.labels.DefaultLabel;
import javafx.scene.Group;
import javafx.scene.control.Label;

public class TurtlePropertiesActiveLabel extends DefaultLabel {

	private static final String PROPERTIES_FILENAME = "turtle_properties/turtle_properties_active_label.properties";	

	public TurtlePropertiesActiveLabel(Label label, Group root) {
		super(label, root, PROPERTIES_FILENAME);
	}
}
