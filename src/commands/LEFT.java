package commands;

import java.awt.Point;
import java.util.List;
import turtle.Turtle;

public class LEFT implements Command{
	public LEFT() {
		//do something here
	}
	
	@Override
	public void Execute(Turtle turtle, List<Double> args) {
		double degrees = turtle.getHeading();
		double new_degrees = degrees + args.get(0);
		turtle.setHeading(degrees);
		//return new Double(distance);
	}
}