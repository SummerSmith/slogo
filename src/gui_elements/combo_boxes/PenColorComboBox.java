package gui_elements.combo_boxes;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import slogo_team12.Display;
import turtle.Turtle;

public class PenColorComboBox extends ComboBoxes {
	
	private static final String PROPERTIES_FILENAME = "pen_color_combo_box.properties";
	private final String FULL_COLOR_MAP_FILENAME = "data/color_map.properties";
	private final String COLOR_HEADING = "-fx-stroke: ";
	private String pen_color;
	private ComboBox myComboBox;
	private Turtle myTurtle;
	private Pane myPane;
	private Map<String, String> color_map_by_name;
	private Map<String, String> color_map_by_hex;
	private Properties color_properties;
	private InputStream input;
	
	public PenColorComboBox(ComboBox comboBox, Group root, Turtle turtle) {
		super(comboBox, root, PROPERTIES_FILENAME);
		myComboBox = comboBox;
		myTurtle = turtle;
		this.pen_color = pen_color;
		initialize();
	}
	
	private void initialize() {
		initiateColorMap();
		setPenColorSelection();
		choosePenColor();
	}

	private void initiateColorMap() {
		color_map_by_name = new HashMap<String, String>();
		color_map_by_hex = new HashMap<String, String>();
		color_properties = new Properties();
		input = null;
		try {
	  		input = new FileInputStream(FULL_COLOR_MAP_FILENAME);
	  		color_properties.load(input);
	  		for(Object color : color_properties.keySet()) {	  			
	  			color_map_by_name.put((String) color, color_properties.getProperty((String) color));
	  			color_map_by_hex.put(color_properties.getProperty((String) color), (String) color);
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
	
	private void setPenColorSelection() {
		ObservableList<String> combo_box_items = myComboBox.getItems();
		String color_hex = myTurtle.getPenColor().substring(COLOR_HEADING.length());
		String color_name = color_map_by_hex.get(color_hex);
		myComboBox.getSelectionModel().select(combo_box_items.indexOf(color_name));
	}
	
	private void choosePenColor() {
    	myComboBox.setOnAction((Event ev) -> {
    		pen_color = (String) myComboBox.getSelectionModel().getSelectedItem();
    	});
	}
	
	public String getPenColor() {
		if(pen_color == null)
			return myTurtle.getPenColor();
		return COLOR_HEADING + color_map_by_name.get(pen_color);
	}
}