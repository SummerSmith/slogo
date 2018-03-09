package gui_elements.buttons;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import slogo_team12.Display;
import slogo_team12.UserAPIScreen;
import point.Point;

public class UserAPIButton extends DefaultButton {

	private static final String PROPERTIES_FILENAME = "user_api_button.properties";
	private Button myButton;
	
	public UserAPIButton(Button button, Group root) {
		super(button, root, PROPERTIES_FILENAME);
		myButton = button;
		setButtonAction();
	}

	@Override
	public void setButtonAction() {
    	myButton.setOnAction(value -> {
    		UserAPIScreen user_api_screen = new UserAPIScreen();
    		user_api_screen.start(new Stage());
    	});
	}
}