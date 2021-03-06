package gui_elements.labels.user_windows_labels;

import gui_elements.labels.DefaultLabel;
import javafx.scene.Group;
import javafx.scene.control.Label;

public class UserCommandsLabel extends DefaultLabel {

	private static final String PROPERTIES_FILENAME = "user_commands_label.properties";	

	public UserCommandsLabel(Label label, Group root) {
		super(label, root, PROPERTIES_FILENAME);
		label.setPrefWidth(250);
	}
}
