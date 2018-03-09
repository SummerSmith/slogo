package gui_elements.buttons;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import slogo_team12.Display;
import slogo_team12.EditVariablesScreen;

public class EditVariablesButton extends DefaultButton {

	private static final String PROPERTIES_FILENAME = "edit_variables_button.properties";
	private Button myButton;
	
	public EditVariablesButton(Button button, Group root) {
		super(button, root, PROPERTIES_FILENAME);
		myButton = button;
		setButtonAction();
	}

	@Override
	public void setButtonAction() {
    	myButton.setOnAction(value -> {
    		EditVariablesScreen edit_variables_screen = new EditVariablesScreen();
    		edit_variables_screen.start(new Stage());
    	});		
	}
}