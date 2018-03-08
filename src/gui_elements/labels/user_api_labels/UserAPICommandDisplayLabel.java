package gui_elements.labels.user_api_labels;

import com.sun.java_cup.internal.runtime.Scanner;

import gui_elements.labels.DefaultLabel;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.text.TextAlignment;

public class UserAPICommandDisplayLabel extends DefaultLabel {

	private static final String PROPERTIES_FILENAME = "user_api_command_display_label.properties";	
	private static Label myLabel;

	public UserAPICommandDisplayLabel(Label label, Group root) {
		super(label, root, PROPERTIES_FILENAME);
		myLabel = label;
	}
		
	public static void setLabelText(String text) {
		myLabel.setText(text);
		myLabel.setAlignment(Pos.TOP_LEFT);
		myLabel.setWrapText(true);
	}
}