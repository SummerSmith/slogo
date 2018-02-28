package gui_elements.labels;

import javafx.scene.Group;
import javafx.scene.control.Label;

public class LanguageLabel extends DefaultLabel {
	private static final String PROPERTIES_FILENAME = "language_label.properties";	

	public LanguageLabel(Label label, Group root) {
		super(label, root, PROPERTIES_FILENAME);
	}
}
