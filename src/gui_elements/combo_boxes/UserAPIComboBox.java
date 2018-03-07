package gui_elements.combo_boxes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import gui_elements.labels.user_api_labels.UserAPICommandDisplayLabel;
import javafx.event.Event;
import javafx.scene.Group;
import javafx.scene.control.ComboBox;

public class UserAPIComboBox extends ComboBoxes {

	private static final String PROPERTIES_FILENAME = "user_api_combo_box.properties";
	private static final String TEXT_FILE_HEADING = "data/command_texts/";
	private static final String TEXT_FILE_EXTENSION = ".txt";
	private String text_string = "";
	private ComboBox myComboBox;

	public UserAPIComboBox(ComboBox comboBox, Group root) {
		super(comboBox, root, PROPERTIES_FILENAME);
		myComboBox = comboBox;
		initialize();
	}
	
	private void initialize() {
		chooseCommand();
	}
	
	private void chooseCommand() {
    	myComboBox.setOnAction((Event ev) -> {
    		String command = (String) myComboBox.getSelectionModel().getSelectedItem();
    		try {
				Scanner scanner = new Scanner(new File(TEXT_FILE_HEADING + command + TEXT_FILE_EXTENSION));
				while(scanner.hasNextLine()) {
					text_string += scanner.nextLine() + "\n";
				}
				UserAPICommandDisplayLabel.setLabelText(text_string);
				text_string = "";
			} catch (FileNotFoundException e) {
				System.err.println("User API text file for " + command + " not found!");
			}
    	});
	}
}
