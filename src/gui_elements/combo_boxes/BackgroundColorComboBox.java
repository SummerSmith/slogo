package gui_elements.combo_boxes;

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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class BackgroundColorComboBox extends ComboBoxes {
	
	private static final String PROPERTIES_FILENAME = "background_color_combo_box.properties";
	private final String FULL_COLOR_MAP_FILENAME = "data/color_map.properties";
	private ComboBox myComboBox;
	private Pane myPane;
	private Map<String, String> color_map;
	private Properties color_properties;
	private InputStream input;
	private int WHITE = 0;
	
	public BackgroundColorComboBox(ComboBox comboBox, Parent pane, Group root) {
		super(comboBox, root, PROPERTIES_FILENAME);
		myComboBox = comboBox;
		myPane = (Pane) pane;
		initialize();
	}
	
	private void initialize() {
		initiateColorMap();
		setDefaultBackgroundColor();
		chooseBackgroundColor();
	}

	private void initiateColorMap() {
		color_map = new HashMap<String, String>();
		color_properties = new Properties();
		input = null;
		try {
	  		input = new FileInputStream(FULL_COLOR_MAP_FILENAME);
	  		color_properties.load(input);
	  		for(Object color : color_properties.keySet()) {
	  			color_map.put((String) color, color_properties.getProperty((String) color));
	  		}
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
	
	private void setDefaultBackgroundColor() {
		myComboBox.getSelectionModel().select(WHITE);
	}
	
	private void chooseBackgroundColor() {
    	myComboBox.setOnAction((Event ev) -> {
    		String color = (String) myComboBox.getSelectionModel().getSelectedItem();
    		myPane.setStyle(color_map.get(color));
    	});
	}
}