package gui_elements.labels;

import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class ErrorLabel extends DefaultLabel {

	private static final String PROPERTIES_FILENAME = "error_label.properties";
	private static final Paint TEXT_COLOR = Color.YELLOW;
	private static final String BACKGROUND_COLOR = "-fx-background-color: #0000ff";
	private Label myLabel;

	public ErrorLabel(Label label, Group root) {
		super(label, root, PROPERTIES_FILENAME);
		label.setTextFill(TEXT_COLOR);
		label.setStyle(BACKGROUND_COLOR);
		label.setPrefSize(200, 20);
		root.getChildren().remove(label);
		myLabel = label;
	}
	
	public Label getLabel() {
		return myLabel;
	}
}