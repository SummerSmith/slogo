package slogo_team12;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.util.Duration;
import parser.BackEndManager;
import parser.TurtleManager;
import turtle.CreateTurtle;
import turtle.Turtle;
import user_data.UserController;
import windows.CommandWindow;
import windows.TurtleWindow;

import point.Point;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import gui_elements.buttons.ClearButton;
import gui_elements.buttons.RunButton;
import gui_elements.buttons.EditVariablesButton;
import gui_elements.buttons.UserAPIButton;
import gui_elements.combo_boxes.BackgroundColorComboBox;
import gui_elements.combo_boxes.LanguageComboBox;
import gui_elements.labels.BackgroundColorLabel;
import gui_elements.labels.CommandWindowLabel;
import gui_elements.labels.ErrorLabel;
import gui_elements.labels.LanguageLabel;
import gui_elements.labels.PenColorLabel;
import gui_elements.labels.TurtleDisplayLabel;
import gui_elements.labels.TurtleImageLabel;
import gui_elements.labels.user_api_labels.UserAPILabel;
import gui_elements.labels.user_windows_labels.UserCommandsLabel;
import gui_elements.labels.user_windows_labels.UserHistoryLabel;
import gui_elements.labels.user_windows_labels.UserVariablesLabel;
import image_classes.SLogoImageClass;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;

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
public class Display {

	private final Paint BACKGROUND = Color.BLACK;
	private final String PROPERTY_FILENAME = "data/display.properties";
	private final String TITLE_PROPERTY = "title";
	private final String WIDTH_PROPERTY = "width";
	private final String HEIGHT_PROPERTY = "height";
//	private final String IMAGE_PROPERTY = "image";
//	private final String IMAGE_WIDTH_PROPERTY = "imgWidth";
//	private final String IMAGE_HEIGHT_PROPERTY = "imgHeight";
//	private final String IMAGE_XLOC_PROPERTY = "imgXLoc";
//	private final String IMAGE_YLOC_PROPERTY = "imgYLoc";
	private static String myLanguage = "English";
	private static String errorString = "";
	private String title;
	private final int FRAMES_PER_SECOND = 2;
	private final int INITIAL_TIME_DELAY = 1000 / FRAMES_PER_SECOND;
	private int screen_width, screen_height; 
//	private int image_width, image_height, image_xloc, image_yloc;
//	private int time_delay = INITIAL_TIME_DELAY;
	private static boolean runButtonPressed;
//	private boolean setIntroLabels = true;
	//    private static List<Turtle> turtle_list = new ArrayList<Turtle>();
	//    private static List<Turtle> current_turtles;
	//    private static Map<Turtle, Integer> turtles_to_ids;
	//    private static Map<Integer, Turtle> ids_to_turtles;
	//    private static Map<Turtle, ImageView> turtle_images;
	private Stage stage;
	private Properties menu_properties;
	private InputStream input;
	private CommandWindow command_window;
	private TurtleWindow turtle_window;
//	private PenColorLabel pen_color_label;
//	private BackgroundColorLabel background_color_label;
//	private TurtleImageLabel turtle_image_label;
//	private LanguageLabel language_label;
//	private TurtleDisplayLabel turtle_display_label;
//	private CommandWindowLabel command_window_label;
//	private UserVariablesLabel user_variables_label;
//	private UserCommandsLabel user_commands_label;
//	private UserHistoryLabel user_history_label;
//	private UserAPILabel user_api_label;
	private static ErrorLabel error_label;
//	private ClearButton clear_button;
//	private RunButton run_button;
//	private UserAPIButton user_api_button;
//	private EditVariablesButton save_method_button;
//	private BackgroundColorComboBox background_color_combobox;
//	private LanguageComboBox language_combobox;
//	private ImageClass slogo_image_object;
	private Timeline animation;

	// Additional setup for the display

	private static Scene myScene;
	private static Group root;



