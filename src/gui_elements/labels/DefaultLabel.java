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
	
	private final String X_LOC_STRING = "x_loc";
	private final String Y_LOC_STRING = "y_loc";
	private final String TEXT_STRING = "text";
	private final String WIDTH_STRING = "width";
	private final String HEIGHT_STRING = "height";
	private final String STYLE_STRING = "style";
	private final String DIRECTORY_STRING = "data/label_properties/";
	private Label myLabel;
	private Group myRoot;
	private Properties properties;
	private InputStream input;
	private double x, y;
	private int width, height;
	private String style;
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
		getProperties();
		initializeText();
		setLabelValues();
		addLabelToScene();
	}

	/*
	 * Reads the label properties from the properties file.
	 */
	private void getProperties() {
		properties = new Properties();
		input = null;
		try {
	  		input = new FileInputStream(full_label_filename);
	  		System.out.println(full_label_filename);
	  		properties.load(input);

	  		x = Integer.parseInt(properties.getProperty(X_LOC_STRING));
	  		y = Integer.parseInt(properties.getProperty(Y_LOC_STRING));
	  		width = Integer.parseInt(properties.getProperty(WIDTH_STRING));
	  		height = Integer.parseInt(properties.getProperty(HEIGHT_STRING));
	  		style = properties.getProperty(STYLE_STRING);
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
	 * Sets specific label's values.
	 */
	private void setLabelValues() {
		myLabel.setLayoutX(x);
		myLabel.setLayoutY(y);
		myLabel.setStyle(style);
		myLabel.setPrefSize(width, height);
	}
	
	/*
	 * Adds the specific label to the scene.
	 */
	private void addLabelToScene() {
		myRoot.getChildren().add(myLabel);
	}
}