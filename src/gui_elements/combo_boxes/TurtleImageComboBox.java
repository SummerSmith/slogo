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

	private static final String PROPERTIES_FILENAME = "turtle_image_combo_box.properties";
	private static ComboBox myComboBox;
	private Group myRoot;
	private Turtle myTurtle;
	private String image_selection;
	private final static int OLD_IMAGEVIEW_INDEX = 0;
	
	public TurtleImageComboBox(ComboBox comboBox, Group root, Turtle turtle) {
		super(comboBox, root, PROPERTIES_FILENAME);
		myComboBox = comboBox;
		myRoot = root;
		myTurtle = turtle;
		initialize();
	}
	
	private void initialize() {
		setDefaultImage();
		chooseImage();
	}
	
	private void setDefaultImage() {
		ObservableList<String> combo_box_items = myComboBox.getItems();
		String image_name = myTurtle.getImageName();
		myComboBox.getSelectionModel().select(combo_box_items.indexOf(image_name));
	}
	
	private void chooseImage() {
    	myComboBox.setOnAction((Event ev) -> {
    		image_selection = (String) myComboBox.getSelectionModel().getSelectedItem();
    	});
	}
	
	public void setImage() {
		ObservableList<Node> pane_root_children = TurtleWindow.getPaneRoot().getChildren();
		if(image_selection == null)
			return;
		ImageView imageView = new TurtleImageClass(image_selection, myRoot, myTurtle).getImageView();
		setNewTurtleProperties(myTurtle, (ImageView) pane_root_children.get(OLD_IMAGEVIEW_INDEX), imageView);
		pane_root_children.set(OLD_IMAGEVIEW_INDEX, imageView);
        myTurtle.setImageView(imageView);
        myTurtle.setImageName(image_selection);
	}
	
	private void setNewTurtleProperties(Turtle turtle, ImageView oldImageView, ImageView newImageView) {
		newImageView.setLayoutX(oldImageView.getLayoutX());
		newImageView.setLayoutY(oldImageView.getLayoutY());
		newImageView.setRotate(oldImageView.getRotate());
	}
}