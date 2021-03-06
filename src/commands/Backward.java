package commands;
import point.Point;
import java.util.List;
import turtle.Turtle;

public class Backward implements Command{
	public Backward() {
		//do something here
	}
	
	public double Execute(Turtle turtle, List<Double> args) {
		double x_original = turtle.getXLocation();
		double y_original = turtle.getYLocation();
		Double direction = turtle.getRadian();
		double distance = args.get(0);
		Double x_next = x_original - distance * Math.sin(direction);
		Double y_next = y_original + distance * Math.cos(direction);
		Point next_point = new Point();
		next_point.setLocation(x_next, y_next);
		turtle.setLocation(next_point);
		return distance;
	}
}