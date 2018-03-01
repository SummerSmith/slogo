package commands;
import point.Point;
import java.util.List;

import javafx.scene.image.ImageView;
import slogo_team12.Display;
import turtle.Turtle;
import windows.TurtleWindow;

public class ClearScreen implements Command {

	public ClearScreen() {

	}
	
	@Override
	public double Execute(Turtle turtle, List<Double> args) {
		turtle.getTurtleLineMap().clear();
		turtle.getNextPoints().clear();
		Point old_location = turtle.getLocation();
		turtle.resetLocation();
		turtle.resetHeading();
		ImageView old_image_view = (ImageView) TurtleWindow.getPaneRoot().getChildren().get(0);
		TurtleWindow.getPaneRoot().getChildren().clear();
		TurtleWindow.getPaneRoot().getChildren().add(old_image_view);		

		return Math.sqrt(Math.pow(old_location.x, 2) + Math.pow(old_location.y, 2));
	}

}