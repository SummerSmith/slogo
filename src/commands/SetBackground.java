package commands;
import slogo_team12.Display;
import java.util.List;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import javafx.scene.paint.Paint;
import turtle.Turtle;
import error.Error;

public class SetBackground implements Command{
	private final String PROPERTY_FILENAME = "resources.display/BackgroundColor";
	private ResourceBundle myResources;
	
	public SetBackground() {
		
	}
	
	public double Execute(Turtle turtle, List<Double> args){
		try {
			String index = Double.toString(args.get(0));
			myResources = ResourceBundle.getBundle(PROPERTY_FILENAME);
			String color_name = myResources.getString(index);
			Display.setBackgroundColor(color_name);
			return 0;
		}catch(MissingResourceException e) {
			Exception e_0 = new Exception("Wrong arguments!");
			new Error(e_0);
			return -Double.MAX_VALUE;
		}
	}
}