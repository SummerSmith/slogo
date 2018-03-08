package gui_elements.radio_buttons;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javafx.scene.Group;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class DefaultRadioButton {

	private ToggleGroup myToggleGroup;
	private Group myRoot;
	private RadioButton myRadioButton;
	private String full_filename;
	private static final String DIRECTORY_STRING = "data/radio_button_properties/";
	private static final String X_LOC_STRING = "x_loc";
	private static final String Y_LOC_STRING = "y_loc";
	private Properties properties;
	private InputStream input;
	private int x, y;
	
	public DefaultRadioButton(RadioButton radioButton, Group root, ToggleGroup toggleGroup, String property_filename) {
		myRadioButton = radioButton;
		myToggleGroup = toggleGroup;
		myRoot = root;
		full_filename = DIRECTORY_STRING + property_filename;
		initialize();
	}
	
	private void initialize() {
		getProperties();
		setRadioButtonValues();
		addRadioButtonToScene();
	}
	
	private void getProperties() {
		properties = new Properties();
		input = null;
		try {
	  		input = new FileInputStream(full_filename);
	  		properties.load(input);

	  		x = Integer.parseInt(properties.getProperty(X_LOC_STRING));
	  		y = Integer.parseInt(properties.getProperty(Y_LOC_STRING));
		} catch (IOException ex) {
//	   		E
	  	} finally {
	  		if (input != null) {
	  			try {
	  				input.close();
	  			} catch (IOException e) {
//	  				E
	  			}
	  		}
	  	}
	}
	
	private void setRadioButtonValues() {
		myRadioButton.setLayoutX(x);
		myRadioButton.setLayoutY(y);
		myRadioButton.setToggleGroup(myToggleGroup);
	}
	
	private void addRadioButtonToScene() {
        myRoot.getChildren().add(myRadioButton);
	}
	
	public RadioButton getRadioButton() {
		return myRadioButton;
	}
}