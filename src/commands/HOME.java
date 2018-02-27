package commands;

import java.awt.Point;
import java.util.List;
import turtle.Turtle;

public class HOME implements Command{
	public HOME() {
		//do something here
	}
	
	public double Execute(Turtle turtle, List<Double> args) {
		double original_x = turtle.getXLocation();
		double original_y = turtle.getYLocation();
		Point center = new Point(0,0);
		turtle.setLocation(center);
		turtle.addNextPoint(center);
		double distance = Math.sqrt( original_x * original_x + original_y * original_y );
		return distance;
	}
}
