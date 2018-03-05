package windows;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import turtle.Turtle;

public class CommandWindow extends Windows {

	private Group myRoot;
	private static TextArea text_area;
	private String full_directory_name = DIRECTORY_STRING + "command_window.properties";
	private String prompt_text;
	private final String PROMPT_TEXT_STRING = "prompt_text";
	
	public CommandWindow(Group root) {
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
	  		prompt_text = properties.getProperty(PROMPT_TEXT_STRING);
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
		text_area = new TextArea();
		text_area.setLayoutX(x);
		text_area.setLayoutY(y);
		text_area.setPrefSize(width, height);
		text_area.setPromptText(prompt_text);
		myRoot.getChildren().add(text_area);
	}

	@Override
	protected void setX(int x) {
		text_area.setLayoutX(x);
	}

	@Override
	protected void setY(int y) {
		text_area.setLayoutY(y);
	}

	@Override
	protected int getX() {
		return (int) text_area.getLayoutX();
	}

	@Override
	protected int getY() {
		return (int) text_area.getLayoutY();
	}
	
	@Override
	public Parent getWindowArea() {
		return text_area;
	}
	
	public static void clearWindow() {
		text_area.clear();
	}
	
	public static String getText() {
		return text_area.getText();
	}
}