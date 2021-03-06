package gui_elements.labels.user_windows_labels;

import gui_elements.labels.DefaultLabel;
import javafx.scene.Group;
import javafx.scene.control.Label;

public class UserHistoryLabel extends DefaultLabel {

	private static final String PROPERTIES_FILENAME = "user_history_label.properties";	

	public UserHistoryLabel(Label label, Group root) {
		super(label, root, PROPERTIES_FILENAME);
	}
}
