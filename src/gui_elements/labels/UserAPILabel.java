package gui_elements.labels;

import javafx.scene.Group;
import javafx.scene.control.Label;

public class UserAPILabel extends DefaultLabel {

	private static final String PROPERTIES_FILENAME = "user_api_label.properties";	

	public UserAPILabel(Label label, Group root) {
		super(label, root, PROPERTIES_FILENAME);
	}
}
