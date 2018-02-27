package commands;

import java.awt.Point;
import java.util.List;
import turtle.Turtle;

public class ArcTangent implements Command{
	public ArcTangent() {
		//do something here
	}
	
	public double Execute(Turtle turtle, List<Double> args) {
		return Math.atan(turtle.getHeading());
	}
}