	/**
	 * Sets the scene and initializes the screen properties.
	 */
	public void initialize(Stage stage) {
		root = new Group();
		//    	initializeStructures();
		getProperties();
		setScene();
		setStage(stage);
		setImages();
		setGUIComponents();
		setRunButtonPressed(false);
		new UserController(command_window);
		new CreateTurtle(root);
		startAnimation();
	}

	//    private void initializeStructures() {
	//        turtle_list = new ArrayList<Turtle>();
	//        current_turtles = new ArrayList<Turtle>();
	//        turtles_to_ids = new HashMap<Turtle, Integer>();
	//        ids_to_turtles = new HashMap<Integer, Turtle>();
	//        turtle_images = new HashMap<Turtle, ImageView>();
	//    }

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
			if(root.getChildren().contains(error_label.getLabel())) {
				root.getChildren().remove(error_label.getLabel());
				setErrorString("");
				error_label.getLabel().setText(errorString);
			}
			String text = CommandWindow.getText();
			if(text.equals("")) return;
			try {
				BackEndManager back_end_manager = new BackEndManager(text, myLanguage);
				back_end_manager.parse();
				for(Turtle turtle : TurtleManager.getActiveTurtles()) {
					moveImageView(turtle);
					if(turtle.getPenDown()) {
						drawLine(turtle);
					}
				}
				checkErrorLabel(text);
				CommandWindow.clearWindow();
				if(errorString.length() != 0) {
					//System.out.println("front end catch errors! " + errorString);
					if(root.getChildren().contains(error_label)) {
						root.getChildren().remove(error_label.getLabel());  
					}
					else {
						error_label.getLabel().setText(errorString);
						root.getChildren().remove(error_label.getLabel()); 
						root.getChildren().add(error_label.getLabel()); 
					}
				}
				else {
					//System.out.println("front end uncatch errors! ");
					root.getChildren().remove(error_label.getLabel()); 
				}
				runButtonPressed = false;
			} catch (Exception e) {
				System.err.println("After button was pressed, the nodes were not able to be constructed.");
				e.printStackTrace();
			}
		}
	}

	//    public static void createTurtle() {
	//    	Turtle new_turtle = new Turtle();
	//        turtle_list.add(new_turtle);
	//        current_turtles.add(new_turtle);
	//        turtles_to_ids.put(new_turtle, turtles_to_ids.size());
	//        ids_to_turtles.put(ids_to_turtles.size(), new_turtle);
	//        turtle_images = new HashMap<Turtle, ImageView>();
	//    }

	private void checkErrorLabel(String text) {
		if(!errorString.equals("")) {
			error_label.getLabel().setText(errorString);
			root.getChildren().add(error_label.getLabel());    				
		}
		else {
			updateUserHistoryWindow(text);
		}
	}

	private void updateUserHistoryWindow(String text) {
		UserController.updateUserHistoryWindow(text);
	}

	private void drawLine(Turtle turtle) {
		List<Point> nextPoints = turtle.getNextPoints();
		ImageView imageView = turtle.getImageView();
		for(int i = 0; i < nextPoints.size() - 1; i++) {
			Point curr_point = nextPoints.get(i);
			Point next_point = nextPoints.get(i + 1);
			double x_offset = TurtleWindow.getInitialTurtleX() + imageView.getFitWidth() / 2;
			double y_offset = TurtleWindow.getInitialTurtleY() + imageView.getFitHeight() / 2;
			Line line = new Line(curr_point.getX() + x_offset, 
					curr_point.getY() + y_offset, 
					next_point.getX() + x_offset, 
					next_point.getY() + y_offset);
			line.setStyle(turtle.getPenColor());
			line.setStrokeWidth(turtle.getPenThickness());
			TurtleWindow.getPaneRoot().getChildren().add(line);
		}
	}

	public void moveImageView(Turtle turtle) {
		System.out.println(TurtleWindow.getInitialTurtleX() + " " + TurtleWindow.getInitialTurtleY() + " " + turtle.getXLocation() + " " + turtle.getYLocation());
		ImageView imageView = turtle.getImageView();
		imageView.setLayoutX(TurtleWindow.getInitialTurtleX() + turtle.getXLocation());
		imageView.setLayoutY(TurtleWindow.getInitialTurtleY() + turtle.getYLocation());
		imageView.setRotate(turtle.getHeading());
		//    	AnchorPane pane = (AnchorPane) TurtleWindow.getPane();
		Group paneRoot = TurtleWindow.getPaneRoot();
		//    	if(turtle.getTurtleIsShowing() && !pane.getChildren().contains(imageView)) {
		if(turtle.getTurtleIsShowing() && !paneRoot.getChildren().contains(imageView)) {
			//    		pane.getChildren().set(0, imageView);
			TurtleWindow.getPaneRoot().getChildren().set(0, imageView);
		}
		//    	else if(!turtle.getTurtleIsShowing() && pane.getChildren().contains(imageView)) {
		else if(!turtle.getTurtleIsShowing() && paneRoot.getChildren().contains(imageView)) {
			//    		pane.getChildren().set(0, new ImageView());
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
		command_window = new CommandWindow(root);
		turtle_window = new TurtleWindow(root);
	}

	/*
	 * Sets up screen labels.
	 */
	private void setLabels() {
//		pen_color_label = new PenColorLabel(new Label(), root);
//		background_color_label = new BackgroundColorLabel(new Label(), root);
//		turtle_image_label = new TurtleImageLabel(new Label(), root);
//		language_label = new LanguageLabel(new Label(), root);
//		turtle_display_label = new TurtleDisplayLabel(new Label(), root);
//		command_window_label = new CommandWindowLabel(new Label(), root);
//		user_variables_label = new UserVariablesLabel(new Label(), root);
//		user_commands_label = new UserCommandsLabel(new Label(), root);
//		user_history_label = new UserHistoryLabel(new Label(), root);
//		user_api_label = new UserAPILabel(new Label(), root);
		new PenColorLabel(new Label(), root);
		new BackgroundColorLabel(new Label(), root);
		new TurtleImageLabel(new Label(), root);
		new LanguageLabel(new Label(), root);
		new TurtleDisplayLabel(new Label(), root);
		new CommandWindowLabel(new Label(), root);
		new UserVariablesLabel(new Label(), root);
		new UserCommandsLabel(new Label(), root);
		new UserHistoryLabel(new Label(), root);
		new UserAPILabel(new Label(), root);
		error_label = new ErrorLabel(new Label(), root);
	}

	/*
	 * Sets up screen buttons.
	 */
	private void setButtons() {
//		clear_button = new ClearButton(new Button(), root);
//		run_button = new RunButton(new Button(), root);
//		save_method_button = new EditVariablesButton(new Button(), root);
//		user_api_button = new UserAPIButton(new Button(), root);
		new ClearButton(new Button(), root);
		new RunButton(new Button(), root);
		new EditVariablesButton(new Button(), root);
		new UserAPIButton(new Button(), root);
	}

	/*
	 * Sets up screen comboBoxes.
	 */
	private void setComboBoxes() {
//		background_color_combobox = new BackgroundColorComboBox(new ComboBox(), turtle_window.getWindowArea(), root);
//		language_combobox = new LanguageComboBox(new ComboBox(), root);
		new BackgroundColorComboBox(new ComboBox(), turtle_window.getWindowArea(), root);
		new LanguageComboBox(new ComboBox(), root);
	}

	/**
	 * Sets the stage for the display.
	 */
	private void setStage(Stage stage) {
		stage.setScene(myScene);
		stage.setTitle(title);
		stage.show();
		stage.setResizable(false);
	}

	/**
	 * Sets the images for the display.
	 */
	private void setImages() {
//		slogo_image_object = new SLogoImageClass(root);
		new SLogoImageClass(root);
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

	public static Group getRoot() {
		return root;
	}

	private void handleKeyInput (KeyCode code) {
		if(code == KeyCode.UP) {

		}
	}

	public static void setErrorString(String string) {
		errorString = string;
	}

	public static Label getErrorLabel() {
		return error_label.getLabel();
	}

	public static Scene getScene() {
		return myScene;
	}


}