package gui_elements.buttons;

import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import windows.CommandWindow;

public class ClearButton extends DefaultButton {

	private static final String PROPERTIES_FILENAME = "clear_button.properties";
	private Button myButton;
		
	public ClearButton(Button button, Group root) {
		super(button, root, PROPERTIES_FILENAME);
		myButton = button;
		setButtonAction();
	}

	@Override
	public void setButtonAction() {
    	myButton.setOnAction(value -> {
    		CommandWindow.clearWindow();
    	});
	}
}