package gui_elements.radio_buttons;

import javafx.scene.Group;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class PenDownRadioButton extends DefaultRadioButton {

	private static final String PROPERTIES_FILENAME = "pen_down_radio_button.properties";
	private RadioButton myRadioButton;
	
	public PenDownRadioButton(RadioButton radioButton, Group root, ToggleGroup group) {
		super(radioButton, root, group, PROPERTIES_FILENAME);
		myRadioButton = getRadioButton();
	}
	
	public RadioButton getPenDownRadioButton() {
		return myRadioButton;
	}
}