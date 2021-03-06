package windows;

import java.awt.ScrollPane;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import image_classes.TurtleImageClass;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import turtle.Turtle;

public class TurtleWindow extends Windows {

	private Group myRoot;
	private static Group paneRoot;
	private static ScrollPane scroll_pane = new ScrollPane();
	private static BorderPane pane = new BorderPane();
	private static String full_directory_name = DIRECTORY_STRING + "turtle_window.properties";
	private static String prompt_text;
	private static final String DEFAULT_COLOR = "#ffffff";
	private static final String PANE_STYLE = "-fx-background-color: ";
	private static int initialTurtleX, initialTurtleY;
	private static int x, y, width, height;
	
	public TurtleWindow(Group root) {
		myRoot = root;
		initialize();
	}
	
	private void initialize() {
		getProperties();
		createWindow();
	}

	@Override
	protected void getProperties() {
		properties = new Properties();
		input = null;
		try {
	  		input = new FileInputStream(full_directory_name);
	  		properties.load(input);

	  		x = Integer.parseInt(properties.getProperty(X_LOC_STRING));
	  		y = Integer.parseInt(properties.getProperty(Y_LOC_STRING));
	  		width = Integer.parseInt(properties.getProperty(WIDTH));
	  		height = Integer.parseInt(properties.getProperty(HEIGHT));
	   	} catch (IOException ex) {
			System.err.println("Turtle window file input does not exist!");	   		
	   	} catch (Exception ey) {
			System.err.println("Turtle window properties could not be retrieved completely.");
	  	} finally {
	  		if (input != null) {
	  			try {
	  				input.close();
	  			} catch (IOException e) {
	  				System.err.println("Turtle window file input cannot close!");
	  			}
	  		}
	  	}
	}
	
	@Override
	protected void createWindow() {
		pane.setLayoutX(x);
		pane.setLayoutY(y);
		pane.setPrefSize(width, height);
		pane.setStyle(PANE_STYLE + DEFAULT_COLOR);
		myRoot.getChildren().add(pane);
		
		paneRoot = new Group();
		pane.getChildren().add(paneRoot);		
	}
	
	public void setWindowColor(String color) {
		pane.setStyle(PANE_STYLE + color);
	}
	
	public static void addTurtleToTurtleWindow(ImageView imageView) {
		initialTurtleX = (int) (width / 2 - imageView.getFitWidth() / 2);
		imageView.setLayoutX(initialTurtleX);
		initialTurtleY = (int) (height / 2 - imageView.getFitHeight() / 2);
		imageView.setLayoutY(initialTurtleY);
		paneRoot.getChildren().add(imageView);		
	}

	@Override
	protected void setX(int x) {
		pane.setLayoutX(x);
	}

	@Override
	protected void setY(int y) {
		pane.setLayoutY(y);
	}

	@Override
	protected int getX() {
		return (int) pane.getLayoutX();
	}

	@Override
	protected int getY() {
		return (int) pane.getLayoutY();
	}
	
	@Override
	public Parent getWindowArea() {
		return pane;
	}
	
	public static int getPaneWidth() {
		return width;
	}
	
	public static int getPaneHeight() {
		return height;
	}

	public static int getInitialTurtleX() {
		return initialTurtleX;
	}
	
	public static int getInitialTurtleY() {
		return initialTurtleY;
	}
	
	public static Group getPaneRoot() {
		return paneRoot;
	}
	
	public static Pane getPane() {
		return pane;
	}
}