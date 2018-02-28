package gui_elements.combo_boxes;

import javafx.scene.Group;
import javafx.scene.control.ComboBox;

public class LanguageComboBox extends ComboBoxes {

	private static final String PROPERTIES_FILENAME = "language_combo_box.properties";
	
	public LanguageComboBox(ComboBox comboBox, Group root) {
		super(comboBox, root, PROPERTIES_FILENAME);
	}

	@Override
	protected void chooseBackgroundColor() {
		// TODO Auto-generated method stub
		
	}
	
}
