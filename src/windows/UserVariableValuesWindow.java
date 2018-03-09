package windows;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import turtle.Turtle;
import user_data.UserVariables;

public class UserVariableValuesWindow extends Windows {

	private Group myRoot;
	private static FlowPane flow_pane;
	private Turtle myTurtle;
	private ImageView myImageView;
	private String full_directory_name = DIRECTORY_STRING + "user_variable_values_window.properties";
	private String prompt_text;
	private final String PANE_STYLE = "-fx-background-color: #ffffff";
	private static int x, y, width, height;
	
	public UserVariableValuesWindow(Group root) {
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
		
		HashMap<String, Double> variables_map = (HashMap<String, Double>) UserVariables.getVariablesMap();
		for(String variable_name : variables_map.keySet()) {
			double value = variables_map.get(variable_name);
			TextField variable_value_field = new TextField(variable_name);
			variable_value_field.setAlignment(Pos.CENTER);
			variable_value_field.setPrefSize(width, height / 10);
			variable_value_field.setText(value + "");
			flow_pane.getChildren().add(variable_value_field);
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