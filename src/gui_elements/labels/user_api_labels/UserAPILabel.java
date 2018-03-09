package gui_elements.labels.user_api_labels;

import gui_elements.labels.DefaultLabel;
import javafx.scene.Group;
import javafx.scene.control.Label;

public class UserAPILabel extends DefaultLabel {

	private static final String PROPERTIES_FILENAME = "user_api_label.properties";	

	public UserAPILabel(Label label, Group root) {
		super(label, root, PROPERTIES_FILENAME);
		label.setPrefWidth(250);
	}

}
