package commands;

import java.awt.Point;
import java.util.List;
import turtle.Turtle;

public class SETXY implements Command{
	public SETXY() {
		//do something here
	}
	
	@Override
	public double Execute(Turtle turtle, List<Double> args) {
		double original_x = turtle.getXLocation();
		double original_y = turtle.getYLocation();
		double next_x = args.get(0);
		double next_y = args.get(1);
		turtle.setXLocation(next_x);
		turtle.setYLocation(next_y);
		Point next_point = new Point();
		next_point.setLocation(next_x,  next_y);
		turtle.addNextPoint(next_point);
		return Math.sqrt(Math.abs(original_x - next_x) * Math.abs(original_x - next_x)
						+ Math.abs(original_y - next_y) * Math.abs(original_y - next_y));
	}
}