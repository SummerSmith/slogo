package gui_elements.buttons;

import javafx.scene.Group;
import javafx.scene.control.Button;

public class EditVariablesButton extends DefaultButton {

	private static final String PROPERTIES_FILENAME = "edit_variables_button.properties";
		
	public EditVariablesButton(Button button, Group root) {
		super(button, root, PROPERTIES_FILENAME);
	}

	@Override
	public void setButtonAction() {
		// TODO Auto-generated method stub
		
	}
}