package gui_elements.combo_boxes;

import javafx.scene.Group;
import javafx.scene.control.ComboBox;

public class TurtleImageComboBox extends ComboBoxes {

	private static final String PROPERTIES_FILENAME = "turtle_image_combo_box.properties";
	
	public TurtleImageComboBox(ComboBox comboBox, Group root) {
		super(comboBox, root, PROPERTIES_FILENAME);
	}
	
}
