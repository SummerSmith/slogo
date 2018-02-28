package gui_elements.buttons;

import javafx.scene.Group;
import javafx.scene.control.Button;

public class UserAPIButton extends DefaultButton {

	private static final String PROPERTIES_FILENAME = "user_api_button.properties";
		
	public UserAPIButton(Button button, Group root) {
		super(button, root, PROPERTIES_FILENAME);
	}

	@Override
	public void setButtonAction() {
		// TODO Auto-generated method stub
		
	}
}