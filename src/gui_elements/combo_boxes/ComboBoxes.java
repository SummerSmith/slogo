package gui_elements.combo_boxes;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import slogo_team12.Display;
import javafx.scene.Group;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

/**
 * This class creates a GUI drop-down menu (combo-box) for "SLogo" that is assigned 
 * default properties.
 * 
 * @author Aditya Sridhar
 */
public abstract class ComboBoxes {

	private final String X_LOC_STRING = "x_loc";
	private final String Y_LOC_STRING = "y_loc";
	private final String WIDTH_STRING = "width";
	private final String HEIGHT_STRING = "height";
	private final String NUM_ELEMENTS_STRING = "num_elements";
	private final String DIRECTORY_STRING = "data/combo_box_properties/";
	private final String ELEMENT_WORD = "element";
	private ComboBox myComboBox;
	private Group myRoot;
	private Properties properties;
	private InputStream input;
	private int x, y, width, height, number_of_elements;
	private String text;
	private String full_combo_box_filename;

	/*
	 * Constructor for a ComboBox, takes in a combo-box, a Group object 
	 * (root), and a properties filename as parameters.
	 */
	public ComboBoxes(ComboBox comboBox, Group root, String properties_filename) {
		myComboBox = comboBox;
		myRoot = root;
		full_combo_box_filename = DIRECTORY_STRING + properties_filename;
		initialize();
	}

	/*
	 * Calls methods to initialize the combo-box properties.
	 */
	private void initialize() {
		getProperties();
		addComboBoxStrings();
		setLocation();
		addComboBoxToScene();
	}

	/*
	 * Reads the combo-box properties from the properties file.
	 */
	private void getProperties() {
		properties = new Properties();
		input = null;
		try {
	  		input = new FileInputStream(full_combo_box_filename);
	  		properties.load(input);

	  		x = Integer.parseInt(properties.getProperty(X_LOC_STRING));
	  		y = Integer.parseInt(properties.getProperty(Y_LOC_STRING));
	  		width = Integer.parseInt(properties.getProperty(WIDTH_STRING));
	  		height = Integer.parseInt(properties.getProperty(HEIGHT_STRING));
	  		number_of_elements = Integer.parseInt(properties.getProperty(NUM_ELEMENTS_STRING));
	   	} catch (IOException ex) {
//		   		E
	  	} finally {
	  		if (input != null) {
	  			try {
	  				input.close();
	  			} catch (IOException e) {
//		  				E
	  			}
	  		}
	  	}			
	}

	/*
	 * Sets specific combo-box's text.
	 */
	private void addComboBoxStrings() {
		try {
	  		for(int element_number = 1; element_number <= number_of_elements; element_number++) {
	  			myComboBox.getItems().add(properties.getProperty(ELEMENT_WORD + element_number));
	  		}
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
	 * Sets specific combo-box's location.
	 */
	private void setLocation() {
		myComboBox.setLayoutX(x);
		myComboBox.setLayoutY(y);
	}
	
	/*
	 * Adds the specific combo-box to the scene.
	 */
	private void addComboBoxToScene() {
		myRoot.getChildren().add(myComboBox);
	}	
}