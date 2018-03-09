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
import gui_elements.buttons.EditVariablesButton;
import gui_elements.combo_boxes.PenColorComboBox;
import gui_elements.combo_boxes.TurtleImageComboBox;
import gui_elements.combo_boxes.UserAPIComboBox;
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
import windows.TurtleWindow;

public class TurtlePropertyScreen extends Application {
	private final Paint BACKGROUND = Color.BLACK;
    private final String PROPERTY_FILENAME = "data/turtle_property_screen.properties";
    private final String TITLE_PROPERTY = "title";
    private final String WIDTH_PROPERTY = "width";
    private final String HEIGHT_PROPERTY = "height";
    private TurtlePropertiesActiveInactiveLabel turtle_properties_active_inactive_label;
    private TurtlePropertiesActiveLabel turtle_properties_active_label;
    private TurtlePropertiesHeaderLabel turtle_properties_header_label;
    private TurtlePropertiesHeadingLabel turtle_properties_heading_label;
    private TurtlePropertiesIDLabel turtle_properties_id_label;
    private TurtlePropertiesImageLabel turtle_properties_image_label;
    private TurtlePropertiesInactiveLabel turtle_properties_inactive_label;
    private TurtlePropertiesPenColorLabel turtle_properties_pen_color_label;
    private TurtlePropertiesPenThicknessLabel turtle_properties_pen_thickness_label;
    private TurtlePropertiesPenUpDownLabel turtle_properties_pen_up_down_label;
    private TurtlePropertiesPositionLabel turtle_properties_position_label;
    private TurtlePropertiesXPositionLabel turtle_properties_x_position_label;
    private TurtlePropertiesYPositionLabel turtle_properties_y_position_label;
    private TurtlePropertiesPenUpLabel turtle_properties_pen_up_label;
    private TurtlePropertiesPenDownLabel turtle_properties_pen_down_label;    
    private TurtleHeadingWindow turtle_heading_window;
    private TurtleIDWindow turtle_id_window;
    private TurtleImageComboBox turtle_image_combobox;
    private TurtlePenThicknessWindow turtle_pen_thickness_window;
    private TurtleXPositionWindow turtle_x_position_window;
    private TurtleYPositionWindow turtle_y_position_window;
    private PenColorComboBox pen_color_combobox;
    private PenDownRadioButton pen_down_radio_button;
    private PenUpRadioButton pen_up_radio_button;
    private TurtleActiveRadioButton turtle_active_radio_button;
    private TurtleInactiveRadioButton turtle_inactive_radio_button;
    private TurtlePropertiesOkButton turtle_properties_ok_button;
    private String title;
    private int screen_width, screen_height;
    private static Stage stage;
   	private Properties menu_properties;
	private InputStream input;
	private Turtle myTurtle;
	private int turtleID;
	
	// Additional setup for the turtle property screen.
    private Scene myScene;
    private static Group root;
    
    public TurtlePropertyScreen(Turtle turtle) {
    	myTurtle = turtle;
    	turtleID = turtle.getID();
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
    		title = menu_properties.getProperty(TITLE_PROPERTY) + " " + turtleID;
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
    	setComboBoxes();
    	setRadioButtons();
    	setButtons();
    }
    
    private void setLabels() {
        turtle_properties_active_label = new TurtlePropertiesActiveLabel(new Label(), root);
    	turtle_properties_active_inactive_label = new TurtlePropertiesActiveInactiveLabel(new Label(), root);
        turtle_properties_header_label = new TurtlePropertiesHeaderLabel(new Label(), root);
        turtle_properties_heading_label = new TurtlePropertiesHeadingLabel(new Label(), root);
        turtle_properties_id_label = new TurtlePropertiesIDLabel(new Label(), root);
        turtle_properties_image_label = new TurtlePropertiesImageLabel(new Label(), root);
        turtle_properties_inactive_label = new TurtlePropertiesInactiveLabel(new Label(), root);
        turtle_properties_pen_color_label = new TurtlePropertiesPenColorLabel(new Label(), root);
        turtle_properties_pen_thickness_label = new TurtlePropertiesPenThicknessLabel(new Label(), root);
        turtle_properties_pen_up_down_label = new TurtlePropertiesPenUpDownLabel(new Label(), root);
        turtle_properties_position_label = new TurtlePropertiesPositionLabel(new Label(), root);
        turtle_properties_x_position_label = new TurtlePropertiesXPositionLabel(new Label(), root);
        turtle_properties_y_position_label = new TurtlePropertiesYPositionLabel(new Label(), root);
        turtle_properties_pen_up_label = new TurtlePropertiesPenUpLabel(new Label(), root);
        turtle_properties_pen_down_label = new TurtlePropertiesPenDownLabel(new Label(), root);
    }
    
    private void setWindows() {
        turtle_id_window = new TurtleIDWindow(root, myTurtle);
        turtle_x_position_window = new TurtleXPositionWindow(root, myTurtle);
        turtle_y_position_window = new TurtleYPositionWindow(root, myTurtle);
        turtle_heading_window = new TurtleHeadingWindow(root, myTurtle);
        turtle_pen_thickness_window = new TurtlePenThicknessWindow(root, myTurtle);
    }
    
    private void setComboBoxes() {
    	turtle_image_combobox = new TurtleImageComboBox(new ComboBox(), root, myTurtle);
    	pen_color_combobox = new PenColorComboBox(new ComboBox(), root, myTurtle);
    }
    
    private void setRadioButtons() {
    	setPenStateRadioButton();
    	setTurtleActiveRadioButton();
    }
    
    private void setPenStateRadioButton() {
    	ToggleGroup pen_state_group = new ToggleGroup();
        pen_up_radio_button = new PenUpRadioButton(new RadioButton(), root, pen_state_group);
        pen_down_radio_button = new PenDownRadioButton(new RadioButton(), root, pen_state_group);

        if(myTurtle.getPenDown()) {
        	pen_down_radio_button.getPenDownRadioButton().setSelected(true);
        }
        else {
        	pen_up_radio_button.getPenUpRadioButton().setSelected(true);
        }
    }
    
    private void setTurtleActiveRadioButton() {
    	ToggleGroup pen_state_group = new ToggleGroup();
        turtle_active_radio_button = new TurtleActiveRadioButton(new RadioButton(), root, pen_state_group);
        turtle_inactive_radio_button = new TurtleInactiveRadioButton(new RadioButton(), root, pen_state_group);

        if(TurtleManager.getActiveTurtles().contains(myTurtle)) {
        	turtle_active_radio_button.getActiveRadioButton().setSelected(true);
        }
        else {
        	turtle_inactive_radio_button.getInactiveRadioButton().setSelected(true);
        }    	
    }
    
    private void setButtons() {
    	turtle_properties_ok_button = new TurtlePropertiesOkButton(new Button(), root, myTurtle, 
    			turtle_image_combobox, pen_color_combobox, pen_down_radio_button, turtle_active_radio_button);
    }
    
    public static Stage getStage() {
    	return stage;
    }    
}