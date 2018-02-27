package commands;

import java.awt.Point;
import java.util.List;
import turtle.Turtle;

public class FORWARD implements Command{
	public FORWARD() {

	}
	
	@Override
	public void Execute(Turtle turtle, List<Double> args) {
		double x_original = turtle.getXLocation();
		double y_original = turtle.getYLocation();
		Double direction = turtle.getHeading();
		double distance = args.get(0);
		Double x_next = x_original + distance * Math.sin(direction);
		Double y_next = y_original + distance * Math.cos(direction);
		turtle.setXLocation(x_next);
		turtle.setYLocation(y_next);
		Point next_point = new Point();
		next_point.setLocation(x_next, y_next);
		turtle.addNextPoint(next_point);
		//return new Double(distance);
	}
}
