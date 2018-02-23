package gui_elements.buttons;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class DefaultButton {
	
	private final int WIDTH = 80;
	private final Paint TEXT_COLOR = Color.WHITE;
	private final Paint BACKGROUND_COLOR = Color.RED;

	public DefaultButton(Button button) {
		initialize(button);
	}

	private void initialize(Button button) {
		button.setTextFill(TEXT_COLOR);
		button.setBackground(BACKGROUND_COLOR);
		button.setPrefWidth(WIDTH);
	}
}