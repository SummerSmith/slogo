package gui_elements.buttons;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

/**
 * This class creates a GUI button for "SLogo" that is assigned 
 * default properties.
 * 
 * @author Aditya Sridhar
 */
public abstract class DefaultButton {
	
	private final int WIDTH = 160;
	private final String STYLE = "-fx-background-color: #ff0000";
	private final String X_LOC_STRING = "x_loc";
	private final String Y_LOC_STRING = "y_loc";
	private final String TEXT_STRING = "text";
	private final String DIRECTORY_STRING = "data/button_properties/";
	private final Paint COLOR = Color.WHITE;
	private Button myButton;
	private Group myRoot;
	private Properties properties;
	private InputStream input;
	private double x, y;
	private String text;
	private String full_button_filename;

	/*
	 * Constructor for DefaultButton, takes in a button, a Group object 
	 * (root), and a properties filename as parameters.
	 */
	public DefaultButton(Button button, Group root, String properties_filename) {
		myButton = button;
		myRoot = root;
		full_button_filename = DIRECTORY_STRING + properties_filename;
		initialize();
	}

	/*
	 * Calls methods to initialize the button properties.
	 */
	private void initialize() {
		setDefaults();
		getProperties();
		initializeText();
		setLocation();
		addButtonToScene();
	}

	/*
	 * Sets the default properties of the button.
	 */
	private void setDefaults() {
		myButton.setTextFill(COLOR);
		myButton.setStyle(STYLE);
		myButton.setPrefWidth(WIDTH);
	}

	/*
	 * Reads the button properties from the properties file.
	 */
	private void getProperties() {
		properties = new Properties();
		input = null;
		try {
	  		input = new FileInputStream(full_button_filename);
	  		properties.load(input);

	  		x = Integer.parseInt(properties.getProperty(X_LOC_STRING));
	  		y = Integer.parseInt(properties.getProperty(Y_LOC_STRING));
	  		text = properties.getProperty(TEXT_STRING);
	  		
	   	} catch (IOException ex) {
			System.err.println("Button file input does not exist!");
	   	} catch (Exception ey) {
			System.err.println("The properties for the button could not be retrieved completely.");
	  	} finally {
	  		if (input != null) {
	  			try {
	  				input.close();
	  			} catch (IOException e) {
	  				System.err.println("Button file input cannot close!");
	  			}
	  		}
	  	}			
	}

	/*
	 * Sets specific button's text.
	 */
	private void initializeText() {
		myButton.setText(text);
	}

	/*
	 * Sets specific button's location.
	 */
	private void setLocation() {
		myButton.setLayoutX(x);
		myButton.setLayoutY(y);
	}
	
	/*
	 * Adds the specific button to the scene.
	 */
	private void addButtonToScene() {
		myRoot.getChildren().add(myButton);
	}
	
	protected Button getButton() {
		return myButton;
	}
	
	/*
	 * Abstract method for button's action (listener).
	 */
	public abstract void setButtonAction();
}