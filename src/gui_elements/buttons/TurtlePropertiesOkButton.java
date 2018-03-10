package gui_elements.buttons;

import gui_elements.combo_boxes.PenColorComboBox;
import gui_elements.combo_boxes.TurtleImageComboBox;
import gui_elements.radio_buttons.PenDownRadioButton;
import gui_elements.radio_buttons.TurtleActiveRadioButton;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import parser.ProcessString;
import parser.TurtleManager;
import slogo_team12.Display;
import slogo_team12.TurtlePropertyScreen;
import turtle.Turtle;
import windows.CommandWindow;
import windows.TurtleHeadingWindow;
import windows.TurtleIDWindow;
import windows.TurtlePenThicknessWindow;
import windows.TurtleWindow;
import windows.TurtleXPositionWindow;
import windows.TurtleYPositionWindow;

public class TurtlePropertiesOkButton extends DefaultButton {

	private static final String PROPERTIES_FILENAME = "turtle_properties_ok_button.properties";
	private Button myButton;
	private Group myRoot;
	private Turtle myTurtle;
	private TurtleImageComboBox turtle_image_combobox;
	private PenColorComboBox pen_color_combobox;
	private PenDownRadioButton pen_down_radio_button;
	private TurtleActiveRadioButton turtle_active_radio_button;
		
	public TurtlePropertiesOkButton(Button button, Group root, Turtle turtle, 
			TurtleImageComboBox turtle_image_combobox, PenColorComboBox pen_color_combobox, 
			PenDownRadioButton pen_down_radio_button, TurtleActiveRadioButton turtle_active_radio_button) {
		super(button, root, PROPERTIES_FILENAME);
		myButton = button;
		myRoot = root;
		myTurtle = turtle;
		this.turtle_image_combobox = turtle_image_combobox;
		this.pen_color_combobox = pen_color_combobox;
		this.pen_down_radio_button = pen_down_radio_button;
		this.turtle_active_radio_button = turtle_active_radio_button;
		setButtonAction();
	}

	@Override
	public void setButtonAction() {
    	myButton.setOnAction(value -> {
    		setID();
    		setImage();
    		setPositionAndHeading();
    		setPenProperties();
    		setActiveState();
    		setError();
    		TurtlePropertyScreen.getStage().close();
    	});
	}
	
	private void setID() {
		TurtleManager.getAllIDsByTurtle().remove(myTurtle);
		TurtleManager.getAllTurtlesByID().remove(myTurtle.getID());
		myTurtle.setID(Integer.parseInt(TurtleIDWindow.getText()));
		TurtleManager.getAllIDsByTurtle().put(myTurtle, myTurtle.getID());
		TurtleManager.getAllTurtlesByID().put(myTurtle.getID(), myTurtle);
	}
	
	private void setImage() {
		turtle_image_combobox.setImage();
	}
	
	private void setPositionAndHeading() {
		CommandWindow.getWindow().setText("setxy " + 
				Double.parseDouble(TurtleXPositionWindow.getWindow().getText()) + " " +	
				Double.parseDouble(TurtleYPositionWindow.getWindow().getText()) + " setheading " + 
				Double.parseDouble(TurtleHeadingWindow.getWindow().getText()));
	}
		
	private void setPenProperties() {
		myTurtle.setPenColor(pen_color_combobox.getPenColor());
		myTurtle.setPenThickness(Double.parseDouble(TurtlePenThicknessWindow.getText()));		
		if(pen_down_radio_button.getPenDownRadioButton().isSelected()) {
			myTurtle.setPenDown(true);
		}
		else {
			myTurtle.setPenDown(false);
		}
	}
	
	private void setActiveState() {
		if(turtle_active_radio_button.getActiveRadioButton().isSelected() && !TurtleManager.getActiveTurtles().contains(myTurtle)) {
			TurtleManager.getActiveTurtles().add(myTurtle);
		}
		else if(!turtle_active_radio_button.getActiveRadioButton().isSelected() && TurtleManager.getActiveTurtles().contains(myTurtle)) {
			TurtleManager.getActiveTurtles().remove(myTurtle);
		}
	}
	
	private void setError() {
		Display.setRunButtonPressed(true);
		Label error = Display.getErrorLabel();
		if(myRoot.getChildren().contains(error)) {
			myRoot.getChildren().remove(error);
			Display.setErrorString("");
		}
	}
}