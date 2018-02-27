package commands;

import java.awt.Point;
import java.util.List;
import turtle.Turtle;

public class Right implements Command{
	public Right() {
		//do something here
	}
	
	@Override
	public double Execute(Turtle turtle, List<Double> args) {
		double degrees = turtle.getHeading();
		double new_degrees = degrees - args.get(0);
		turtle.setHeading(new_degrees);
		return args.get(0);
	}
}