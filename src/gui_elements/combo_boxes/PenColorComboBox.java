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
import javafx.scene.paint.Paint;
import slogo_team12.Display;
import turtle.Turtle;

public class PenColorComboBox extends ComboBoxes {
	
	private static final String PROPERTIES_FILENAME = "pen_color_combo_box.properties";
	private final String FULL_COLOR_MAP_FILENAME = "data/color_map.properties";
	private final String COLOR_HEADING = "-fx-stroke: ";
	private String pen_color;
	private ComboBox myComboBox;
	private Pane myPane;
	private Turtle myTurtle;
	private Map<String, String> color_map;
	private Properties color_properties;
	private InputStream input;
	private int BLACK = 0;
	
	public PenColorComboBox(ComboBox comboBox, Group root, Turtle turtle) {
		super(comboBox, root, PROPERTIES_FILENAME);
		myComboBox = comboBox;
		myTurtle = turtle;
		this.pen_color = pen_color;
		initialize();
	}
	
	private void initialize() {
		initiateColorMap();
		setDefaultPenColor();
		choosePenColor();
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
	
	private void setDefaultPenColor() {
		myComboBox.getSelectionModel().select(BLACK);
	}
	
	private void choosePenColor() {
    	myComboBox.setOnAction((Event ev) -> {
    		pen_color = (String) myComboBox.getSelectionModel().getSelectedItem();
    	});
	}
	
	public void setPenColor() {
		myTurtle.setPenColor(COLOR_HEADING + color_map.get(pen_color));
//		Display.setPenColor(COLOR_HEADING + color_map.get(color));
	}
}