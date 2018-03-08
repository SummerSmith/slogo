package commands;
import java.util.List;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import turtle.Turtle;
import error.Error;

public class SetPenColor implements Command{
	private final String PROPERTY_FILENAME = "resources.display/PenColor";
	private ResourceBundle myResources;
	
	public SetPenColor() {
		
	}
	
	public double Execute(Turtle turtle, List<Double> args){
		try {
			String index = Double.toString(args.get(0));
			myResources = ResourceBundle.getBundle(PROPERTY_FILENAME);
			String color_name = myResources.getString(index);
			turtle.setPenColor(color_name);
			return 0;
		}catch(MissingResourceException e) {
			Exception e_0 = new Exception("Wrong arguments!");
			new Error(e_0);
			return -Double.MAX_VALUE;
		}
	}
}