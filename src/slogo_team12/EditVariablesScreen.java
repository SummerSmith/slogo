package slogo_team12;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import gui_elements.buttons.ClearButton;
import gui_elements.buttons.RunButton;
import gui_elements.buttons.TurtlePropertiesOkButton;
import gui_elements.buttons.VariablePropertiesOkButton;
import gui_elements.buttons.EditVariablesButton;
import gui_elements.combo_boxes.PenColorComboBox;
import gui_elements.combo_boxes.TurtleImageComboBox;
import gui_elements.combo_boxes.UserAPIComboBox;
import gui_elements.labels.EditVariablesLabel;
import gui_elements.labels.turtle_properties_labels.TurtlePropertiesActiveInactiveLabel;
import gui_elements.labels.turtle_properties_labels.TurtlePropertiesActiveLabel;
import gui_elements.labels.turtle_properties_labels.TurtlePropertiesHeaderLabel;
import gui_elements.labels.turtle_properties_labels.TurtlePropertiesHeadingLabel;
import gui_elements.labels.turtle_properties_labels.TurtlePropertiesIDLabel;
import gui_elements.labels.turtle_properties_labels.TurtlePropertiesImageLabel;
import gui_elements.labels.turtle_properties_labels.TurtlePropertiesInactiveLabel;
import gui_elements.labels.turtle_properties_labels.TurtlePropertiesPenColorLabel;
import gui_elements.labels.turtle_properties_labels.TurtlePropertiesPenDownLabel;
import gui_elements.labels.turtle_properties_labels.TurtlePropertiesPenThicknessLabel;
import gui_elements.labels.turtle_properties_labels.TurtlePropertiesPenUpDownLabel;
import gui_elements.labels.turtle_properties_labels.TurtlePropertiesPenUpLabel;
import gui_elements.labels.turtle_properties_labels.TurtlePropertiesPositionLabel;
import gui_elements.labels.turtle_properties_labels.TurtlePropertiesXPositionLabel;
import gui_elements.labels.turtle_properties_labels.TurtlePropertiesYPositionLabel;
import gui_elements.labels.user_api_labels.UserAPICommandDisplayLabel;
import gui_elements.labels.user_api_labels.UserAPIHeaderLabel;
import gui_elements.radio_buttons.PenDownRadioButton;
import gui_elements.radio_buttons.PenUpRadioButton;
import gui_elements.radio_buttons.TurtleActiveRadioButton;
import gui_elements.radio_buttons.TurtleInactiveRadioButton;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import parser.TurtleManager;
import turtle.Turtle;
import user_data.UserController;
import windows.CommandWindow;
import windows.TurtleHeadingWindow;
import windows.TurtleIDWindow;
import windows.TurtlePenThicknessWindow;
import windows.TurtleXPositionWindow;
import windows.TurtleYPositionWindow;
import windows.UserVariableLabelsWindow;
import windows.UserVariableValuesWindow;
import windows.TurtleWindow;

public class EditVariablesScreen extends Application {
	private final Paint BACKGROUND = Color.BLACK;
    private final String PROPERTY_FILENAME = "data/edit_variables_screen.properties";
    private final String TITLE_PROPERTY = "title";
    private final String WIDTH_PROPERTY = "width";
    private final String HEIGHT_PROPERTY = "height";
    private String title;
    private int screen_width, screen_height;
    private static Stage stage;
   	private Properties menu_properties;
	private InputStream input;
	
	// Additional setup for the turtle property screen.
    private Scene myScene;
    private static Group root;
    
    public EditVariablesScreen() {
    }

    /**
     * Initializes the stage for the turtle property screen.
     */
    @Override
    public void start(Stage stage) {
    	this.stage = stage;
    	initialize();
    }

    /**
     * Sets the scene and initializes the screen properties.
     */
    private void initialize() {
    	root = new Group();
    	getProperties();
    	setScene();
        setStage();
        setGUIComponents();
    }
    
    private void setScene() {
        myScene = new Scene(root, screen_width, screen_height, BACKGROUND);
    }
    
    /**
     * Sets the stage for the turtle property screen.
     */
    private void setStage() {
    	stage.setScene(myScene);
    	stage.setTitle(title);
    	stage.show();
    	stage.setResizable(false);
    }
    
    /**
     * Reads in properties from a property file and gets the  
     * screen properties.
     */
    private void getProperties() {
    	menu_properties = new Properties();
    	input = null;
     	try {
    		input = new FileInputStream(PROPERTY_FILENAME);
    		menu_properties.load(input);
    		title = menu_properties.getProperty(TITLE_PROPERTY);
    		screen_width = Integer.parseInt(menu_properties.getProperty(WIDTH_PROPERTY));
    		screen_height = Integer.parseInt(menu_properties.getProperty(HEIGHT_PROPERTY));
     	} catch (IOException ex) {
    		System.err.println("Display file input does not exist!");
     	} catch (Exception ey) {     		
			System.err.println("The properties for the display could not be retrieved completely.");
    	} finally {
    		if (input != null) {
    			try {
    				input.close();
    			} catch (IOException e) {
    				System.err.println("Display file input cannot close!");
    			}
    		}
    	}
    }
    
    private void setGUIComponents() {
    	setLabels();
    	setWindows();
    	setButtons();
    }
    
    private void setLabels() {
        new EditVariablesLabel(new Label(), root);
    }
    
    private void setWindows() {
    	new UserVariableLabelsWindow(root);
    	new UserVariableValuesWindow(root);
    }
         
    private void setButtons() {
    	new VariablePropertiesOkButton(new Button(), root);
    }
    
    public static Stage getStage() {
    	return stage;
    }    
}