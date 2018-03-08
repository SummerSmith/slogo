package windows;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.swing.plaf.synth.SynthSeparatorUI;

import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import turtle.Turtle;

public class TurtleIDWindow extends Windows {

	private Group myRoot;
	private static TextField text_field;
	private String full_directory_name = DIRECTORY_STRING + "turtle_id_window.properties";
	private static int x, y, width, height;
	private Turtle myTurtle;
	
	public TurtleIDWindow(Group root, Turtle turtle) {
		myRoot = root;
		myTurtle = turtle;
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
		text_field = new TextField();
		text_field.setLayoutX(x);
		text_field.setLayoutY(y);
		text_field.setPrefSize(width, height);
		text_field.setText(myTurtle.getID() + "");
		myRoot.getChildren().add(text_field);
	}

	@Override
	protected void setX(int x) {
		text_field.setLayoutX(x);
	}

	@Override
	protected void setY(int y) {
		text_field.setLayoutY(y);
	}

	@Override
	protected int getX() {
		return (int) text_field.getLayoutX();
	}

	@Override
	protected int getY() {
		return (int) text_field.getLayoutY();
	}
	
	@Override
	public Parent getWindowArea() {
		return text_field;
	}
	
	public static void clearWindow() {
		text_field.clear();
	}
	
	public static String getText() {
		return text_field.getText();
	}
}