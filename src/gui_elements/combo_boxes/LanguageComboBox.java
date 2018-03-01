package gui_elements.combo_boxes;

import javafx.event.Event;
import javafx.scene.Group;
import javafx.scene.control.ComboBox;
import slogo_team12.Display;

public class LanguageComboBox extends ComboBoxes {

	private static final String PROPERTIES_FILENAME = "language_combo_box.properties";
	private ComboBox myComboBox;
	private int ENGLISH = 1;
	
	public LanguageComboBox(ComboBox comboBox, Group root) {
		super(comboBox, root, PROPERTIES_FILENAME);
		myComboBox = comboBox;
		initialize();
	}
	
	private void initialize() {
		selectDefaultLanguage();
		chooseLanguage();
	}
	
	private void selectDefaultLanguage() {
		myComboBox.getSelectionModel().select(ENGLISH);
	}
	
	private void chooseLanguage() {
    	myComboBox.setOnAction((Event ev) -> {
    		String selectedLanguage = (String) myComboBox.getSelectionModel().getSelectedItem();
    		Display.setLanguage(selectedLanguage);
    	});
	}	
}