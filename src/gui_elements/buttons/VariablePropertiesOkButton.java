package gui_elements.buttons;

import gui_elements.combo_boxes.PenColorComboBox;
import gui_elements.combo_boxes.TurtleImageComboBox;
import gui_elements.radio_buttons.PenDownRadioButton;
import gui_elements.radio_buttons.TurtleActiveRadioButton;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import parser.ProcessString;
import parser.TurtleManager;
import slogo_team12.Display;
import slogo_team12.EditVariablesScreen;
import slogo_team12.TurtlePropertyScreen;
import turtle.Turtle;
import user_data.UserVariables;
import windows.CommandWindow;
import windows.TurtleHeadingWindow;
import windows.TurtleIDWindow;
import windows.TurtlePenThicknessWindow;
import windows.TurtleWindow;
import windows.TurtleXPositionWindow;
import windows.TurtleYPositionWindow;
import windows.UserVariableLabelsWindow;
import windows.UserVariableValuesWindow;

public class VariablePropertiesOkButton extends DefaultButton {

	private static final String PROPERTIES_FILENAME = "variable_properties_ok_button.properties";
	private Button myButton;
	private Group myRoot;
		
	public VariablePropertiesOkButton(Button button, Group root) {
		super(button, root, PROPERTIES_FILENAME);
		myButton = button;
		myRoot = root;
		setButtonAction();
	}

	@Override
	public void setButtonAction() {
    	myButton.setOnAction(value -> {
    		ObservableList<Node> pane_labels = UserVariableLabelsWindow.getPane().getChildren();
    		ObservableList<Node> pane_values = UserVariableValuesWindow.getPane().getChildren();
    		for(int i = 0; i < pane_labels.size(); i++) {
    			Label label = (Label) pane_labels.get(i);
    			TextField text_field = (TextField) pane_values.get(i);
    			UserVariables.getVariablesMap().put(label.getText(), Double.parseDouble(text_field.getText()));
    		}
    		
    		for(String obj : UserVariables.getVariablesMap().keySet()) {
    			System.out.println(UserVariables.getVariablesMap().get(obj));
    		}
    		EditVariablesScreen.getStage().close();
    	});
	}
}