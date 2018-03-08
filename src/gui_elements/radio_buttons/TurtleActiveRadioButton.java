package gui_elements.radio_buttons;

import javafx.scene.Group;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class TurtleActiveRadioButton extends DefaultRadioButton {

	private static final String PROPERTIES_FILENAME = "turtle_active_radio_button.properties";
	private RadioButton myRadioButton;
	
	public TurtleActiveRadioButton(RadioButton radioButton, Group root, ToggleGroup group) {
		super(radioButton, root, group, PROPERTIES_FILENAME);
		myRadioButton = getRadioButton();
	}
	
	public RadioButton getActiveRadioButton() {
		return myRadioButton;
	}
}