package gui_elements.labels;

import javafx.scene.Group;
import javafx.scene.control.Label;

public class BackgroundColorLabel extends DefaultLabel {

	private static final String PROPERTIES_FILENAME = "background_color_label.properties";	
	
	public BackgroundColorLabel(Label label, Group root) {
		super(label, root, PROPERTIES_FILENAME);
	}
}