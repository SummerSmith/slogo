package windows;

import java.awt.ScrollPane;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import turtle.Turtle;

public class TurtleWindow extends Windows {

	private Group myRoot;
	private ScrollPane scroll_pane = new ScrollPane();
	private BorderPane border_pane = new BorderPane();
	private Turtle myTurtle;
	private ImageView myImageView;
	private String full_directory_name = DIRECTORY_STRING + "turtle_window.properties";
	private String prompt_text;
	private final String PANE_STYLE = "-fx-background-color: #ffffff";
	
	public TurtleWindow(Turtle turtle, Group root, ImageView imageView) {
		myTurtle = turtle;
		myRoot = root;
		myImageView = imageView;
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
	
	@Override
	protected void createWindow() {
		border_pane.setLayoutX(x);
		border_pane.setLayoutY(y);
		border_pane.setPrefSize(width, height);
		border_pane.setCenter(myImageView);
		border_pane.setStyle(PANE_STYLE);
		myRoot.getChildren().add(border_pane);
	}

	@Override
	protected void setX(int x) {
		border_pane.setLayoutX(x);
	}

	@Override
	protected void setY(int y) {
		border_pane.setLayoutY(y);
	}

	@Override
	protected int getX() {
		return (int) border_pane.getLayoutX();
	}

	@Override
	protected int getY() {
		return (int) border_pane.getLayoutY();
	}
	
	@Override
	public Parent getWindowArea() {
		return border_pane;
	}
}