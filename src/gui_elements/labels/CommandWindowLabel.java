package gui_elements.labels;

import javafx.scene.Group;
import javafx.scene.control.Label;

public class CommandWindowLabel extends DefaultLabel {

	private static final String PROPERTIES_FILENAME = "command_window_label.properties";	

	public CommandWindowLabel(Label label, Group root) {
		super(label, root, PROPERTIES_FILENAME);
	}
}
