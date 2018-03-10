package windows;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.TextAlignment;
import turtle.Turtle;
import user_data.UserVariables;

public class UserVariableLabelsWindow extends Windows {

	private Group myRoot;
	private static FlowPane flow_pane;
	private Turtle myTurtle;
	private ImageView myImageView;
	private String full_directory_name = DIRECTORY_STRING + "user_variable_labels_window.properties";
	private String prompt_text;
	private final String PANE_STYLE = "-fx-background-color: #ffffff";
	private final String LABEL_BACKGROUND_COLOR = "-fx-background-color: #0000ff";
	private final String LABEL_TEXT_FILL = "-fx-text-fill: #ffffff";
	private final String LABEL_TEXT_SIZE = "-fx-font-size: 16pt";
	private static int x, y, width, height;
	
	public UserVariableLabelsWindow(Group root) {
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
		flow_pane = new FlowPane();
		flow_pane.setLayoutX(x);
		flow_pane.setLayoutY(y);
		flow_pane.setPrefSize(width, height);
		flow_pane.setStyle(PANE_STYLE);
		myRoot.getChildren().add(flow_pane);
		
		
		System.out.println(UserVariables.getVariablesMap().keySet().size());
		for(String variable_name : UserVariables.getVariablesMap().keySet()) {
			Label variable_label = new Label(variable_name);
			variable_label.setAlignment(Pos.CENTER);
			variable_label.setPrefSize(width, height / 10);
			variable_label.setStyle(LABEL_BACKGROUND_COLOR + "; " + LABEL_TEXT_FILL + "; " + LABEL_TEXT_SIZE);
			flow_pane.getChildren().add(variable_label);
		}
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
	
	public static Pane getPane() {
		return flow_pane;
	}
	
	public static void addButton(Button button) {
		flow_pane.getChildren().add(button);
	}
}