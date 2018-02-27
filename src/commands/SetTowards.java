package commands;

import java.awt.Point;
import java.util.List;
import turtle.Turtle;

public class SetTowards implements Command{
	public SetTowards() {
		//do something here
	}
	
	@Override
	public double Execute(Turtle turtle, List<Double> args) {
		double x_original = turtle.getXLocation();
		double y_original = turtle.getYLocation();
		double x_next = args.get(0);
		double y_next = args.get(1);
		double original_direction = turtle.getHeading();
		double direction = Math.atan( (y_next - y_original) / (x_next - x_original));
		turtle.setHeading(direction);
		return Math.abs(direction - original_direction);
	}
}