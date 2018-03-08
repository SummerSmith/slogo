package gui_elements.labels;

import javafx.scene.Group;
import javafx.scene.control.Label;

public class UserAPIHeadingLabel extends DefaultLabel {

	private static final String PROPERTIES_FILENAME = "user_api_heading_label.properties";	

	public UserAPIHeadingLabel(Label label, Group root) {
		super(label, root, PROPERTIES_FILENAME);
	}
}
