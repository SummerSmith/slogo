package commands;
import slogo_team12.Display;
import java.util.List;
import java.util.ResourceBundle;
import javafx.scene.paint.Paint;
import turtle.Turtle;

public class SetBackground implements Command{
	private final String PROPERTY_FILENAME = "resources.display/BackgroundColor";
	private ResourceBundle myResources;
	
	public SetBackground() {
		
	}
	
	public double Execute(Turtle turtle, List<Double> args){
		String index = Double.toString(args.get(0));
		myResources = ResourceBundle.getBundle(PROPERTY_FILENAME);
		String color_name = myResources.getString(index);
		Paint color = Paint.valueOf(color_name);
		Display.setBackgroundColor(color);
		return 0;
	}
}