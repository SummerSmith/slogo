package gui_elements.radio_buttons;

import javafx.scene.Group;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class PenUpRadioButton extends DefaultRadioButton {
		
	private static final String PROPERTIES_FILENAME = "pen_up_radio_button.properties";
	private RadioButton myRadioButton;
	
	public PenUpRadioButton(RadioButton radioButton, Group root, ToggleGroup group) {
		super(radioButton, root, group, PROPERTIES_FILENAME);
		myRadioButton = getRadioButton();
	}
	
	public RadioButton getPenUpRadioButton() {
		return myRadioButton;
	}
}