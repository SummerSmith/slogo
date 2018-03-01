package gui_elements.labels;

import javafx.scene.Group;
import javafx.scene.control.Label;

public class PenColorLabel extends DefaultLabel {

	private static final String PROPERTIES_FILENAME = "pen_color_label.properties";	

	public PenColorLabel(Label label, Group root) {
		super(label, root, PROPERTIES_FILENAME);
	}
}
