package commands;

import java.awt.Point;
import java.util.List;
import turtle.Turtle;

public class SetHeading implements Command{
	public SetHeading() {
		//do something here
	}
	
	@Override
	public double Execute(Turtle turtle, List<Double> args) {
		double original_heading = turtle.getHeading();
		double new_heading = args.get(0);
		turtle.setHeading(new_heading);
		return Math.abs(new_heading - original_heading);
	}
}