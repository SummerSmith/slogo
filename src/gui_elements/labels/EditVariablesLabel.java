package gui_elements.labels;

import gui_elements.labels.DefaultLabel;
import javafx.scene.Group;
import javafx.scene.control.Label;

public class EditVariablesLabel extends DefaultLabel {

	private static final String PROPERTIES_FILENAME = "edit_variables_label.properties";	

	public EditVariablesLabel(Label label, Group root) {
		super(label, root, PROPERTIES_FILENAME);
	}
}
