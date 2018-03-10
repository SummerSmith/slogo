package gui_elements.labels;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class ErrorLabel extends DefaultLabel {

	private static final String PROPERTIES_FILENAME = "error_label.properties";
	private Label myLabel;
	private Properties properties;
	private InputStream input;

	public ErrorLabel(Label label, Group root) {
		super(label, root, PROPERTIES_FILENAME);
		myLabel = label;
		root.getChildren().remove(label);
	}

	public Label getLabel() {
		return myLabel;
	}
}