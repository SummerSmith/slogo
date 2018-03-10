package gui_elements.buttons;

import java.util.ArrayList;
import java.util.HashMap;

import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import turtle.Turtle;
import user_data.UserHistory;
import windows.CommandWindow;
import windows.TurtleWindow;

public class RedoButton extends DefaultButton {

	private static final String PROPERTIES_FILENAME = "redo_button.properties";
	private Button myButton;
		
	public RedoButton(Button button, Group root) {
		super(button, root, PROPERTIES_FILENAME);
		myButton = button;
		setButtonAction();
	}

	@Override
	public void setButtonAction() {
    	myButton.setOnAction(value -> {
    		updateLines();
    		updateTurtle();
    	});
	}
	
	private void updateLines() {
		if(UserHistory.getLHPointer() == UserHistory.getLineHistory().size() - 1)
			return;
		UserHistory.setLHPointer(UserHistory.getLHPointer() + 1);
		int lh_pointer = UserHistory.getLHPointer();		
		HashMap<Integer, ArrayList<Line>> line_history = UserHistory.getLineHistory();		
		TurtleWindow.getPaneRoot().getChildren().addAll(line_history.get(lh_pointer));
	}
	
	private void updateTurtle() {
		if(UserHistory.getTPHPointer() == UserHistory.getTurtlePropertiesHistory().size() - 1) {
			return;
		}
		UserHistory.setTPHPointer(UserHistory.getTPHPointer() + 1);
		int tph_pointer = UserHistory.getTPHPointer();
		HashMap<Integer, HashMap<Turtle, Double[]>> turtle_properties_history = UserHistory.getTurtlePropertiesHistory();
		HashMap<Turtle, Double[]> turtle_properties_map = turtle_properties_history.get(tph_pointer);
		Turtle turtle = turtle_properties_map.keySet().iterator().next();
		double x_location = turtle_properties_map.get(turtle)[0];
		double y_location = turtle_properties_map.get(turtle)[1];
		double heading = turtle_properties_map.get(turtle)[2];
		ImageView imageView = turtle.getImageView();
    	imageView.setLayoutX(x_location);
    	imageView.setLayoutY(y_location);
    	imageView.setRotate(heading);
    	turtle.setXLocation(x_location - (double) TurtleWindow.getInitialTurtleX());
    	turtle.setYLocation(y_location - (double) TurtleWindow.getInitialTurtleY());
    	System.out.println(TurtleWindow.getInitialTurtleX() + " " + TurtleWindow.getInitialTurtleY());
    	System.out.println(turtle.getXLocation() + " " + turtle.getYLocation());
    	turtle.setHeading(heading);
	}
}