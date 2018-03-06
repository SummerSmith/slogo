package slogo_team12;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import gui_elements.buttons.ClearButton;
import gui_elements.buttons.RunButton;
import gui_elements.buttons.EditVariablesButton;
import gui_elements.combo_boxes.UserAPIComboBox;
import gui_elements.labels.UserAPICommandDisplayLabel;
import gui_elements.labels.UserAPIHeadingLabel;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import turtle.Turtle;
import user_data.UserController;
import windows.CommandWindow;
import windows.TurtleWindow;

public class TurtlePropertyScreen extends Application {
	private final Paint BACKGROUND = Color.BLACK;
    private final String PROPERTY_FILENAME = "data/user_api.properties";
    private final String TITLE_PROPERTY = "title";
    private final String WIDTH_PROPERTY = "width";
    private final String HEIGHT_PROPERTY = "height";
    private UserAPIHeadingLabel user_api_heading_label;
    private UserAPICommandDisplayLabel user_api_command_display_label;
    private UserAPIComboBox user_api_combo_box;
    private String title;
    private int screen_width, screen_height;
    private Stage stage;
   	private Properties menu_properties;
	private InputStream input;
	private Turtle myTurtle;
	
	// Additional setup for the turtle property screen.
    private Scene myScene;
    private static Group root;
    
    public TurtlePropertyScreen(Turtle turtle) {
    	myTurtle = turtle;
    	System.out.println(turtle.getID());
    }

    /**
     * Initializes the stage for the user API screen.
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
     * Sets the stage for the user API.
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
    	user_api_heading_label = new UserAPIHeadingLabel(new Label(), root);
    	user_api_combo_box = new UserAPIComboBox(new ComboBox(), root);
    	user_api_command_display_label = new UserAPICommandDisplayLabel(new Label(), root);
    }
}