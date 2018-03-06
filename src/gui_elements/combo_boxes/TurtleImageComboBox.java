package gui_elements.combo_boxes;

import image_classes.TurtleImageClass;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.image.ImageView;
import slogo_team12.Display;
import turtle.Turtle;
import windows.TurtleWindow;

public class TurtleImageComboBox extends ComboBoxes {

	private static String properties_filename = "turtle_image_combo_box.properties";
	private ComboBox myComboBox;
	private Group myRoot;
	private final String IMAGE1 = "turtle_image1";
	private final int OLD_IMAGEVIEW = 0;
	
	public TurtleImageComboBox(ComboBox comboBox, Group root) {
		super(comboBox, root, properties_filename);
		myComboBox = comboBox;
		myRoot = root;
		initialize();
	}
	
	private void initialize() {
		setDefaultImage();
		chooseImage();
	}
	
	private void setDefaultImage() {
		myComboBox.getSelectionModel().select(IMAGE1);
	}
	
	private void chooseImage() {
//    	myComboBox.setOnAction((Event ev) -> {
//    		String image = (String) myComboBox.getSelectionModel().getSelectedItem();
//    		ObservableList<Node> pane_root_children = TurtleWindow.getPaneRoot().getChildren();
//    		TurtleImageClass turtle_image_object = new TurtleImageClass(image, myRoot);
////    		setNewTurtleProperties(myTurtle, (ImageView) pane_root_children.get(OLD_IMAGEVIEW), turtle_image_object.getImageView());
//    		pane_root_children.set(OLD_IMAGEVIEW, turtle_image_object.getImageView());
////    		Display.setImageView(turtle_image_object.getImageView());
//    	});
	}
	
//	private void setNewTurtleProperties(Turtle turtle, ImageView oldImageView, ImageView newImageView) {
//		newImageView.setLayoutX(oldImageView.getLayoutX());
//		newImageView.setLayoutY(oldImageView.getLayoutY());
//		newImageView.setRotate(oldImageView.getRotate());
//	}
}