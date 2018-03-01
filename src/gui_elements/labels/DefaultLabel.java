package gui_elements.labels;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

/**
 * This class creates a GUI label for "SLogo" that is assigned 
 * default properties.
 * 
 * @author Aditya Sridhar
 */
public abstract class DefaultLabel {
	
	private final int LABEL_WIDTH = 160;
	private final String X_LOC_STRING = "x_loc";
	private final String Y_LOC_STRING = "y_loc";
	private final String TEXT_STRING = "text";
	private final String DIRECTORY_STRING = "data/label_properties/";
	private final Paint TEXT_COLOR = Color.YELLOW;
	private Label myLabel;
	private Group myRoot;
	private Properties properties;
	private InputStream input;
	private double x, y;
	private String text;
	private String full_label_filename;

	/*
	 * Constructor for DefaultButton, takes in a button, a Group object 
	 * (root), and a properties filename as parameters.
	 */
	public DefaultLabel(Label label, Group root, String properties_filename) {
		myLabel = label;
		myRoot = root;
		full_label_filename = DIRECTORY_STRING + properties_filename;
		initialize();
	}

	/*
	 * Calls methods to initialize the label properties.
	 */
	private void initialize() {
		setDefaults();
		getProperties();
		initializeText();
		setLocation();
		addLabelToScene();
	}

	/*
	 * Sets the default properties of the label.
	 */
	private void setDefaults() {
		myLabel.setTextFill(TEXT_COLOR);
		myLabel.setPrefWidth(LABEL_WIDTH);
	}

	/*
	 * Reads the label properties from the properties file.
	 */
	private void getProperties() {
		properties = new Properties();
		input = null;
		try {
	  		input = new FileInputStream(full_label_filename);
	  		properties.load(input);

	  		x = Integer.parseInt(properties.getProperty(X_LOC_STRING));
	  		y = Integer.parseInt(properties.getProperty(Y_LOC_STRING));
	  		text = properties.getProperty(TEXT_STRING);
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

	/*
	 * Sets specific label's text.
	 */
	private void initializeText() {
		myLabel.setText(text);
	}

	/*
	 * Sets specific label's location.
	 */
	private void setLocation() {
		myLabel.setLayoutX(x);
		myLabel.setLayoutY(y);
	}
	
	/*
	 * Adds the specific label to the scene.
	 */
	private void addLabelToScene() {
		myRoot.getChildren().add(myLabel);
	}
}