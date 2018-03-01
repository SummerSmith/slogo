package gui_elements.buttons;

import javafx.scene.Group;
import javafx.scene.control.Button;

public class SaveMethodButton extends DefaultButton {

	private static final String PROPERTIES_FILENAME = "save_method_button.properties";
		
	public SaveMethodButton(Button button, Group root) {
		super(button, root, PROPERTIES_FILENAME);
	}

	@Override
	public void setButtonAction() {
		// TODO Auto-generated method stub
		
	}
}