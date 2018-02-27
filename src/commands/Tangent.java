package commands;

import java.awt.Point;
import java.util.List;
import turtle.Turtle;

public class Tangent implements Command{
	public Tangent() {
		//do something here
	}
	
	public double Execute(Turtle turtle, List<Double> args) {
		return Math.tan(turtle.getHeading());
	}
}