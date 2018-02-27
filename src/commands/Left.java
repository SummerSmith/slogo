package commands;

import java.awt.Point;
import java.util.List;
import turtle.Turtle;

public class Left implements Command{
	public Left() {
		//do something here
	}
	
	public double Execute(Turtle turtle, List<Double> args) {
		double degrees = turtle.getHeading();
		double new_degrees = degrees + args.get(0);
		turtle.setHeading(new_degrees);
		return args.get(0);
	}
}