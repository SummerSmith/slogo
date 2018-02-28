package gui_elements.combo_boxes;

import javafx.scene.Group;
import javafx.scene.control.ComboBox;

public class PenColorComboBox extends ComboBoxes {

	private static final String PROPERTIES_FILENAME = "pen_color_combo_box.properties";
	
	public PenColorComboBox(ComboBox comboBox, Group root) {
		super(comboBox, root, PROPERTIES_FILENAME);
	}

}
