package windows;

import java.awt.ScrollPane;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import turtle.Turtle;

public class UserCommandsWindow extends Windows {

	private Group myRoot;
	private ScrollPane scroll_pane = new ScrollPane();
	private GridPane grid_pane = new GridPane();
	private Turtle myTurtle;
	private ImageView myImageView;
	private String full_directory_name = DIRECTORY_STRING + "user_commands_window.properties";
	private String prompt_text;
	private final String PANE_STYLE = "-fx-background-color: #ffffff";
	
	public UserCommandsWindow(Group root) {
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
		grid_pane.setLayoutX(x);
		grid_pane.setLayoutY(y);
		grid_pane.setPrefSize(width, height);
		grid_pane.setStyle(PANE_STYLE);
		myRoot.getChildren().add(grid_pane);
	}

	@Override
	protected void setX(int x) {
		grid_pane.setLayoutX(x);
	}

	@Override
	protected void setY(int y) {
		grid_pane.setLayoutY(y);
	}

	@Override
	protected int getX() {
		return (int) grid_pane.getLayoutX();
	}

	@Override
	protected int getY() {
		return (int) grid_pane.getLayoutY();
	}
	
	@Override
	public Parent getWindowArea() {
		return grid_pane;
	}
}