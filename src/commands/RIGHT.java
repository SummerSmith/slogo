package commands;

import java.awt.Point;
import java.util.List;
import turtle.Turtle;

public class RIGHT implements Command{
	public RIGHT() {
		//do something here
	}
	
	@Override
	public double Execute(Turtle turtle, List<Double> args) {
		double degrees = turtle.getHeading();
		double new_degrees = degrees - args.get(0);
		turtle.setHeading(degrees);
		return args.get(0);
	}
}