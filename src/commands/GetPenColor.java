package commands;
import java.util.Enumeration;
import java.util.List;
import java.util.ResourceBundle;
import turtle.Turtle;

public class GetPenColor implements Command{
	private final String PROPERTY_FILENAME = "resources.display/PenColor";
	private ResourceBundle myResources;
	
	public GetPenColor() {
		
	}
	
	public double Execute(Turtle turtle, List<Double> args){
		myResources = ResourceBundle.getBundle(PROPERTY_FILENAME);
		Enumeration<String> iter = myResources.getKeys();
		String pen_color = Turtle.getPenColor();
		System.out
		double res = 0;
	    while (iter.hasMoreElements()) {
	            String index = iter.nextElement();
	            String color = myResources.getString(index);
	            if(color.equals(pen_color)) {
	            		res = Double.parseDouble(index);
	            		break;
	            }
	    }
	    return res == 0 ? (Double)null : res;
	}
}