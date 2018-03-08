package windows;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import turtle.Turtle;

public class UserCommandsWindow extends Windows {

	private Group myRoot;
	private static FlowPane flow_pane = new FlowPane();
	private static HBox hbox = new HBox();
	private Turtle myTurtle;
	private ImageView myImageView;
	private String full_directory_name = DIRECTORY_STRING + "user_commands_window.properties";
	private String prompt_text;
	private final String PANE_STYLE = "-fx-background-color: #ffffff";
	private static int x, y, width, height;
	
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
		flow_pane.setLayoutX(x);
		flow_pane.setLayoutY(y);
		flow_pane.setPrefSize(width, height);
		flow_pane.setStyle(PANE_STYLE);
		myRoot.getChildren().add(flow_pane);
	}

	@Override
	protected void setX(int x) {
		flow_pane.setLayoutX(x);
	}

	@Override
	protected void setY(int y) {
		flow_pane.setLayoutY(y);
	}

	@Override
	protected int getX() {
		return (int) flow_pane.getLayoutX();
	}

	@Override
	protected int getY() {
		return (int) flow_pane.getLayoutY();
	}
	
	@Override
	public Parent getWindowArea() {
		return flow_pane;
	}
	
	public static void addButton(Button button) {
		flow_pane.getChildren().add(button);
	}
}