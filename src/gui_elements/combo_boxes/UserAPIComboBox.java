package gui_elements.combo_boxes;

import javafx.scene.Group;
import javafx.scene.control.ComboBox;

public class UserAPIComboBox extends ComboBoxes {

	private static final String PROPERTIES_FILENAME = "background_color_combo_box.properties";

	public UserAPIComboBox(ComboBox comboBox, Group root, String properties_filename) {
		super(comboBox, root, properties_filename);
	}
	
}
