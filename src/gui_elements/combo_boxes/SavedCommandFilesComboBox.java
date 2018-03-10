package gui_elements.combo_boxes;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import user_data.UserCommandsSaver;

public class SavedCommandFilesComboBox extends ComboBoxes {
	
	private static final String PROPERTIES_FILENAME = "saved_command_files_combo_box.properties";
	private ComboBox myComboBox;
	private InputStream input;
	private File[] files;
	private int DEFAULT_FILE = 0;
	
	public SavedCommandFilesComboBox(ComboBox comboBox, Group root) {
		super(comboBox, root, PROPERTIES_FILENAME);
		myComboBox = comboBox;
		initialize();
	}
	
	private void initialize() {
		getFiles();
		setDefaultSavedFile();
		chooseSavedFile();
	}
	
	private void getFiles() {
		files = new UserCommandsSaver().getFileNames();
  		for(int element_number = 0; element_number < files.length; element_number++) {
  			myComboBox.getItems().add(files[element_number].toString());
  		}
	}
	
	private void setDefaultSavedFile() {
//		myComboBox.getSelectionModel()SavedCommandFilesComboBox.;
	}
	
	private void chooseSavedFile() {
    	myComboBox.setOnAction((Event ev) -> {
    		String saved_file = (String) myComboBox.getSelectionModel().getSelectedItem();
    		new UserCommandsSaver().loadCommands(saved_file);
    	});
	}
}