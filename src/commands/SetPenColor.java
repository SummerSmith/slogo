package commands;
import java.util.List;
import java.util.ResourceBundle;
import turtle.Turtle;

public class SetPenColor implements Command{
	private final String PROPERTY_FILENAME = "resources.display/PenColor";
	private ResourceBundle myResources;
	
	public SetPenColor() {
		
	}
	
	public double Execute(Turtle turtle, List<Double> args){
		String index = Double.toString(args.get(0));
		myResources = ResourceBundle.getBundle(PROPERTY_FILENAME);
		String color_name = myResources.getString(index);
		Turtle.setPenColor(color_name);
		return 0;
	}
}