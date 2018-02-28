package gui_elements.buttons;

import javafx.scene.Group;
import javafx.scene.control.Button;
import parser.ProcessString;
import slogo_team12.Display;
import windows.CommandWindow;

public class RunButton extends DefaultButton {

	private static final String PROPERTIES_FILENAME = "run_button.properties";
	private Button myButton;
		
	public RunButton(Button button, Group root) {
		super(button, root, PROPERTIES_FILENAME);
		myButton = button;
		setButtonAction();
	}

	@Override
	public void setButtonAction() {
    	myButton.setOnAction(value -> {
    		Display.setRunButtonPressed();
    	});
	}
}