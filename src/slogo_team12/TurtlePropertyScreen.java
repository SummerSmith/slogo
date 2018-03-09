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
    private TurtleImageComboBox turtle_image_combobox;
    private PenColorComboBox pen_color_combobox;
    private PenDownRadioButton pen_down_radio_button;
    private PenUpRadioButton pen_up_radio_button;
    private TurtleActiveRadioButton turtle_active_radio_button;
    private TurtleInactiveRadioButton turtle_inactive_radio_button;
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
	 * Reads in properties from a property file and gets the screen properties.
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
        new TurtlePropertiesActiveLabel(new Label(), root);
        new TurtlePropertiesActiveInactiveLabel(new Label(), root);
        new TurtlePropertiesHeaderLabel(new Label(), root);
        new TurtlePropertiesHeadingLabel(new Label(), root);
        new TurtlePropertiesIDLabel(new Label(), root);
        new TurtlePropertiesImageLabel(new Label(), root);
        new TurtlePropertiesInactiveLabel(new Label(), root);
        new TurtlePropertiesPenColorLabel(new Label(), root);
        new TurtlePropertiesPenThicknessLabel(new Label(), root);
        new TurtlePropertiesPenUpDownLabel(new Label(), root);
        new TurtlePropertiesPositionLabel(new Label(), root);
        new TurtlePropertiesXPositionLabel(new Label(), root);
        new TurtlePropertiesYPositionLabel(new Label(), root);
        new TurtlePropertiesPenUpLabel(new Label(), root);
        new TurtlePropertiesPenDownLabel(new Label(), root);
    }
    
    private void setWindows() {
        new TurtleIDWindow(root, myTurtle);
        new TurtleXPositionWindow(root, myTurtle);
        new TurtleYPositionWindow(root, myTurtle);
        new TurtleHeadingWindow(root, myTurtle);
        new TurtlePenThicknessWindow(root, myTurtle);
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
    	new TurtlePropertiesOkButton(new Button(), root, myTurtle, turtle_image_combobox, 
    			pen_color_combobox, pen_down_radio_button, turtle_active_radio_button);
    }
    
    public static Stage getStage() {
    	return stage;
    }    
}