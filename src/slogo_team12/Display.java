package slogo_team12;

import javafx.application.Application;
import javafx.stage.Stage;
import turtle.Turtle;
import windows.CommandWindow;
import windows.TurtleWindow;
import windows.UserCommandsWindow;
import windows.UserHistoryWindow;
import windows.UserVariablesWindow;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Properties;

import gui_elements.buttons.Buttons;
import gui_elements.combo_boxes.ComboBoxes;
import gui_elements.labels.Labels;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

/**
 * This class displays the main GUI for "SLogo." Here, the user can enter commands into the 
 * command window, save methods and commands, define variables, choose GUI settings from 
 * lists of selections, and get access to API methods. The "Display" class contains different 
 * windows to manage the GUI, including a WindowElements interface and specific Window 
 * classes that implement this interface (TurtleWindow, CommandWindow, UserVariablesWindow, 
 * UserCommandsWindow, and UserHistoryWindow). This class has a main method, so this is the 
 * program to run.
 * 
 * @author Aditya Sridhar
 */
public class Display extends Application {

    private final Paint BACKGROUND = Color.WHITE;
    private final String PROPERTY_FILENAME = "data/display.properties";
    private final String TITLE_PROPERTY = "title";
    private final String WIDTH_PROPERTY = "width";
    private final String HEIGHT_PROPERTY = "height";
    private final String IMAGE_PROPERTY = "image";
    private final String IMAGE_WIDTH_PROPERTY = "imgWidth";
    private final String IMAGE_HEIGHT_PROPERTY = "imgHeight";
    private final String IMAGE_XLOC_PROPERTY = "imgXLoc";
    private final String IMAGE_YLOC_PROPERTY = "imgYLoc";
    private String title;
    private String image_name;
    private int screen_width;
    private int screen_height;
    private int image_width;
    private int image_height;
    private int image_xloc;
    private int image_yloc;
    private boolean setIntroLabels = true;
    private Stage stage;
   	private Properties menu_properties;
	private InputStream input;
	private Image image;
	private ImageView imageView;
	private Turtle turtle;
	
	// Additional setup for the display
    private Scene myScene;
    private Group root;

    /**
     * Initializes the stage for the display.
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
    	setProperties();
        myScene = new Scene(root, screen_width, screen_height, BACKGROUND);
        setStage();
        setGUIComponents();
    	setImage();
    }

    /**
     * Reads in properties from a property file and sets the  
     * screen properties.
     */
    private void setProperties() {
    	menu_properties = new Properties();
    	input = null;
     	try {
    		input = new FileInputStream(PROPERTY_FILENAME);
    		menu_properties.load(input);
    		title = menu_properties.getProperty(TITLE_PROPERTY);
    		screen_width = Integer.parseInt(menu_properties.getProperty(WIDTH_PROPERTY));
    		screen_height = Integer.parseInt(menu_properties.getProperty(HEIGHT_PROPERTY));
    		image_name = menu_properties.getProperty(IMAGE_PROPERTY);
    		image_width = Integer.parseInt(menu_properties.getProperty(IMAGE_WIDTH_PROPERTY));
    		image_height = Integer.parseInt(menu_properties.getProperty(IMAGE_HEIGHT_PROPERTY));
    		image_xloc = Integer.parseInt(menu_properties.getProperty(IMAGE_XLOC_PROPERTY));
    		image_yloc = Integer.parseInt(menu_properties.getProperty(IMAGE_YLOC_PROPERTY));
     	} catch (IOException ex) {
    		ex.printStackTrace();
    	} finally {
    		if (input != null) {
    			try {
    				input.close();
    			} catch (IOException e) {
    				e.printStackTrace();
    			}
    		}
    	}
    }
    
    /**
     * Calls methods to add the individual 
     * GUI components to the screen.
     */
    private void setGUIComponents() {
    	setWindows();
    	setLabels();
    	setButtons();
    	setComboBoxes();
    }
    
    private void setWindows() {
    	TurtleWindow tw = new TurtleWindow(turtle, root);
    	CommandWindow cw = new CommandWindow(root);
    	UserVariablesWindow uvw = new UserVariablesWindow(root);
    	UserHistoryWindow uhw = new UserHistoryWindow(root);
    	UserCommandsWindow ucw = new UserCommandsWindow(root);
    }
    
    private void setLabels() {
    	SLogoLabel sll = new SlogoLabel(root);
    	PenColorLabel pcl = new PenColorLabel(root);
    	BackgroundColorLabel bcl = new BackgroundColorLabel(root);
    	TurtleImageLabel til = new TurtleImageLabel(root);
    	UserAPILabel ual = new UserAPILabel(root);
    	LanguageLabel ll = new LanguageLabel(root);
    	TurtleDisplayLabel tdl = new TurtleDisplayLabel(root);
    	CommandWindowLabel cwl = new CommandWindowLabel(root);
    	UserVariablesLabel uvl = new UserVariablesLabel(root);
    	UserCommandsLabel ucl = new UserCommandsLabel(root);
    	UserHistoryLabel uhl = new UserHistoryLabel(root);
    }

    private void setButtons() {
    	ClearButton cb = new ClearButton(root);
    	RunButton rb = new RunButton(root);
    	SaveMethodButton smb = new SaveMethodButton(root);
    	UserAPIButton uab = new UserAPIButton(root);
    }

    private void setComboBoxes() {
    	PenColorComboBox pccb = new PenColorComboBox(root);
    	BackgroundColorComboBox bccb = new BackgroundColorComboBox(root);
    	TurtleImageComboBox ticb = new TurtleImageComboBox(root);
    	LanguageComboBox lcb = new LanguageComboBox(root);
    }

    /**
     * Sets the stage for the display.
     */
    private void setStage() {
    	stage.setScene(myScene);
    	stage.setTitle(title);
    	stage.show();
    	stage.setResizable(false);
    }
        
    /**
     * Sets the image for the display.
     */
    private void setImage() {
        image = new Image(getClass().getClassLoader().getResourceAsStream(image_name));
        imageView = new ImageView(image);
        imageView.setX(image_xloc);
        imageView.setY(image_yloc);
        imageView.setFitWidth(image_width);
        imageView.setFitHeight(image_height);
        root.getChildren().add(imageView);
    }
    
    /**
     * Returns the width of the display screen.
     */
    public int getScreenWidth() {
    	return screen_width;
    }

    /**
     * Returns the height of the display screen.
     */
    public int getScreenHeight() {
    	return screen_height;
    }

    /**
     * Starts the program.
     */
    public static void main(String[] args) {
        launch(args);
    }
}