package commands;
import java.util.List;
import java.util.ResourceBundle;
import turtle.Turtle;

public class SetPenSize implements Command{
	private final String PROPERTY_FILENAME = "resources.display/PenColor";
	private ResourceBundle myResources;
	
	public SetPenSize() {
		
	}
	
	public double Execute(Turtle turtle, List<Double> args){
		turtle.setPenThickness(args.get(0));
		return 0;
	}
}