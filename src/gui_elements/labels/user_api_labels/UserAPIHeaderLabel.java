package gui_elements.labels.user_api_labels;

import gui_elements.labels.DefaultLabel;
import javafx.scene.Group;
import javafx.scene.control.Label;

public class UserAPIHeaderLabel extends DefaultLabel {

	private static final String PROPERTIES_FILENAME = "user_api_heading_label.properties";	

	public UserAPIHeaderLabel(Label label, Group root) {
		super(label, root, PROPERTIES_FILENAME);
	}
}
