package commands;
import point.Point;
import java.util.List;
import turtle.Turtle;

public class SetPosition implements Command{
	public SetPosition() {
		//do something here
	}
	
	@Override
	public double Execute(Turtle turtle, List<Double> args) {
		double original_x = turtle.getXLocation();
		double original_y = turtle.getYLocation();
		double next_x = args.get(0);
		double next_y = args.get(1);
		Point next_point = new Point();
		next_point.setLocation(next_x,  next_y);
		turtle.setLocation(next_point);
		turtle.addNextPoint(next_point);
		return Math.sqrt(Math.abs(original_x - next_x) * Math.abs(original_x - next_x)
						+ Math.abs(original_y - next_y) * Math.abs(original_y - next_y));
	}
}