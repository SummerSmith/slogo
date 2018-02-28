package gui_elements.labels;

import javafx.scene.Group;
import javafx.scene.control.Label;

public class UserVariablesLabel extends DefaultLabel {

	private static final String PROPERTIES_FILENAME = "user_variables_label.properties";	

	public UserVariablesLabel(Label label, Group root) {
		super(label, root, PROPERTIES_FILENAME);
	}
}
