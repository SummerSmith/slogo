package slogo_team12;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.util.Duration;
import nodes.Node;
import parser.ConstructNodes;
import parser.ProcessString;
import turtle.Turtle;
import user_data.UserCommands;
import user_data.UserController;
import user_data.UserHistory;
import user_data.UserVariables;
import windows.CommandWindow;
import windows.TurtleWindow;
import windows.UserCommandsWindow;
import windows.UserHistoryWindow;
import windows.UserVariablesWindow;
import windows.Windows;

import point.Point;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import gui_elements.buttons.ClearButton;
import gui_elements.buttons.RunButton;
import gui_elements.buttons.SaveMethodButton;
import gui_elements.buttons.UserAPIButton;
import gui_elements.combo_boxes.BackgroundColorComboBox;
import gui_elements.combo_boxes.ComboBoxes;
import gui_elements.combo_boxes.LanguageComboBox;
import gui_elements.combo_boxes.PenColorComboBox;
import gui_elements.combo_boxes.TurtleImageComboBox;
import gui_elements.labels.BackgroundColorLabel;
import gui_elements.labels.CommandWindowLabel;
import gui_elements.labels.LanguageLabel;
import gui_elements.labels.PenColorLabel;
import gui_elements.labels.TurtleDisplayLabel;
import gui_elements.labels.TurtleImageLabel;
import gui_elements.labels.UserAPILabel;
import gui_elements.labels.UserCommandsLabel;
import gui_elements.labels.UserHistoryLabel;
import gui_elements.labels.UserVariablesLabel;
import image_classes.ImageClass;
import image_classes.SLogoImageClass;
import image_classes.TurtleImageClass;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
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

    private final Paint BACKGROUND = Color.BLACK;
    private final String PROPERTY_FILENAME = "data/display.properties";
    private final String TITLE_PROPERTY = "title";
    private final String WIDTH_PROPERTY = "width";
    private final String HEIGHT_PROPERTY = "height";
    private final String IMAGE_PROPERTY = "image";
    private final String IMAGE_WIDTH_PROPERTY = "imgWidth";
    private final String IMAGE_HEIGHT_PROPERTY = "imgHeight";
    private final String IMAGE_XLOC_PROPERTY = "imgXLoc";
    private final String IMAGE_YLOC_PROPERTY = "imgYLoc";
    private static String myLanguage = "English";
    private static String pen_color;
    private String title;
    private final int FRAMES_PER_SECOND = 2;
    private final int INITIAL_TIME_DELAY = 1000 / FRAMES_PER_SECOND;
    private int screen_width, screen_height, image_width, image_height, image_xloc, image_yloc;
    private int time_delay = INITIAL_TIME_DELAY;
    private static boolean runButtonPressed;
    private static boolean pen_down;
    private boolean setIntroLabels = true;
    private List<Turtle> turtle_list = new ArrayList<Turtle>();
    private Turtle current_turtle;
    private Stage stage;
   	private Properties menu_properties;
	private InputStream input;
	private CommandWindow command_window;
	private TurtleWindow turtle_window;
	private PenColorLabel pen_color_label;
	private BackgroundColorLabel background_color_label;
	private TurtleImageLabel turtle_image_label;
	private LanguageLabel language_label;
	private TurtleDisplayLabel turtle_display_label;
	private CommandWindowLabel command_window_label;
	private UserVariablesLabel user_variables_label;
	private UserCommandsLabel user_commands_label;
	private UserHistoryLabel user_history_label;
	private UserAPILabel user_api_label;
	private ClearButton clear_button;
	private RunButton run_button;
	private UserAPIButton user_api_button;
	private SaveMethodButton save_method_button;
	private PenColorComboBox pen_color_combobox;
	private BackgroundColorComboBox background_color_combobox;
	private TurtleImageComboBox turtle_image_combobox;
	private LanguageComboBox language_combobox;
	private ImageClass slogo_image_object, turtle_image_object;
    private Timeline animation;
    private static ImageView imageView;
	
	// Additional setup for the display
    private Scene myScene;
    private static Group root;

    /**
     * Initializes the stage for the display.
     */
    @Override
    public void start(Stage stage) {
    	this.stage = stage;
    	current_turtle = new Turtle();
    	turtle_list.add(current_turtle);
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
    	setImages();
        setGUIComponents();
        setRunButtonPressed(false);
        setPenDown(true);
        new UserController(command_window);
        startAnimation();
    }
    
    private void setScene() {
        myScene = new Scene(root, screen_width, screen_height, BACKGROUND);
        myScene.setOnKeyPressed(e -> handleKeyInput(e.getCode()));
    }
    
    private void startAnimation(){
        KeyFrame frame = new KeyFrame(Duration.millis(INITIAL_TIME_DELAY),
                e -> step());
        Timeline animation = new Timeline();
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.getKeyFrames().add(frame);
        this.animation = animation;
        animation.play();
    }

    private void step(){
    	if(runButtonPressed) {
    		String text = CommandWindow.getText();
    		List<String> command_strings = ProcessString.processString(text);
    		try {
				ConstructNodes nodes = new ConstructNodes(current_turtle, command_strings, myLanguage);
				updateTurtleImage();
				UserController.updateUserHistoryWindow(text);
				current_turtle.updateTurtleLineMap();
				if(pen_down)
					drawLine(current_turtle.getNextPoints());
    		} catch (Exception e) {
				System.err.println("After button was pressed, the nodes were not able to be constructed.");
			}
    		CommandWindow.clearWindow();
    		runButtonPressed = false;
    }
    }
    
    private void drawLine(List<Point> nextPoints) {
    	for(int i = 0; i < nextPoints.size() - 1; i++) {
    		Point curr_point = nextPoints.get(i);
    		Point next_point = nextPoints.get(i + 1);
    		int x_offset = (int) ((int) TurtleWindow.getInitialTurtleX() + imageView.getFitWidth() / 2);
    		int y_offset = (int) ((int) TurtleWindow.getInitialTurtleY() + imageView.getFitHeight() / 2);
    		Line line = new Line(curr_point.x + x_offset, 
    							 curr_point.y + y_offset, 
    							 next_point.x + x_offset, 
    							 next_point.y + y_offset);
    		line.setStyle(pen_color);
    		TurtleWindow.getPaneRoot().getChildren().add(line);
    	}
	}

	private void updateTurtleImage() {
    	imageView.setLayoutX(TurtleWindow.getInitialTurtleX() + current_turtle.getXLocation());				
    	imageView.setLayoutY(TurtleWindow.getInitialTurtleY() + current_turtle.getYLocation());
    	imageView.setRotate(current_turtle.getHeading());
    	if(current_turtle.isVisible() && !TurtleWindow.getPaneRoot().getChildren().contains(imageView)) {
    		TurtleWindow.getPaneRoot().getChildren().set(0, imageView);
    	}
    	else if(!current_turtle.isVisible() && TurtleWindow.getPaneRoot().getChildren().contains(imageView)) {
    		System.out.println("HELLO");
    		TurtleWindow.getPaneRoot().getChildren().set(0, new ImageView());
    	}
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
    
    /*
     * Sets up screen windows.
     */
    private void setWindows() {
    	command_window = new CommandWindow(current_turtle, root);
    	turtle_window = new TurtleWindow(current_turtle, root, turtle_image_object.getImageView());
    }

    /*
     * Sets up screen labels.
     */
    private void setLabels() {
    	pen_color_label = new PenColorLabel(new Label(), root);
    	background_color_label = new BackgroundColorLabel(new Label(), root);
    	turtle_image_label = new TurtleImageLabel(new Label(), root);
    	language_label = new LanguageLabel(new Label(), root);
    	turtle_display_label = new TurtleDisplayLabel(new Label(), root);
    	command_window_label = new CommandWindowLabel(new Label(), root);
    	user_variables_label = new UserVariablesLabel(new Label(), root);
    	user_commands_label = new UserCommandsLabel(new Label(), root);
    	user_history_label = new UserHistoryLabel(new Label(), root);
    	user_api_label = new UserAPILabel(new Label(), root);
    }

    /*
     * Sets up screen buttons.
     */
    private void setButtons() {
    	clear_button = new ClearButton(new Button(), root);
    	run_button = new RunButton(new Button(), root);
    	save_method_button = new SaveMethodButton(new Button(), root);
    	user_api_button = new UserAPIButton(new Button(), root);
    }

    /*
     * Sets up screen comboBoxes.
     */
    private void setComboBoxes() {
    	pen_color_combobox = new PenColorComboBox(new ComboBox(), pen_color, root);
    	background_color_combobox = new BackgroundColorComboBox(new ComboBox(), turtle_window.getWindowArea(), root);
    	turtle_image_combobox = new TurtleImageComboBox(current_turtle, new ComboBox(), root);
    	language_combobox = new LanguageComboBox(new ComboBox(), root);
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
     * Sets the images for the display.
     */
    private void setImages() {
    	slogo_image_object = new SLogoImageClass(root);
    	turtle_image_object = new TurtleImageClass(root);
    	imageView = turtle_image_object.getImageView();
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

    public static void setRunButtonPressed(boolean buttonPressedState) {
    	runButtonPressed = buttonPressedState;
    }
    
    public static void setLanguage(String language) {
    	myLanguage = language;
    }
    
    public static String getPenColor() {
    	return pen_color;
    }
    public static void setPenColor(String color) {
    	pen_color = color;
    }
    
	public static boolean getPenDown() {
		return pen_down;
	}
	
	public static void setPenDown(boolean pen_state) {
		pen_down = pen_state;
	}
	
	public static Group getRoot() {
		return root;
	}
		
	public static void setImageView(ImageView newImageView) {
		imageView = newImageView;
	}
	
    private void handleKeyInput (KeyCode code) {
        if(code == KeyCode.UP) {
        	
        }
    }
	
    /**
     * Starts the program.
     */
    public static void main(String[] args) {
        launch(args);
    }
}