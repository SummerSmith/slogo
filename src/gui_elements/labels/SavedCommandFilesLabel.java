package gui_elements.labels;

import javafx.scene.Group;
import javafx.scene.control.Label;

public class SavedCommandFilesLabel extends DefaultLabel {

	private static final String PROPERTIES_FILENAME = "saved_command_files_label.properties";	

	public SavedCommandFilesLabel(Label label, Group root) {
		super(label, root, PROPERTIES_FILENAME);
	}
}
